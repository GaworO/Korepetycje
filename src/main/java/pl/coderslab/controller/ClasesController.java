package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.ClassesRepository;
import pl.coderslab.repository.StundentRepository;
import pl.coderslab.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Controller
@RequestMapping("/classes")
public class ClasesController extends SessionedController{


    //find all teacher

   /* @Autowired
    private  TeacherRepository teacherRepository ;*/
    //find all student
/*
    @Autowired
    private StundentRepository stundentRepository ;*/


   @Autowired
    private ClassesRepository classesRepository;

//FIND ALL BY ID


    @GetMapping("/addClasses")
    public String addClasses(Model model){
        model.addAttribute("clases" , new Clases());
        List<Clases> list = new ArrayList<>();
       session().setAttribute("clases", list);
        return "addClassesForm";
    }

    @PostMapping("/addClasses")
    public String addClassesPost(@ModelAttribute Clases clases ){
        clases  = classesRepository.save(clases);
        List<Clases> list = classesRepository.findAll() ;
         for (Clases list1: list) {
              if(!list1.getDate().equals(clases.getDate())){
                  return "dodano";
             } else {
                  return "addClassesForm";
              }

       }
        return "addClassesForm";
       //Clases clases1 =  clasesDAO.findById(clases.getId());
    //    clasesDAO.save(clases1);*/
       // Student student = stundentRepository.findStudentByClases(clases1);
   //     student.setClases(clases1);
     //   studentDAO.save(student);
        //return "dodano";
    }
    @GetMapping("/addClasses/teacher")
    public String addClassesteacher(Model model){
        model.addAttribute("clases" , new Clases());
        List<Clases> list = new ArrayList<>();
        session().setAttribute("clases", list);
        return "updateClases";
    }

    @PostMapping("/addClasses/teacher")
    public String addClassesPostteacher(@ModelAttribute Clases clases ) {
        clases = classesRepository.save(clases);
        List<Clases> list = classesRepository.findAll();
        for (Clases list1 : list) {
            if (!list1.getDate().equals(clases.getDate())) {
                return "updateClases";
            } else {
                return "dodanoTeacher";
            }

        }
        return "addClassesFormTeacher";
    }





//UCZEŃ
    @GetMapping("/update/{id}")
    public String addClassesEditGet(Model model, @PathVariable Long id){
        Clases clases = classesRepository.findOne(id);
        model.addAttribute("clases" , clases);
        return "updateClases";
    }


    @PostMapping("/update/{id}")
    public String addClassesEditPost(Clases clases){
        classesRepository.save(clases);
         return "teacherDodano";
    }


    @GetMapping("/delete/{id}")
    public String addClasses(@PathVariable  long id){
        this.classesRepository.delete(classesRepository.getOne(id));
        return "delete";
    }

    //teacher

    @GetMapping("/update/teacher/{id}")
    public String addClassesEditGetTeacher(Model model, @PathVariable Long id){
        Clases clases = classesRepository.findOne(id);
        model.addAttribute("clases" , clases);
        return "addClassesForm";
    }


    @PostMapping("/update/teacher/{id}")
    public String addClassesEditPostTeacher(Clases clases){
        classesRepository.save(clases);
        return "addClassesForm";
    }



    @GetMapping("/delete/teacher/{id}")
    public String addClassesTeacher(@PathVariable  long id){
        this.classesRepository.delete(classesRepository.getOne(id));
        return "delTeacher";
    }

    @GetMapping("/allTeacher")
    public String allClassesTeacher(Model model){
        List<Clases> clases = classesRepository.findAll();
        model.addAttribute("clases" , clases);
        return "allClassesTeacher";
    }

}
