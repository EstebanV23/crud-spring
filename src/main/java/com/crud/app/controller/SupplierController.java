package com.crud.app.controller;

import com.crud.app.entity.Supplier;
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
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		model.put("title", "New supplier");
		model.put("supplier", new Supplier());
		return "formSupplier";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("suppliers", supplierService.findAll());
		model.addAttribute("title", "Suppliers List");
		return "listarSupplier";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Supplier supplier, BindingResult result, Model model, SessionStatus status)
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Supplier form");
			return "formSupplier";
		}
		supplierService.save(supplier);
		status.setComplete();
		return "redirect:/supplier/listar";
	}
	
		
	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id,Map<String, Object> model) {
		
		Supplier supplier = null;
		
		if(id > 0) {
			supplier = supplierService.FindOne(id);
		} else {
			return "redirect:/supplier/listar";
		}
		model.put("supplier", supplier);
		model.put("title", "Supplier Edit");
		return "formSupplier";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if (id > 0 ) {
			supplierService.delete(id);
		}
		
		return "redirect:/supplier/listar";
	}
	
	
}
