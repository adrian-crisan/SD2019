package ro.utcn.sd.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ro.utcn.sd.dao.CarDao;
import ro.utcn.sd.dao.impl.jdbc.util.ConnectionFactory;
import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;
import ro.utcn.sd.entities.User;

public class JdbcCarDao implements CarDao {

	static final Logger LOGGER = Logger.getLogger(Car.class.getName());
	private final static String findByVinStatementString = "SELECT * FROM car where vin = ?";
	private final static String insertStatementString = "INSERT INTO car (car_id, pti, vin, user_id) VALUES (?, ?, ?, ?)";
	private final static String updateStatementString = "UPDATE car SET pti = ? WHERE vin = ?";
	private final static String deleteStatementString = "DELETE FROM car where vin = ?";
	private final static String findAllStatementString = "SELECT * FROM car";
	
	List<Car> cars = new ArrayList<>();
	
	@Override
	public Car find(Car car) {
		Car searchedCar = new Car();
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findByVinStatement = null;
		ResultSet resultSet = null;
		
		try {
			findByVinStatement = dbConnection.prepareStatement(findByVinStatementString);
			findByVinStatement.setString(1, car.getVin());
			
			resultSet = findByVinStatement.executeQuery();
			while (resultSet.next()) {
				
				long searchedCarId = resultSet.getLong("car_id");
				String searchedCarVin = resultSet.getString("vin");
				String searchedCarPti = resultSet.getString("pti");
				long searchedCarUserId = resultSet.getLong("user_id");
				
				User user = new User();
				user.setId(searchedCarUserId);
				searchedCar.setId(searchedCarId);
				searchedCar.setVin(searchedCarVin);
				searchedCar.setPti(searchedCarPti);
				searchedCar.setUser(user);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CarJDBCDao : findByName " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(findByVinStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return searchedCar;
	}

	@Override
	public void insert(Car car) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setLong(1, car.getId());
			insertStatement.setString(2, car.getPti());
			insertStatement.setString(3, car.getVin());
			insertStatement.setLong(4, car.getUser().getId());
			
			insertStatement.execute();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CarDAO : insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}		
	}

	@Override
	public void update(Car car) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setString(1, car.getPti());
			updateStatement.setString(2, car.getVin());
			
			updateStatement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CarDAO : update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}		
	}

	@Override
	public void delete(Car car) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, car.getVin());
			
			deleteStatement.execute();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CarDAO : delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}		
	}

	@Override
	public List<Car> findAll() {
		
		Car searchedCar = new Car();
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findAllStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			findAllStatement = dbConnection.prepareStatement(findAllStatementString);
			
			resultSet = findAllStatement.executeQuery();
			while (resultSet.next()) {
				
				long searchedCarId = resultSet.getLong("car_id");
				String searchedCarVin = resultSet.getString("vin");
				String searchedCarPti = resultSet.getString("pti");
				long searchedCarUserId = resultSet.getLong("user_id");
				
				User user = new User();
				user.setId(searchedCarUserId);
				searchedCar.setId(searchedCarId);
				searchedCar.setVin(searchedCarVin);
				searchedCar.setPti(searchedCarPti);
				searchedCar.setUser(user);
				
				cars.add(searchedCar);
		
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CarDAO : findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(findAllStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return cars;
	}

	@Override
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}

}
