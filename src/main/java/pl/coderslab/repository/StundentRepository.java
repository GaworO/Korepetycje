package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.entity.Clases;
import pl.coderslab.entity.Student;

import java.util.List;

@EnableJpaRepositories
public interface StundentRepository extends JpaRepository<Student , Long> {

        Student findByEmail(String email);
        List<Student> findStudentByNameAndLastName(String name , String lastName);
        Student findStudentByLogin(Long id);
        Student findByLogin(String login);
}
