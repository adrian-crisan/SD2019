package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.ParkingSpot;

public interface ParkingSpotDao extends Dao<ParkingSpot> {

	@Override
	ParkingSpot find(ParkingSpot parkingSpot);
	
	@Override
	List<ParkingSpot> findAll();
	
	@Override 
	void insert(ParkingSpot parkingSpot);
	
	@Override
	void update(ParkingSpot parkingSpot);
	
	@Override
	void delete(ParkingSpot parkingSpot);
}
