package com.sid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sid.model.Privelege;
import com.sid.model.UserPrivelegeAssignment;
import com.sid.repository.PrivelegeRepository;
import com.sid.repository.UserPrivelegeAssignmentRepository;
import com.sid.repository.UserRepository;

public class UserPrivelegeAssignmentService {

	 @Autowired
	    private UserPrivelegeAssignmentRepository userprivelegeRepository;

	    @Autowired
	    private UserRepository userRepository;

	    //Get All  priveleges
	    public List<UserPrivelegeAssignment> findAll() {
	        return userprivelegeRepository.findAll();
	    }

	    //Get privelege By Id
	    public UserPrivelegeAssignment findById(Long id) {
	        return userprivelegeRepository.findById(id).orElse(null);
	    }
	    
	    public List<Privelege> savePriveleges(List<Privelege> priveleges, Long userid){
	    	userprivelegeRepository.deleteByUserId(userid);
	    	List<UserPrivelegeAssignment> assignments = priveleges.stream()
	    			.map(privelege -> new UserPrivelegeAssignment( userid,privelege, privelege.getId()))
	    			.toList();
	    	return userprivelegeRepository.saveAll(assignments).stream()
	    			.map(userPrivelegeAssignment -> userPrivelegeAssignment.getPrivelege()).toList();
	    }

	    //Delete privelege
	    public void delete(Long userid) {
	    	userprivelegeRepository.deleteById(userid);
	    }

	    //Update userprivelege
	    public UserPrivelegeAssignment save(UserPrivelegeAssignment userPrivelege) {
	        return userprivelegeRepository.save(userPrivelege);
	    }
}
