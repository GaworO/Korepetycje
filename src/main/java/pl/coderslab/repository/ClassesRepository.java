package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.entity.Clases;
import javax.persistence.*;
import java.util.List;

@EnableJpaRepositories
public interface ClassesRepository extends JpaRepository<Clases, Long>{


    List<Clases> findClasesByDate(String date);
    List<Clases> findClasesByStudentId(Long id);
    //List<Clases> findClasesByStudent(String name , String lastName);
 //   List<Class> findClasesByStudentId(Long id);

}
