package com.learning.spring.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.spring.mypetclinic.services.OwnerService;

// define parent level prefix to the request URL
//@RequestMapping("/owners")
@Controller
public class OwnerController {
	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/owners", "/owners/index.html", "/owners/index" })
	public String listOwners(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping({"/owners/find","/oups"})
	public String oupsHandler(){
		return "notimplemented";
	}
}

