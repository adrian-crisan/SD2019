package ro.utcn.sd.business;

import java.util.ArrayList;
import java.util.List;

import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.ParkingSpot;
import ro.utcn.sd.entities.Request;
import ro.utcn.sd.entities.User;
import ro.utcn.sd.output.RequestDTO;
import ro.utcn.sd.output.ViewRequestsByParkingLotDTO;


public class AdminService {

	/*public ViewParkingLotsDTO viewParkingLots(DaoFactory daoFactory) {
		
		List<ParkingLot> allParkingLots = new ArrayList<>();
		allParkingLots = daoFactory.getParkingLotDao().findAll();
	
		ViewParkingLotsDTO dto = new ViewParkingLotsDTO(allParkingLots);
		
		return dto;
	}
	*/
	public ViewRequestsByParkingLotDTO viewRequestsForParkingLot(String parkingLot, DaoFactory daoFactory) {
		
		ParkingLot dummy = new ParkingLot();
		dummy.setAddress(parkingLot);
		
		List<Request> toFind = daoFactory.getRequestDao().findAllByParkingLot(dummy);
		List<RequestDTO> req = new ArrayList<>();
		
		for (Request r : toFind) {
			req.add(new RequestDTO(r.getDate(), r.getState(), r.getUsername(), r.getCar().getVin(), r.getParkingLot()));
		}
		
		ViewRequestsByParkingLotDTO dto = new ViewRequestsByParkingLotDTO(req);
		return dto;
	}
	
	public void assignParkingSpot(User user, Car car, ParkingLot parkingLot, DaoFactory daoFactory) {
		
		ParkingSpot parkingSpot = new ParkingSpot();
		parkingSpot.setFree(false);
		parkingSpot.setName(user.getName());
		parkingSpot.setVin(car.getVin());
		parkingSpot.setParkingLot(parkingLot);
		
		daoFactory.getParkingSpotDao().update(parkingSpot);
	}
	
	public void retractParkingSpot(ParkingSpot parkingSpot, DaoFactory daoFactory) {
		
		parkingSpot.setFree(true);
		parkingSpot.setName("");
		parkingSpot.setVin("");
		
		daoFactory.getParkingSpotDao().update(parkingSpot);
	}
	
}
