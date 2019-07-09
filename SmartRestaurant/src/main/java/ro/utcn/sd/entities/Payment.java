package ro.utcn.sd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator = "native")
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "payment_id")
	private long id;
	
	@Column
	private String type;
	
	@Column
	private double amount;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders order;
}
