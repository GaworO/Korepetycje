package pl.coderslab.entity;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@Entity
@RequestMapping("/classes")
public class Clases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     @Column(name = "name")
    private String name;

    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToOne
 //   @JoinColumn(name = "id")
    private Student student;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Clases() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}



