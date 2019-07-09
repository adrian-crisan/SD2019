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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderPart {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "native")
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "orderpart_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Orders order;
	
	@Column
	private long qty;
	
	 @ManyToMany(
			 cascade = {
					 CascadeType.PERSIST,
					 CascadeType.MERGE
			 })
	 @JoinTable(name = "orderpart_menuitem",
			 	joinColumns = @JoinColumn(name = "orderpart_id"),
			 	inverseJoinColumns = @JoinColumn(name = "menuitem_id"))
	 private List<MenuItem> items = new ArrayList<>();
}
