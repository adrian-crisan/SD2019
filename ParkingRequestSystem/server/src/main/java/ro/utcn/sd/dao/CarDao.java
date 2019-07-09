package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.Car;

public interface CarDao extends Dao<Car> {

	@Override
	Car find(Car car);
	
	@Override
	List<Car> findAll();
	
	@Override 
	void insert(Car car);
	
	@Override
	void update(Car car);
	
	@Override
	void delete(Car car);
}
