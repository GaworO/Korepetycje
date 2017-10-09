package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Login;
import pl.coderslab.entity.Student;

import pl.coderslab.repository.StundentRepository;
import pl.coderslab.repository.TeacherRepository;


@Controller
@RequestMapping("/login")
public class LoginController extends SessionedController  {

	@Autowired
	StundentRepository stundentRepository;

	@Autowired
	TeacherRepository teacherRepository;
	@GetMapping("")
	public String login(Model m ) {
		Login login = new Login();
		m.addAttribute("student", login);
		return "login";
	}

	@PostMapping("")
	public String loginPost(Login studentLogin, Model m ) {


		Student student = stundentRepository.findByLogin(studentLogin.getLogin());
		if (student == null) {
			m.addAttribute("msg", "Enter valid data");
			return "login";
		}

		if (student.isPasswordCorrect(studentLogin.getPassword())) {
			session().setAttribute("student", student);
			return "dashbord";
		}
		return "NieMozeszSieZalogowac";
	}










	@GetMapping("/back")
	public String loginGetBack(Model m) {
		return "dashbord";
	}

	@GetMapping("/teacher")
	public String loginTeacherGetBack(Model m) {
		return "dashboardTeacher";
	}

	@GetMapping("/login")
	public String login(){
		String str = "Login";
		if(session().getAttribute("student") != null){
			Student student = (Student) session().getAttribute("student");
			str = student.getName();
		}


		return str;
	}



}
