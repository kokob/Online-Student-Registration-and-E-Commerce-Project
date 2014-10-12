package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private int id;
	
	private double totalPrice;
    @OneToOne
	private Customer customer;
    @OneToMany
	private List<OrderLine> orderLines;// = new ArrayList<OrderLine>();
	
	

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Customer customer) {
		super();
		
		this.totalPrice = 0.0;
		this.customer = customer;
		this.orderLines = new ArrayList<OrderLine>();
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalPrice() {
		return this.totalPrice;
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