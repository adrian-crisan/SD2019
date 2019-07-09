package ro.utcn.sd.dao;

import java.util.List;

import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public interface Dao<T> {
    
    T find(T objectToFind);
    
    List<T> findAll();
    
    void delete(T objectToDelete);
    
    void update(T objectToUpdate);
    
    void insert(T objectToInsert);

	List<Request> findAllByParkingLot(ParkingLot parkingLot);
}
