package com.sid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.model.Privelege;
import com.sid.service.PrivelegeService;

@RestController
public class PrivelegeController {

	@Autowired
	PrivelegeService privelegeService;
	
	@GetMapping("/privelege/{id}")
	public Privelege getById(@PathVariable Long id) {
		return privelegeService.findById(id);
				
	}
	
	@PutMapping("/privelege/{id}")
	public Privelege updatePrivelege (@RequestBody() Privelege privelege,@PathVariable("id") Long id) {
		return privelegeService.save(privelege);
	}
	
	@PostMapping("/priveleges")
	public Privelege save(Privelege privelege) {
		return privelegeService.save(privelege);
	}
	
	@DeleteMapping("/privelege/delete/id")
	public void delete(@PathVariable Long id) {
		privelegeService.delete(id);
	}
}
