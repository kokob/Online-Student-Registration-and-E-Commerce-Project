package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Faculty {
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	
    @OneToMany
	private List<Address> addresses;// = new ArrayList<Address>();
    @OneToMany(mappedBy = "faculty")
	private List<Waiver> waiversToApprove;// = new ArrayList<Waiver>();
    @OneToMany(mappedBy = "teacher")
	private List<Section> sectionsToTeach;// = new ArrayList<Section>();
    @OneToMany(mappedBy = "advisor")
	private List<Customer> advisees;// = new ArrayList<Customer>();
	
	
	

	public Faculty() {
		super();
	}

	public Faculty(String firstName, String lastName, String email,
			String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.addresses = new ArrayList<Address>();
		this.waiversToApprove = new ArrayList<Waiver>();
		this.sectionsToTeach = new ArrayList<Section>();
		this.advisees = new ArrayList<Customer>();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Waiver> getWaiversToApprove() {
		return waiversToApprove;
	}

	public void setWaiversToApprove(ArrayList<Waiver> waiversToApprove) {
		this.waiversToApprove = waiversToApprove;
	}

	public List<Section> getSectionsToTeach() {
		return sectionsToTeach;
	}

	public void setSectionsToTeach(ArrayList<Section> sectionsToTeach) {
		this.sectionsToTeach = sectionsToTeach;
	}

	public List<Customer> getAdvisees() {
		return advisees;
	}

	public void setAdvisees(ArrayList<Customer> advisees) {
		this.advisees = advisees;
	}
	
	

}