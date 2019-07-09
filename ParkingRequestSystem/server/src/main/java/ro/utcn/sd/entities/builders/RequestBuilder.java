package ro.utcn.sd.entities.builders;

import java.util.List;
import java.util.Objects;

import ro.utcn.sd.entities.Car;
import ro.utcn.sd.entities.ParkingLot;
import ro.utcn.sd.entities.Request;

public class RequestBuilder {

	private Request underConstruction;
	
	private RequestBuilder() {
		underConstruction = new Request();
	}
	
	public static RequestBuilder createRequestBuilder() {
		return new RequestBuilder();
	}
	
	public RequestBuilder id(long id) {
		underConstruction.setId(id);
		return this;
	}
	
	public RequestBuilder date(String date) {
		underConstruction.setDate(date);
		return this;
	}
	
	public RequestBuilder state(String state) {
		underConstruction.setState(state);
		return this;
	}
	
	public RequestBuilder username(String username) {
		underConstruction.setUsername(username);
		return this;
	}
	
	public RequestBuilder car(Car car) {
		underConstruction.setCar(car);
		return this;
	}
	
	public RequestBuilder parkingLots(List<ParkingLot> parkingLots) {
		underConstruction.setParkingLots(parkingLots);
		return this;
	}
	
	public Request build() {
		checkValid(underConstruction);
		return underConstruction;
	}
	
	 private void checkValid(Request underConstruction) {
		 Objects.requireNonNull(underConstruction.getCar());
		 Objects.requireNonNull(underConstruction.getUsername());
	 }
}
