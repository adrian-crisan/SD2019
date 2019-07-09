package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.ParkingLot;

public interface ParkingLotDao extends Dao<ParkingLot> {
	
	@Override
	ParkingLot find(ParkingLot parkingLot);
	
	@Override
	List<ParkingLot> findAll();
	
	@Override 
	void insert(ParkingLot parkingLot);
	
	@Override
	void update(ParkingLot parkingLot);
	
	@Override
	void delete(ParkingLot parkingLot);

}
