package ro.utcn.sd.dao.impl.hibernate;

import ro.utcn.sd.dao.CarDao;
import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.dao.ParkingLotDao;
import ro.utcn.sd.dao.ParkingSpotDao;
import ro.utcn.sd.dao.RequestDao;
import ro.utcn.sd.dao.UserDao;

public class HibernateDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() {
		return new HibernateUserDao();
	}

	@Override
	public CarDao getCarDao() {
		return new HibernateCarDao();
	}
	
	@Override
	public RequestDao getRequestDao() {
		return new HibernateRequestDao();
	}

	@Override
	public ParkingLotDao getParkingLotDao() {
		return new HibernateParkingLotDao();
	}

	@Override
	public ParkingSpotDao getParkingSpotDao() {
		return new HibernateParkingSpotDao();
	}
}
