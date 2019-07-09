package ro.utcn.sd.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PARKINGSPOT")
public class ParkingSpot {

	 @Id
	    @GeneratedValue(
	            strategy = GenerationType.AUTO,
	            generator = "native"
	    )
	    @GenericGenerator(
	            name = "native",
	            strategy = "native"
	    )
	    @Column(name = "parkingspot_id")
	    private long id;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parkingLot_id")
	private ParkingLot parkingLot; 
	
	@Column(name = "number")
	private long number;
	 
	@Column(name = "isFree")
	private boolean isFree;
	 
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "car_vin")
	private String vin;
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
}
