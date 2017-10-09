package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Clases;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.Teacher;
import pl.coderslab.repository.ClassesRepository;
import pl.coderslab.repository.StundentRepository;
import pl.coderslab.repository.TeacherRepository;
import javax.persistence.*;
import java.time.temporal.Temporal;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

   @Autowired
    private TeacherRepository teacherRepository;

   @Autowired
   private StundentRepository stundentRepository;

   @Autowired
   private ClassesRepository classesRepository;


    @Autowired
    private StundentRepository str ;

    @GetMapping("/add")
    public String newTeacher(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher" , teacher);
        return "loginTeacher";
    }

    @PostMapping("/add")
    public String newTeacher(@ModelAttribute Teacher teacher , Model model){
        String root = "root";
        Teacher teacher1 = teacherRepository.findByLogin(teacher.getLogin());
        if (teacher1 == null) {
            model.addAttribute("msg", "Enter valid data");
            return "loginTeacher";
        }
        return "dashboardTeacher";

      /*  List<Teacher> teacherList = teacherRepository.findAll();
        for (Teacher t : teacherList) {
            if ((t.getLogin().contains(root) && t.getPassword().contains(root))) {
                return "dashboardTeacher";
            }
        }
        return "loginTeacher";*/
       }



    @GetMapping("/findStudent")
    public String findStudent(Model model){
        Student student = new Student();
        model.addAttribute("student" , student);
        return "findStudent";
    }


    @PostMapping("/findStudent")
    public String findStudentPost(@RequestParam String name , @RequestParam String lastName , Model model){
         List<Student> student = stundentRepository.findStudentByNameAndLastName(name , lastName);
        model.addAttribute("student" , student);
        return "showStudent";
    }


    @GetMapping("/findDate")
    public String findClassgGET(Model model){
        Student student = new Student();
        model.addAttribute("student" , student);
        return "findClases";
    }


    @PostMapping("/findDate")
    public String findClassgPOST(@RequestParam String date, Model model){
        List<Clases> clases = classesRepository.findClasesByDate(date);
        model.addAttribute("clases" , clases);
        return "showClases";
    }




}















