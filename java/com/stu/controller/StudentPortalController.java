package com.stu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stu.model.Student;
import com.stu.service.StudentService;

@RestController
public class StudentPortalController {
	
	private StudentService studentservice;
	
    public void setStudentservice(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    
	@RequestMapping("/signup")
	public ModelAndView sigupStudent(HttpServletRequest request) {
	        String name = request.getParameter("fname");
	        String lastname = request.getParameter("lname");
	        String gendor = request.getParameter("gender");
	        String address= request.getParameter("address");
	        String mobilenum = request.getParameter("contactnumber");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String cpassword = request.getParameter("cpassword");
	        Student s = new Student();
	        s.setFirstName(name);
	        s.setLastName(lastname);
	        s.setGender(gendor);
	        s.setAddress(address);
	        s.setContactNum(mobilenum);
	        s.setEmail(email);
	        s.setPassword(password);
	        s.setCpassword(cpassword);
	        studentservice.save(s);
	        return new ModelAndView("success");
	    }
	 
}
