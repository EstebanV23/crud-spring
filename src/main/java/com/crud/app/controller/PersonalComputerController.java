package com.crud.app.controller;

import com.crud.app.entity.PersonalComputer;
import com.crud.app.entity.Supplier;
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
@RequestMapping("/personalComputer")
public class PersonalComputerController {
	
	@Autowired
	private PersonalComputerService personalComputerService;
	
	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		model.put("title", "New supplier");
		model.put("personalComputer", new PersonalComputer());
		return "formPersonalComputer";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("personalComputers", personalComputerService.findAll());
		model.addAttribute("title", "Personal Computer List");
		return "listarPersonalComputer";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid PersonalComputer personalComputer, BindingResult result, Model model, SessionStatus status)
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Personal Computer form");
			return "formSupplier";
		}
		personalComputerService.save(personalComputer);
		return "redirect:/personalComputer/listar";
		
	}
	
		
	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id,Map<String, Object> model) {
		
		PersonalComputer personalComputer = null;
		
		if(id > 0) {
			personalComputer = personalComputerService.FindOne(id);
		} else {
			return "redirect:/personalComputer/listar";
		}
		model.put("personalComputer", personalComputer);
		return "formPersonalComputer";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if (id > 0 ) {
			personalComputerService.delete(id);
		}
		
		return "redirect:/personalComputer/listar";
	}
	
	
}
