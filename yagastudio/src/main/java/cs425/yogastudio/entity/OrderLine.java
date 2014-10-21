package cs425.yogastudio.entity;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
    @OneToOne
	private Product product;// = new ArrayList<Product>();

    
	@ManyToOne
        private ShoppingCart shoppingCart;
	

	public OrderLine() {
		super();
	}

	public OrderLine(int quantity, Product product, ShoppingCart shoppingCart) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.shoppingCart= shoppingCart;
	}

        public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}