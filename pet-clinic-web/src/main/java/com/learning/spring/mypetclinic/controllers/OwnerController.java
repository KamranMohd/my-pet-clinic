package com.learning.spring.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// define parent level prefix to the request URL
@RequestMapping("/owners")
@Controller
public class OwnerController {

	@RequestMapping({"", "/", "/index.html", "/index"})
	public String listOwners(){
		return "owners/index";
	}
}
