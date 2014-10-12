package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Section {
	@Id
	@GeneratedValue
	private int id;
	private int seatsAvailable;

    @ManyToOne
	private Course course;
	
    @ManyToMany
	private List<Customer> waitlisted;// = new ArrayList<Customer>();
    @ManyToOne
	private Faculty teacher;
    @ManyToMany
    
	private List<Customer> enrolled;// = new ArrayList<Customer>();
	
	

	public Section() {
		super();
	}

	public Section(int seatsAvailable, Course course, Faculty teacher) {
		super();
		this.seatsAvailable = seatsAvailable;
		this.course = course;
		this.waitlisted = new ArrayList<Customer>();
		this.teacher = teacher;
		this.enrolled = new ArrayList<Customer>();
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getSeatsAvailable() {
		return this.seatsAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Customer> getWaitlisted() {
		return waitlisted;
	}

	public void setWaitlisted(ArrayList<Customer> waitlisted) {
		this.waitlisted = waitlisted;
	}

	public Faculty getTeacher() {
		return teacher;
	}

	public void setTeacher(Faculty teacher) {
		this.teacher = teacher;
	}

	public List<Customer> getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(ArrayList<Customer> enrolled) {
		this.enrolled = enrolled;
	}
	
	
	
}