package com.crud.app.controller;

import com.crud.app.entity.Employee;
import com.crud.app.entity.Employee;
import com.crud.app.service.EmployeeService;
import com.crud.app.service.PersonalComputerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PersonalComputerService personalComputerService;

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		model.put("title", "New employee");
		model.put("employee", new Employee());
		model.put("personalComputers", personalComputerService.findAll());
		return "formEmployee";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("title", "Employees List");
		return "listarEmployee";
	}

	@PostMapping("/form")
	public String guardar(@Valid Employee employee, BindingResult result, Model model, SessionStatus status)
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Employee form");
			return "formEmployee";
		}
		employeeService.save(employee);
		status.setComplete();
		return "redirect:/employee/listar";
	}


	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id,Map<String, Object> model) {

		Employee employee = null;

		if(id > 0) {
			employee = employeeService.FindOne(id);
		} else {
			return "redirect:/employee/listar";
		}
		model.put("employee", employee);
		model.put("title", "Employee Edit");
		model.put("personalComputers", personalComputerService.findAll());
		return "formEmployee";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if (id > 0 ) {
			employeeService.delete(id);
		}

		return "redirect:/employee/listar";
	}
	
	
}
