package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "native")
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "user_id")
	private long id;
	
	@Column 
	private String username;
	
	@Column 
	private String password;
	
	@Column 
	private String email;
	
	@Column
	private boolean isAdmin;
	
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @OneToMany(
	    		mappedBy = "user",
	    		cascade = CascadeType.ALL
	    		)
	 private List<Orders> orders = new ArrayList<>();
	 
	
	 public void addOrder(Orders order) {
	    	orders.add(order);
	    	order.setUser(this);
	    }
	    
	    public void removeOrder(Orders order) {
	    	orders.remove(order);
	    	order.setUser(null);
	    }
}
