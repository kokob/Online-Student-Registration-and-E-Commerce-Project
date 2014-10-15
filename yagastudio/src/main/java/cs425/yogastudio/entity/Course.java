package cs425.yogastudio.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String courseName;
	private String courseCode;
	private int courseCredit;
    @OneToMany
    @JoinTable(name = "Course_Prerequisite")
	private List<Course> prerequisite;// = new ArrayList<Course>();
    @OneToMany(mappedBy = "course")
	private List<Section> sections;// = new ArrayList<Section>();
	
	

	public Course() {
		super();
	}

	public Course(String courseName, String courseCode, int courseCredit) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.courseCredit = courseCredit;
		this.prerequisite = new ArrayList<Course>();
		this.sections = new ArrayList<Section>();
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public int getCourseCredit() {
		return this.courseCredit;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Course> getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(ArrayList<Course> prerequisite) {
		this.prerequisite = prerequisite;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}
	
	
	public void addPrerequisite(Course course){
		
		this.prerequisite.add(course);
		
		}
	
	public void addSections(Section section){
		
		this.sections.add(section);
		
	   }
	
	
	
	
}