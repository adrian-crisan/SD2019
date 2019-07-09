package ro.utcn.sd.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.utcn.sd.dao.ParkingLotDao;
import ro.utcn.sd.dao.impl.hibernate.util.HibernateUtil;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public class HibernateParkingLotDao implements ParkingLotDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public ParkingLot find(ParkingLot parkingLot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ParkingLot> parkingLots = null;

		try {
			tx = session.beginTransaction();
			Query<ParkingLot> query = session.createQuery("FROM ParkingLot WHERE address = :address");
			query.setParameter("address", parkingLot.getAddress());
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return parkingLots != null && !parkingLots.isEmpty() ? parkingLots.get(0) : null;
	}

	@Override
	public void delete(ParkingLot parkingLot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(parkingLot);
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
	public void update(ParkingLot parkingLot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(parkingLot);
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
	public void insert(ParkingLot parkingLot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(parkingLot);
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
	public List<ParkingLot> findAll() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ParkingLot> parkingLots = null;
		try {
			tx = session.beginTransaction();
			parkingLots = session.createQuery("FROM ParkingLot").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return parkingLots;
	}

	@Override
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}

}
