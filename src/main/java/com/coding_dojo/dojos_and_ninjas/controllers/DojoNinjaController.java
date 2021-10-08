package com.coding_dojo.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding_dojo.dojos_and_ninjas.models.Dojo;
import com.coding_dojo.dojos_and_ninjas.models.Ninja;
import com.coding_dojo.dojos_and_ninjas.services.DojoService;
import com.coding_dojo.dojos_and_ninjas.services.NinjaService;

@Controller
public class DojoNinjaController {
    @Autowired
    NinjaService ninjaService;
    DojoService dojoService;
    
    public DojoNinjaController(DojoService dojoService) { 
		 
		 this.dojoService = dojoService; 
	 }
    
    @RequestMapping("/")
    public String index(Model model) {
    	List<Ninja> allNinjas = ninjaService.allNinjas();
    	List<Dojo> allDojos = dojoService.allDojos();
    	
    	model.addAttribute("ninjas", allNinjas);
    	model.addAttribute("dojos", allDojos);
    	
    	return "index.jsp";
    }
    
    @RequestMapping("oneDojo/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
    	
		model.addAttribute("dojo", dojoService.findDojo(id));
		
		return "oneDojo.jsp";
	}
    
    
    @RequestMapping("/createDojo")
    public String createDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
    	List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "createDojo.jsp";
    }
    @RequestMapping(value="/adddojo", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    	
   	 if (result.hasErrors()) {
   		 return "redirect:/createDojo";
   	 } else {
   		 dojoService.createDojo(dojo);
   		 return "redirect:/";
   	 }
    }

    
    @RequestMapping("/createNinja")
    public String createNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
    	
    	List<Ninja> ninjas = ninjaService.allNinjas();
    	List<Dojo> dojos = dojoService.allDojos();
    	
        model.addAttribute("ninjas", ninjas);
    	model.addAttribute("dojos", dojos);
    	
        return "createNinja.jsp";
    }
    @RequestMapping(value="/addninja", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    	
   	 if (result.hasErrors()) {
   		 return "redirect:/createNinja";
   	 } else {
   		 ninjaService.createNinja(ninja);
   		 return "redirect:/";
   	 }
    }
}
