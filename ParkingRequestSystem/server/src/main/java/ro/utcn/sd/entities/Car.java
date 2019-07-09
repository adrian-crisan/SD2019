package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "CAR")
public class Car {
	
	 @Id
	    @GeneratedValue(
	            strategy = GenerationType.AUTO,
	            generator = "native"
	    )
	    @GenericGenerator(
	            name = "native",
	            strategy = "native"
	    )
	    @Column(name = "car_id")
	    private long id;
	 
	 @Column(name = "vin")
	 private String vin;
	 
	 @Column(name = "pti") 
	 private String pti;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	 @LazyCollection(LazyCollectionOption.FALSE)
	 @OneToMany(
	    		mappedBy = "car",
	    		cascade = CascadeType.ALL
	    		)
	private List<Request> requests = new ArrayList<>();
	 
	public void addRequest(Request request) {
	    requests.add(request);
	    request.setCar(this);
	}
	    
	public void removeRequest(Request request) {
		requests.remove(request);
	    request.setCar(null);
	}
	    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPti() {
		return pti;
	}

	public void setPti(String pti) {
		this.pti = pti;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
