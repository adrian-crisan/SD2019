package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.User;

public interface UserDao extends Dao<User>{

	@Override
	User find(User user);
	
	@Override
	List<User> findAll();
	
	@Override 
	void insert(User user);
	
	@Override
	void update(User user);
	
	@Override
	void delete(User user);
}
