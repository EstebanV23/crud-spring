package com.crud.app.controller;

import com.crud.app.entity.Owner;
import com.crud.app.entity.Owner;
import com.crud.app.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		model.put("title", "New owner");
		model.put("owner", new Owner());
		return "formOwner";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		model.addAttribute("title", "Owners List");
		return "listarOwner";
	}

	@PostMapping("/form")
	public String guardar(@Valid Owner owner, BindingResult result, Model model, SessionStatus status)
	{
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Owner form");
			return "formOwner";
		}
		ownerService.save(owner);
		status.setComplete();
		return "redirect:/owner/listar";
	}


	@GetMapping("/form/{id}")
	public String editar(@PathVariable("id") Long id,Map<String, Object> model) {

		Owner owner = null;

		if(id > 0) {
			owner = ownerService.FindOne(id);
		} else {
			return "redirect:/owner/listar";
		}
		model.put("owner", owner);
		model.put("title", "Owner Edit");
		return "formOwner";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if (id > 0 ) {
			ownerService.delete(id);
		}

		return "redirect:/owner/listar";
	}
	
	
}
