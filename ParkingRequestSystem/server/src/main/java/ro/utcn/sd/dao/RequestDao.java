package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public interface RequestDao extends Dao<Request> {

	@Override
	Request find(Request request);
	
	@Override
	List<Request> findAll();
	
	@Override
	List<Request> findAllByParkingLot(ParkingLot parkingLot);
	
	@Override 
	void insert(Request request);
	
	@Override
	void update(Request request);
	
	@Override
	void delete(Request request);
}
