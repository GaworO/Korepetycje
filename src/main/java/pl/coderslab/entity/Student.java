package pl.coderslab.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Id;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "name" )
    @NotBlank
    private String name ;
    @Column(name = "lastName")
    @NotBlank
    private String lastName;
    @Column(name = "phoneNumber")
    @NotNull
    private long phoneNumber ;
    @Column(name = "email",unique=true)
    @NotBlank
    @Email
    private String email ;
    @Column(name = "login")
    @NotBlank
    private String login ;
    @Column(name = "password")
    private String password;
    private boolean enabled;
    @ManyToOne
    private Teacher teacher ;

   @OneToMany(mappedBy = "student")
    private List<Clases> clases;


    //KONSTRUKTOR

    public Student(String name, String lastName, long phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Student() {
    }
//TO STRING METHOD


  /*  public void setClases(Clases clases) {
        this.clases = clases;
    }
*/
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt()) ;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Clases> getClases() {
        return clases;
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }

    public Boolean isPasswordCorrect(String password) {
        return BCrypt.checkpw(password, this.password);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

}

