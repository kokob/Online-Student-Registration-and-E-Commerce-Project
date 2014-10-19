package cs425.yogastudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import static org.hibernate.type.StandardBasicTypes.BLOB;
import static org.hibernate.type.StandardBasicTypes.CLOB;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    
    private String productName;
    private double price;
    private String description;
    @Column(name = "productpic", columnDefinition = "longblob")
    private byte[] productImage;

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }
    

    public Product() {
        super();
    }

    public Product(String productName, double price, String description) {
        super();
        this.productName = productName;
        this.price = price;
        this.description = description;

    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
