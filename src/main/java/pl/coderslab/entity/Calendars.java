package pl.coderslab.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "calendar")
public class Calendars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name = "date")
    private String date ;

    @ManyToMany(fetch = FetchType.EAGER)
   private List<Student> student ;
//
//    @OneToMany
//     private Teacher teacher ;

    //CONTROLLER


    public Calendars() {
    }

    public Calendars(String date) {
        this.date = date;
    }

    //GETTERY I SETTERY
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
