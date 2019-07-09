package ro.utcn.sd.dao.impl.jdbc;

import ro.utcn.sd.dao.CarDao;
import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.dao.ParkingLotDao;
import ro.utcn.sd.dao.ParkingSpotDao;
import ro.utcn.sd.dao.RequestDao;
import ro.utcn.sd.dao.UserDao;

public class JdbcDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() {
		
		return new JdbcUserDao();
	}

	@Override
	public CarDao getCarDao() {
		
		return new JdbcCarDao();
	}

	@Override
	public RequestDao getRequestDao() {
		
		return new JdbcRequestDao();
	}

	@Override
	public ParkingLotDao getParkingLotDao() {
		return new JdbcParkingLotDao();
	}

	@Override
	public ParkingSpotDao getParkingSpotDao() {
		return new JdbcParkingSpotDao();
	}
}
