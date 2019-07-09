package ro.utcn.sd.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.utcn.sd.dao.ParkingSpotDao;
import ro.utcn.sd.dao.impl.hibernate.util.HibernateUtil;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.ParkingSpot;
import ro.utcn.sd.entities.Request;

public class HibernateParkingSpotDao implements ParkingSpotDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public ParkingSpot find(ParkingSpot parkingSpot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ParkingSpot> parkingSpots = null;

		try {
			tx = session.beginTransaction();
			Query<ParkingSpot> query = session.createQuery("FROM ParkingSpot WHERE number = :number");
			query.setParameter("address", parkingSpot.getNumber());
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return parkingSpots != null && !parkingSpots.isEmpty() ? parkingSpots.get(0) : null;
	}

	@Override
	public List<ParkingSpot> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ParkingSpot> parkingSpots = null;
		try {
			tx = session.beginTransaction();
			parkingSpots = session.createQuery("FROM ParkingSpot").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return parkingSpots;
	}

	@Override
	public void insert(ParkingSpot parkingSpot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(parkingSpot);
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
	public void update(ParkingSpot parkingSpot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(parkingSpot);
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
	public void delete(ParkingSpot parkingSpot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(parkingSpot);
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
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}

}
