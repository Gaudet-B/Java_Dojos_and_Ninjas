
package com.gaudetb.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaudetb.dojosandninjas.models.Dojo;
import com.gaudetb.dojosandninjas.models.Ninja;
import com.gaudetb.dojosandninjas.services.DojoService;
import com.gaudetb.dojosandninjas.services.NinjaService;


@RequestMapping("/ninjas")
@Controller
public class NinjaController {

	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	

	// ============> DISPLAY ROUTES <============
	
	// Add:
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> dojos = dojoService.findAll();
		model.addAttribute("dojos", dojos);
		
		return "new_ninja.jsp";
	}
	
	// Edit:
	
	@GetMapping("/edit/{id}")
	public String editNinja() {
		return "edit_ninja.jsp";
	}
	
	
	// View:
	
	@GetMapping("/{id}")
	public String viewNinja() {
		return "view_ninja.jsp";
	}
	
	
	// ============> ACTION ROUTES <============
	
	// Create:
	
	@PostMapping("/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
//		Long id = ninjaService.findIdByName(ninja.getLastName());
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.findAll();
			model.addAttribute("dojos", dojos);
			
			return "new_ninja.jsp";
		} else {
			ninjaService.save(ninja);
			return "redirect:/ninjas/new";
			
		}
//		else return "redirect:/ninjas/" + id;
	}
	
	// Update:
	
	@PutMapping("update/{id}")
	public String updateNinja(@PathVariable("id") Long id, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) return "edit_ninja.jsp";
		else {
			ninjaService.save(ninja);
			return "redirect:/ninjas/" + id;
		}
	}
	
	// Delete:
	
}
