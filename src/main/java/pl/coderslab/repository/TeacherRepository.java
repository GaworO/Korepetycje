package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.Teacher;
import javax.persistence.*;

import java.util.List;

@EnableJpaRepositories
public interface TeacherRepository extends JpaRepository<Teacher,Long>{

 /*   Teacher findStudentById();
    Teacher findByStudentId();
*/
/*
      Teacher findByEmail(String email);


    Teacher findAllByStudent(String name);

*/

  /*  List<Student> findByStudents(Long id);*/

    Teacher findByLogin(String login);


}
