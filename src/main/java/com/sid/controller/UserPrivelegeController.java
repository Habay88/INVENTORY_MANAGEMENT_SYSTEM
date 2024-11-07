package com.sid.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.model.Privelege;
import com.sid.model.User;
import com.sid.model.UserPrivelegeAssignment;
import com.sid.service.UserPrivelegeAssignmentService;

import jakarta.transaction.Transactional;

@RestController
@Transactional
public class UserPrivelegeController {

	private UserPrivelegeAssignmentService userPrivelegeService;
	
	
			@PostMapping("/userPrivelegeAssignments")
			public UserPrivelegeAssignment save(@RequestBody UserPrivelegeAssignment userPrivelegeAssignment) {
				
				
				return userPrivelegeService.save(userPrivelegeAssignment);
			}
	
		  @DeleteMapping("/userPivelegAssignment/{id}")
		  public void deleteUserPrivelegeAssignment(@PathVariable("id") Long id) {
			  userPrivelegeService.delete(id);
		  
			}
		@Transactional
        @PostMapping("/user/{userid}/priveleges")
        public ResponseEntity<String> savePriveleges(@PathVariable("userid") Long userid,
        		                                     @RequestBody List<Privelege> priveleges){
        	try {
        		List<Privelege> savedPriveleges = userPrivelegeService.savePriveleges(priveleges, userid); 
        		return ResponseEntity.status(HttpStatus.CREATED).body("Priveleges were saved successfully");
        	} catch(Exception ex) {
        		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured :" + ex.getMessage());
        	}
        }
        
        @GetMapping("user/{id}/priveleges")
        public List<Privelege> getUserPriveleges(@PathVariable("userid") Long userid){
        	 return userPrivelegeService.getUserPriveleges(userid);
        }
        
        @GetMapping("/privilege/{id}/users")
        public List<User> getUserByPrivelege(@PathVariable("privelegeid") Long privelegeid){
       	 return userPrivelegeService.getUsersByPrivelege(privelegeid);
       }
        
        @DeleteMapping("/user/{userid}/priveleges")
        public ResponseEntity<String> clearUserPriveleges(@PathVariable("userid") Long userid){
        	try {
        		userPrivelegeService.deletePriveleges(userid); 
        		return ResponseEntity.status(HttpStatus.CREATED).body("Priveleges were cleared  successfully");
        	} catch(Exception ex) {
        		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occured :" + ex.getMessage());
        	}
        }
        	
        }
}
