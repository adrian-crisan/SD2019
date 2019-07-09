package ro.utcn.sd.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MenuItem {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "native")
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "menuitem_id")
	private long id;
	
	@Column
	private double price;
	
	@Column 
	private String name;
	
	@Column
	private String type;
	
	@ManyToMany(mappedBy = "items")
	private List<OrderPart> orderParts = new ArrayList<>();
}
