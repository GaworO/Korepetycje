package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.coderslab.entity.Calendars;
import pl.coderslab.entity.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface CalendarRepository extends JpaRepository<Calendars , Long>{

    Calendars findByDate(String date);

}



