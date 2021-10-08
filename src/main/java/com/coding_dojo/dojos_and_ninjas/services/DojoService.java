package com.coding_dojo.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding_dojo.dojos_and_ninjas.models.Dojo;
import com.coding_dojo.dojos_and_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
		private final DojoRepository dojoRepository;
		 
	 public DojoService(DojoRepository dojoRepository) {
	     this.dojoRepository = dojoRepository;
	 }
	 public List<Dojo> allDojos() {
	     return dojoRepository.findAll();
	 }
	 public Dojo createDojo(Dojo b) {
	     return dojoRepository.save(b);
	 }
	 public Dojo findDojo(Long id) {
	     Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	     if(optionalDojo.isPresent()) {
	    	 Dojo dojo = optionalDojo.get();
	    	 System.out.println(dojo.getNinjas().size());
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
}
