package ro.utcn.sd.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ro.utcn.sd.dao.UserDao;
import ro.utcn.sd.dao.impl.jdbc.util.ConnectionFactory;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;
import ro.utcn.sd.entities.User;

public class JdbcUserDao implements UserDao {

	static final Logger LOGGER = Logger.getLogger(User.class.getName());
	private final static String findByNameStatementString = "SELECT * FROM user where username = ?";
	private final static String insertStatementString = "INSERT INTO user (user_id, email, isAdmin, name, password, username) VALUES (?, ?, ?, ?, ?, ?)";
	private final static String updateStatementString = "UPDATE user SET password = ? WHERE username = ?";
	private final static String deleteStatementString = "DELETE FROM user where username = ?";
	private final static String findAllStatementString = "SELECT * FROM user";
	
	List<User> users = new ArrayList<>();
	
	@Override
	public User find(User user) {
		User searchedUser = new User();
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findByNameStatement = null;
		ResultSet resultSet = null;
		
		try {
			findByNameStatement = dbConnection.prepareStatement(findByNameStatementString);
			findByNameStatement.setString(1, user.getUsername());
			
			resultSet = findByNameStatement.executeQuery();
			while (resultSet.next()) {
				
				int searchedUserId = resultSet.getInt("user_id");
				String searchedUserEmail = resultSet.getString("email");
				boolean searchedUserAdmin = resultSet.getBoolean("isAdmin");
				String searchedUserName = resultSet.getString("name");
				String searchedUserPassword = resultSet.getString("password");
				String searchedUserUsername = resultSet.getString("username");
				
				searchedUser.setId(searchedUserId);
				searchedUser.setEmail(searchedUserEmail);
				searchedUser.setAdmin(searchedUserAdmin);
				searchedUser.setName(searchedUserName);
				searchedUser.setPassword(searchedUserPassword);
				searchedUser.setUsername(searchedUserUsername);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "UserJDBCDao : findByName " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(findByNameStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return searchedUser;
	}

	@Override
	public void insert(User user) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setLong(1, user.getId());
			insertStatement.setString(2, user.getEmail());
			insertStatement.setBoolean(3, user.isAdmin());
			insertStatement.setString(4, user.getName());
			insertStatement.setString(5, user.getPassword());
			insertStatement.setString(6,  user.getUsername());
			
			insertStatement.execute();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "UserDAO : insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		
	}

	@Override
	public void update(User user) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setString(1, user.getPassword());
			updateStatement.setString(2, user.getUsername());
			
			updateStatement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "UserDAO : update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		
	}

	@Override
	public void delete(User user) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, user.getUsername());
			
			deleteStatement.execute();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "UserDAO : delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}		
	}

	@Override
	public List<User> findAll() {
		
		User searchedUser = new User();
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findAllStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			findAllStatement = dbConnection.prepareStatement(findAllStatementString);
			
			resultSet = findAllStatement.executeQuery();
			while (resultSet.next()) {
				
				int searchedUserId = resultSet.getInt("user_id");
				String searchedUserEmail = resultSet.getString("email");
				boolean searchedUserAdmin = resultSet.getBoolean("isAdmin");
				String searchedUserName = resultSet.getString("name");
				String searchedUserPassword = resultSet.getString("password");
				String searchedUserUsername = resultSet.getString("username");
				
				searchedUser.setId(searchedUserId);
				searchedUser.setEmail(searchedUserEmail);
				searchedUser.setAdmin(searchedUserAdmin);
				searchedUser.setName(searchedUserName);
				searchedUser.setPassword(searchedUserPassword);
				searchedUser.setUsername(searchedUserUsername);
				
				users.add(searchedUser);
		
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "UserDAO : findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(findAllStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return users;
	}

	@Override
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}

}
