package ro.utcn.sd.business;

import java.util.ArrayList;
import java.util.List;

import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;
import ro.utcn.sd.entities.Request.State;
import ro.utcn.sd.entities.User;
import ro.utcn.sd.output.RequestDTO;
import ro.utcn.sd.output.UserDTO;
import ro.utcn.sd.output.ViewRequestsByUserDTO;

public class UserService {
	
	public void registerAccount(String name, String username, String password, String email, DaoFactory daoFactory) {
		
		User user = new User();
		user.setAdmin(false);
		user.setName(name);
		user.setPassword(password);
		user.setUsername(username);
		user.setEmail(email);
		user.setCars(new ArrayList<>());
		user.setRequests(new ArrayList<>());
		
		daoFactory.getUserDao().insert(user);
	}
	
	public UserDTO login(String username, String password, DaoFactory daoFactory) {
		
		User toFind = null;
		User receivedUser = new User();
		receivedUser.setUsername(username);
		receivedUser.setPassword(password);
		
		toFind = daoFactory.getUserDao().find(receivedUser);
		if (toFind != null) {
			return new UserDTO(toFind.getId(), toFind.getUsername(), toFind.getPassword(), toFind.getEmail(), toFind.getName(), toFind.isAdmin());
		}
		return null;
	}
	
	public void addOwnedCar(User user, Car car, DaoFactory daoFactory) {
		
		user.addCar(car);
		daoFactory.getCarDao().insert(car);
	}
	
	public void removeOwnedCar(User user, Car car, DaoFactory daoFactory) {
		
		user.removeCar(car);
		daoFactory.getCarDao().delete(car);
	}
	
	public RequestDTO makeRequest(String username, String carVin, String parkingLot, String date, DaoFactory daoFactory) {
		
		Request request = new Request();
		User user = new User();
		user.setUsername(username);
		Car car = new Car();
		car.setVin(carVin);
		ParkingLot lot = new ParkingLot();
		lot.setAddress(parkingLot);
		request.setUser(user);
		request.setCar(car);
		request.addParkingLot(lot);
		request.setParkingLot(parkingLot);
		request.setDate(date);
		request.setState(State.PENDING.toString());
		request.setUsername(username);
		
		user.addRequest(request);
		car.addRequest(request);
		lot.addRequest(request);
		
		daoFactory.getRequestDao().insert(request);
		
		RequestDTO dto = new RequestDTO(date, username, State.PENDING.toString(), carVin, parkingLot);
		return dto;
	}
	
	public ViewRequestsByUserDTO viewAllRequests(User user, DaoFactory daoFactory) {
		
		List<Request> allRequests = daoFactory.getRequestDao().findAll();
		List<Request> userRequests = new ArrayList<>();
		
		for (Request r : allRequests) {
			if (r.getUsername().equals(user.getUsername())) {
				userRequests.add(r);
			}
		}
		
		//ViewRequestsByUserDTO dto = new ViewRequestsByUserDTO(userRequests);
		
		return null;
	}
	
	public void updateRequest(Request request, DaoFactory daoFactory) {
		
		daoFactory.getRequestDao().update(request);
		
	}
	
	public void deleteRequest(Request request, DaoFactory daoFactory) {
		
		daoFactory.getRequestDao().delete(request);
	}
}
