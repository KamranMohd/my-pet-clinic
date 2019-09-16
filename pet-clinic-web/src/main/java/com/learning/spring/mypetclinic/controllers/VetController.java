package com.learning.spring.mypetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.spring.mypetclinic.model.Vet;
import com.learning.spring.mypetclinic.services.VetService;

@Controller
public class VetController {
	private final VetService vetService;

	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/index.html", "/vets/index", "/vets.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@RequestMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetsJson(){
		return vetService.findAll();
	}
	
}
