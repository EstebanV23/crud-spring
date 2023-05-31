package com.crud.app.controller;

import com.crud.app.entity.Company;
import com.crud.app.entity.Company;
import com.crud.app.entity.Supplier;
import com.crud.app.service.CompanyService;
import com.crud.app.service.EmployeeService;
import com.crud.app.service.OwnerService;
import com.crud.app.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private SupplierService supplierService;

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		model.put("title", "New company");
		model.put("company", new Company());
		model.put("employees", employeeService.findAll());
		model.put("owners", ownerService.findAll());
		model.put("suppliers", supplierService.findAll());

		return "formCompany";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("companies", companyService.findAll());
		model.addAttribute("title", "Companies List");
		return "listarCompany";
	}

	@PostMapping("/form")
	public String guardar(@Valid Company company, BindingResult result, Model model, SessionStatus status)
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Company form");
			return "formCompany";
		}
		companyService.save(company);
		status.setComplete();
		return "redirect:/company/listar";
	}


	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id,Map<String, Object> model) {

		Company company = null;

		if(id > 0) {
			company = companyService.FindOne(id);
		} else {
			return "redirect:/company/listar";
		}
		model.put("company", company);
		model.put("title", "Company Edit");
		model.put("employees", employeeService.findAll());
		model.put("owners", ownerService.findAll());
		model.put("suppliers", supplierService.findAll());
		return "formCompany";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if (id > 0 ) {
			companyService.delete(id);
		}

		return "redirect:/company/listar";
	}
	
	
}
