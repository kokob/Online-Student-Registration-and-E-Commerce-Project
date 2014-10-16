/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs425.yogastudio.entity;

//import javax.persistence.AttributeOverride;
//import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author kokob
 */

@Entity
@Table(name = "ADMIN")
//@AttributeOverrides({
//    @AttributeOverride(name="userName", column=@Column(name="USERNAME")),
//    @AttributeOverride(name="passWord", column=@Column(name="PASSWORD"))
//})

@PrimaryKeyJoinColumn(name="USER_ID")
public class Admin  extends User{
    @Column(name="ADMIN_FIRST_NAME")
    private String firstName;
    private String lastName;
    private String email;

    public Admin() {
    }
    

    public Admin(String firstName, String lastName, String email, String userName, String passWord) {
        super(userName, passWord);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
