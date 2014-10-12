package cs425.yogastudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CourseTaken {

	@Id
	@GeneratedValue
	private int id;
    @ManyToOne
	private Customer student;
    @OneToOne
	private Course course;
	
	
	
	public CourseTaken() {
		super();
	}



	public CourseTaken(Customer student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getStudent() {
		return student;
	}

	public void setStudent(Customer student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}