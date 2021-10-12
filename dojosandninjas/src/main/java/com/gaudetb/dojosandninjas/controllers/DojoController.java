
package com.gaudetb.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaudetb.dojosandninjas.models.Dojo;
import com.gaudetb.dojosandninjas.services.DojoService;

@RequestMapping("/dojos")
@Controller
public class DojoController {

	@Autowired
	DojoService dojoService;
	

	// ============> DISPLAY ROUTES <============
	
	// Add:
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	
	// Edit:
	
	@GetMapping("/edit/{id}")
	public String editDojo() {
		return "edit_dojo.jsp";
	}
	
	
	// View:
	
	@GetMapping("/{id}")
	public String viewDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findOne(id));
		return "view_dojo.jsp";
	}
	
	
	// ============> ACTION ROUTES <============
	
	// Create:
	
	@PostMapping("/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
//		Long id = dojoService.findIdByName(dojo.getName());
		if (result.hasErrors()) return "new_dojo.jsp";
		else {
			dojoService.save(dojo);
//			return "redirect:/dojos/" + id;
			return "redirect:/dojos/new";
		}
	}
	
	// Update:
	
	@PutMapping("update/{id}")
	public String updateDojo(@PathVariable("id") Long id, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) return "edit_dojo.jsp";
		else {
			dojoService.save(dojo);
			return "redirect:/dojos/" + id;
		}
	}
	
	// Delete:
	
	@DeleteMapping("/delete/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		dojoService.delete(id);
		
		return "redirect:/dojos/new";
	}
	
}
