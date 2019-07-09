package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PARKINGLOT")
public class ParkingLot {
	
	 @Id
	    @GeneratedValue(
	            strategy = GenerationType.AUTO,
	            generator = "native"
	    )
	    @GenericGenerator(
	            name = "native",
	            strategy = "native"
	    )
	    @Column(name = "parkinglot_id")
	    private long id;

	 @Column(name = "address")
	 private String address;
	 
	 @Column(name = "spots_no")
	 private long spots;

	@ManyToMany(mappedBy = "parkingLots")
	 private List<Request> requests = new ArrayList<>();

	 @OneToMany(
	    		mappedBy = "parkingLot",
	    		cascade = CascadeType.ALL,
	    		orphanRemoval = true
	    		)
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
	 
	public void addRequest(Request request) {
		requests.add(request);
		request.getParkingLots().add(this);
	}
	
	public void removeRequest(Request request) {
		requests.remove(request);
		request.getParkingLots().remove(this);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	 
	public long getSpots() {
		return spots;
	}

	public void setSpots(long spots) {
		this.spots = spots;
	}

}
