package cs425.yogastudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author kokob
 *
 */
@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private int id;
       
	private String state;
   
	private String zip;
      
	private String street;
        
        private String city;
	
	public Address() {
		super();
	}

	public Address(String state, String zip, String street, String city) {
		super();
		this.state = state;
		this.zip = zip;
		this.street = street;
                this.city = city;
	}

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		return this.zip;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return this.street;
	}
}