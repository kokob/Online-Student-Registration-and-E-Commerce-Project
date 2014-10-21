package cs425.yogastudio.entity;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.hash;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String courseName;
    private String courseCode;
    private int courseCredit;
    @OneToOne
    private Course prerequisite;
//    @OneToMany
//    @JoinTable(name = "Course_Prerequisite")
//	private List<Course> prerequisite;// = new ArrayList<Course>();
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Section> sections;// = new ArrayList<Section>();

    public Course() {
        super();
    }

    public Course(String courseName, String courseCode, int courseCredit) {
        super();
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.prerequisite = null;
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

    public Course getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Course prerequisite) {
        this.prerequisite = prerequisite;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void addSections(Section section) {

        this.sections.add(section);

    }
    
    public String toString() {
        return "" + courseName;
    }
    
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }else{
            if(other.getClass() != this.getClass()){
                return false;
            }
            return ((Course)other).getId()==this.id;
        }
        
    }
    
    public int hashCode() {
        return hash(id);
    }

}
