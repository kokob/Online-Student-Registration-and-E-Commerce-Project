package cs425.yogastudio.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="CUSTOMER")
//@AttributeOverrides({
//    @AttributeOverride(name="userName", column=@Column(name="USERNAME")),
//    @AttributeOverride(name="passWord", column=@Column(name="PASSWORD"))
//})

@PrimaryKeyJoinColumn(name="USER_ID")

public class Customer extends User {

//    @Id

//    @GeneratedValue
//    private int id;
    private String firstName;
    private String lastName;
    private String email;
//    private String userName;
//    private String password;

    private boolean isEnrolled;
    
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "enrolled")
    private List<Section> sectionsEnrolled;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "waitlisted")
    private List<Section> sectionsWaitlisted;
    
    @ManyToOne
    private Faculty advisor;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;// = new ArrayList<Address>();
    @OneToMany(mappedBy = "customer")
    private List<Waiver> waivers;// = new ArrayList<Waiver>();
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<CourseTaken> coursesTaken;// = new ArrayList<CourseTaken>();
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;// = new ArrayList<Order>();
    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;
    
    

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String email,
            String userName, String password) {
        super(userName, password);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.userName = userName;
//        this.password = password;
        this.isEnrolled = false;
        this.sectionsEnrolled = new ArrayList<Section>();
        this.advisor = null;
        this.addresses = new ArrayList<Address>();
        this.waivers = new ArrayList<Waiver>();
        this.coursesTaken = new ArrayList<CourseTaken>();
        this.orders = new ArrayList<Order>();
        this.shoppingCart = new ShoppingCart(this);
        this.sectionsWaitlisted = new ArrayList<Section>();
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

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//


//    public String getUserName() {
//        return this.userName;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }










    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    public boolean isIsEnrolled() {
        return this.isEnrolled;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }






    public Faculty getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Faculty advisor) {
        this.advisor = advisor;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Waiver> getWaivers() {
        return waivers;
    }

    public void setWaivers(ArrayList<Waiver> waivers) {
        this.waivers = waivers;
    }

    public List<CourseTaken> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(ArrayList<CourseTaken> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Section> getSectionsWaitlisted() {
        return sectionsWaitlisted;
    }

    public void setSectionsWaitlisted(ArrayList<Section> sectionsWaitlisted) {
        this.sectionsWaitlisted = sectionsWaitlisted;
    }

    public List<Section> getSectionsEnrolled() {
        return sectionsEnrolled;
    }

    public void setSectionsEnrolled(ArrayList<Section> sectionsEnrolled) {
        this.sectionsEnrolled = sectionsEnrolled;
    }
    
    public void addAddress(Address address){
        addresses.add(address);
    }
    
    public void removeAddress(Address address){
        addresses.remove(address);
    }
    
    public void addSectionsWaitlisted(Section section) {
        sectionsWaitlisted.add(section);
    }

}
