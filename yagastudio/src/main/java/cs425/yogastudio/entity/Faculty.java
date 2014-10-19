package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FACULTY")
//@AttributeOverrides({
//    @AttributeOverride(name="userName", column=@Column(name="USERNAME")),
//    @AttributeOverride(name="passWord", column=@Column(name="PASSWORD"))
//})

@PrimaryKeyJoinColumn(name="USER_ID")
public class Faculty extends User {
//	@Id
//	@GeneratedValue
//	private int id;
	private String firstName;
	private String lastName;
	private String email;
//	private String userName;
//	private String password;
        private String gender;
	
    @OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;// = new ArrayList<Address>();
    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL)
	private List<Waiver> waiversToApprove;// = new ArrayList<Waiver>();
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private List<Section> sectionsToTeach;// = new ArrayList<Section>();
    @OneToMany(mappedBy = "advisor")
	private List<Customer> advisees;// = new ArrayList<Customer>();
	
	
	

	public Faculty() {
		super();
	}

	public Faculty(String firstName, String lastName, String gender, String email,
			String userName, String password) {
		super(userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
                this.gender = gender;
		this.email = email;
//		this.userName = userName;
//		this.password = password;
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
        public void setGender(String gender){
            this.gender = gender;
        }
        public String getGender(){
            return this.gender;
        }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getUserName() {
//		return this.userName;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getPassword() {
//		return this.password;
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
         public void addAddress(Address address){
        addresses.add(address);
    }
    
    public void removeAddress(Address address){
        addresses.remove(address);
    }
	
	

}