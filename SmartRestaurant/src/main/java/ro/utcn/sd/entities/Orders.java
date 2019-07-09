package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "native")
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "order_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column
	private String date;
	
	 @LazyCollection(LazyCollectionOption.FALSE)
	 @OneToMany(
	    		mappedBy = "order",
	    		cascade = CascadeType.ALL
	    		)
	 private List<OrderPart> orderPart = new ArrayList<>();
	 
	 @OneToOne(
			 mappedBy = "order",
			 cascade = CascadeType.ALL
			 )
	 private Payment payment;
}
