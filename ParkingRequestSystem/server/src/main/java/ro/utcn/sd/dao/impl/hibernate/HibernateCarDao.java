package ro.utcn.sd.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.utcn.sd.dao.CarDao;
import ro.utcn.sd.dao.impl.hibernate.util.HibernateUtil;
import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public class HibernateCarDao implements CarDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public Car find(Car car) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Car> cars = null;

		try {
			tx = session.beginTransaction();
			Query<Car> query = session.createQuery("FROM Car WHERE vin = :vin");
			query.setParameter("vin", car.getVin());
			cars = query.list();
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return cars != null && !cars.isEmpty() ? cars.get(0) : null;
	}

	@Override
	public void insert(Car car) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(car);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}		
	}

	@Override
	public void update(Car car) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(car);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}		
	}

	@Override
	public void delete(Car car) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(car);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public List<Car> findAll() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Car> cars = null;
		try {
			tx = session.beginTransaction();
			cars = session.createQuery("FROM car").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return cars;
	}

	@Override
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}		

}
