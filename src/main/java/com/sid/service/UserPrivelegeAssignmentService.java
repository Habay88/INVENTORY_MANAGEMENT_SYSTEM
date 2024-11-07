package com.sid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.model.Privelege;
import com.sid.model.User;
import com.sid.model.UserPrivelegeAssignment;
import com.sid.repository.PrivelegeRepository;
import com.sid.repository.UserPrivelegeAssignmentRepository;
import com.sid.repository.UserRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
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
	    
	    @Transactional
	    public List<Privelege> savePriveleges(List<Privelege> priveleges, Long userid){
	    	userprivelegeRepository.deleteByUserId(userid);
	    	List<UserPrivelegeAssignment> assignments = priveleges.stream()
	    			.map(privelege -> new UserPrivelegeAssignment( userid, privelege.getId()))
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

		public List<Privelege> getUserPriveleges(Long userid) {
			List<UserPrivelegeAssignment> assignments = userprivelegeRepository.findByUserid(userid);
			return assignments.stream().map(userPrivelegeAssignment -> userPrivelegeAssignment.getPrivelege()).toList();
	    }

		public List<User> getUsersByPrivelege(Long privelegeid) {
			List<UserPrivelegeAssignment> assignments = userprivelegeRepository.findByUserid(privelegeid);
			return assignments.stream()
					.map(UserPrivelegeAssignment::getUser).toList();
	    }

		public void deletePriveleges(Long userid) {
			// TODO Auto-generated method stub
			
			
		}
		
		
		
		
		}

	
//}
