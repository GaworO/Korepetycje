package pl.coderslab.controller;
import javax.persistence.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Clases;
import pl.coderslab.entity.Student;
import pl.coderslab.repository.ClassesRepository;
import pl.coderslab.repository.StundentRepository;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController extends  SessionedController  {

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StundentRepository str ;


    @GetMapping("/allClasses")
    @Transactional
    public String allClassesStudent(Model model){
 /*    session().getAttribute("student");
     Student student = (Student) session().getAttribute("student");
        Hibernate.initialize(student.getClass());
        model.addAttribute("clases" , student.getClass());
        List<Clases> clases = classesRepository.findAll();
        model.addAttribute("clases" , clases);*/
        List<Clases> clases = classesRepository.findAll();
        model.addAttribute("clases" , clases);
        return "allClasses";





    }

 /*   @PostMapping("/allClasses")
    public String findStudentPost(@RequestParam Long id){
       *//* String str = Long.toString(id);
        session().getAttribute(str);*//*
        return "showClases";
    }*/

    @GetMapping("/twoje/{id}")
    public String yourClasses(@RequestParam Long id , Model model){
            session().getAttribute("id");
            List<Clases> clases = classesRepository.findClasesByStudentId(id);
            model.addAttribute("clases" , clases);
            return "yourClasses";
        }


 /*   @PostMapping("/twoje/{id}")
    public String addClassesEditPostTeacher(Clases clases){
        classesRepository.save(clases);
        return "yourClasses";
    }*/


   @GetMapping("/add")
    public String newStudent(Model model){
        Student student = new Student();
        student.setEnabled(false);
        model.addAttribute("student" , student);
       return "rejestracja";

    }

    @PostMapping("/add")
     public String newStudent(@ModelAttribute Student student){
   /*     if(result.hasErrors()) {
            return "rejestracja";
        }*/
        List<Student> students = str.findAll() ;
        for(Student student1 : students){
            if(!(student1.getEmail().equals(student.getEmail()))){
                str.save(student);
                return "dashbord";
            } else {
                return "TakiUzytkownikJuzIstnieje";
            }

        }
        return "TakiUzytkownikJuzIstnieje";

    }

    @GetMapping("/downloadingFiles")
    public String downloadingFiles() {
         return "downloadingFilesView";

    }


    @RequestMapping(value="/downloadFile")
    public void getLogFile(HttpSession session, HttpServletResponse response) throws Exception {
        try {
            String file = new String("Materiały");
            String filePathToBeServed = "C:/Users/Ola/IdeaProjects/studentprojekt/src/main/resources/fileName.pdf";
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+file+".pdf");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
     }

    @RequestMapping(value="/downloadFile1")
    public void getLogFile2(HttpSession session, HttpServletResponse response) throws Exception {
        try {
            String file = new String("Materiały2");
            String filePathToBeServed = "C:/Users/Ola/IdeaProjects/studentprojekt/src/main/resources/fileName1.pdf";
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+file+".pdf");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/downloadFile2")
    public void getLogFile3(HttpSession session, HttpServletResponse response) throws Exception {
        try {
            String file = new String("Materiały3");
            String filePathToBeServed = "C:/Users/Ola/IdeaProjects/studentprojekt/src/main/resources/fileName2.pdf";
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename="+file+".pdf");
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}

