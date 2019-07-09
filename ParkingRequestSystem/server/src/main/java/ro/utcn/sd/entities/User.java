package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "user_id")
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "isAdmin")
    private boolean isAdmin;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
    		mappedBy = "user",
    		cascade = CascadeType.ALL
    		)
    private List<Car> cars = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(
    		mappedBy = "user",
    		cascade = CascadeType.ALL
    		)
    private List<Request> requests = new ArrayList<>();
    
    public void addCar(Car car) {
    	cars.add(car);
    	car.setUser(this);
    }
    
    public void removeCar(Car car) {
    	cars.remove(car);
    	car.setUser(null);
    }
    
    public void addRequest(Request request) {
    	requests.add(request);
    	request.setUser(this);
    }
    
    public void removeRequest(Request request) {
    	requests.remove(request);
    	request.setUser(null);
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
}
