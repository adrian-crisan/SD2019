package ro.utcn.sd.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.utcn.sd.dao.RequestDao;
import ro.utcn.sd.dao.impl.hibernate.util.HibernateUtil;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public class HibernateRequestDao implements RequestDao {
	
	 private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Request find(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Request> requests = null;

		try {
			tx = session.beginTransaction();
			Query<Request> query = session.createQuery("FROM Request WHERE id = :id");
			query.setParameter("id", request.getId());
			requests = query.list();
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return requests != null && !requests.isEmpty() ? requests.get(0) : null;
	}

	@Override
	public List<Request> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Request> requests = null;
		try {
			tx = session.beginTransaction();
			requests = session.createQuery("FROM Request").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return requests;
	}
	
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Request> requests = null;
		try {
			tx = session.beginTransaction();
			Query<Request> query = session.createQuery("FROM Request WHERE parkingLot = :parkingLot");
			query.setParameter("parkingLot", parkingLot.getAddress());
			requests = query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return requests;
	}

	@Override
	public void insert(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(request);
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
	public void update(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(request);
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
	public void delete(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(request);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}		
	}

}
