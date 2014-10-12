package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Order {
	@Id
	@GeneratedValue
	private int id;
        @Temporal(TemporalType.DATE)
	private Date date;
    @ManyToOne
	private Customer customer;
    @OneToMany
	private List<OrderLine> orderLines;// = new ArrayList<OrderLine>();
	
	

	public Order() {
		super();
	}

	public Order(Date date, Customer customer) {
		super();
		this.date = date;
		this.customer = customer;
		this.orderLines = new ArrayList<OrderLine>();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}