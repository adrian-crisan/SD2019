package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "REQUEST")
public class Request {


	public enum State {
		PENDING,
		CONFIRMED,
		CANCELLED
	}

	 @Id
	    @GeneratedValue(
	            strategy = GenerationType.AUTO,
	            generator = "native"
	    )
	    @GenericGenerator(
	            name = "native",
	            strategy = "native"
	    )
	    @Column(name = "request_id")
	    private long id;
	 
	 @Column(name = "date")
	 private String date;
	 
	 @Column(name = "state") 
	 private String state;
	 
	 @Column(name = "username")
	 private String username;

	 @Column(name = "parkingLot")
	 private String parkingLot;
	 
	@ManyToOne(fetch = FetchType.EAGER,
			 	cascade = CascadeType.ALL)
	 @JoinColumn(name = "user_id")
	 private User user;

	 
	 @ManyToOne(fetch = FetchType.EAGER,
				cascade = CascadeType.ALL)
	 @JoinColumn(name = "car_id")
	 private Car car;
	 
	 @ManyToMany(
			 cascade = {
					 CascadeType.PERSIST,
					 CascadeType.MERGE
			 })
	 @JoinTable(name = "request_parkinglot",
			 	joinColumns = @JoinColumn(name = "request_id"),
			 	inverseJoinColumns = @JoinColumn(name = "parkinglot_id"))
	 private List<ParkingLot> parkingLots = new ArrayList<>();
	 
	public void addParkingLot(ParkingLot parkingLot) {
		parkingLots.add(parkingLot);
		parkingLot.getRequests().add(this);
	}
	
	public void removeParkingLot(ParkingLot parkingLot) {
		parkingLots.remove(parkingLot);
		parkingLot.getRequests().remove(this);
	}
	 
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(String parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	public void setParkingLots(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	 
	 public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
