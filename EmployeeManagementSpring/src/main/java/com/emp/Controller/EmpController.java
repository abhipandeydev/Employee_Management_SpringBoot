package com.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.entity.Employee;
import com.emp.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp = empService.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	// Add Employee
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session)
	{
		System.out.println(e);
		
		empService.addEmp(e);
		session.setAttribute("msg", "Employee add Successfully");
		return "redirect:/";
	}
	
	// Edit Employee
	@GetMapping("/editemp/{id}")
	public String editEmp(@PathVariable int id, Model m) {
		Employee e =empService.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit_emp";
	}
	
	//Update Employee
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session)
	{
		empService.addEmp(e);
		session.setAttribute("msg", "Employee Data Update Successfully... ");
		
		return "redirect:/";
	}
	
	// Delete Employee
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session)
	{
		empService.deleteEmp(id);
		session.setAttribute("msg", "Employee Delete Successfully...");
		return "redirect:/";
	}
}
