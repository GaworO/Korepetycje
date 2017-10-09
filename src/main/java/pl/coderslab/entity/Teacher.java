package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "login")
    @NotBlank
    private String login ;

    @OneToMany(cascade = CascadeType.ALL )
    private List<Student> students ;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Clases> clases;

    @Column(name = "password")
    @NotBlank
    private String password;


    @Column(name = "email")
    private String email ;
    //CONSTRUKTORY

    public Teacher(String login) {
        this.login = login;

    }

    public Teacher() {
    }
//GETTERY I SETTERY


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public List<Clases> getClases() {
        return clases;
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }
}
