package cs425.yogastudio.entity;

import static java.util.Objects.hash;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Waiver {

    @Id
    @GeneratedValue
    private int id;
    private String reason;
    @ManyToOne
    private Faculty faculty;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Course course;
    private WaiverStatus isApproved;

    public Waiver() {
        super();
    }

    public Waiver(String reason, Faculty faculty, Customer customer,
            Course course) {
        super();
        this.reason = reason;
        this.faculty = faculty;
        this.customer = customer;
        this.course = course;
        isApproved = WaiverStatus.PENDING;
    }

//    public boolean isIsApproved() {
//        return isApproved;
//    }
//
//    public void setIsApproved(boolean isApproved) {
//        this.isApproved = isApproved;
//    }
    public WaiverStatus getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(WaiverStatus isApproved) {
        this.isApproved = isApproved;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }else{
            if(other.getClass() != this.getClass()){
                return false;
            }
            return ((Waiver)other).getId()==this.id;
        }
        
    }
    
    public int hashCode() {
        return hash(id);
    }

}
