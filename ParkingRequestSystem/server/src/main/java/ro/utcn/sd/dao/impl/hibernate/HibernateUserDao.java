package ro.utcn.sd.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ro.utcn.sd.dao.UserDao;
import ro.utcn.sd.dao.impl.hibernate.util.HibernateUtil;
import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;
import ro.utcn.sd.entities.User;

public class HibernateUserDao implements UserDao {

	 private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	 
	@Override
	public User find(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<User> users = null;

		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery("FROM User WHERE username = :username");
			query.setParameter("username", user.getUsername());
			users = query.list();
			tx.commit();
		
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}

	@Override
	public void insert(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(user);
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
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
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
	public void delete(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
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
	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public List<Request> findAllByParkingLot(ParkingLot parkingLot) {
		// TODO Auto-generated method stub
		return null;
	}

}
