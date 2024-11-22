package com.sid.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sid.model.Privelege;
import com.sid.model.Role;
import com.sid.model.UserPrivelegeAssignment;
import com.sid.repository.PrivelegeRepository;
import com.sid.repository.RoleRepository;
import com.sid.repository.UserPrivelegeAssignmentRepository;
import com.sid.repository.UserRepository;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PrivelegeRepository privelegeRepository;
    private final UserPrivelegeAssignmentRepository assignmentRepository;
    
  

	public RoleService(RoleRepository roleRepository, UserRepository userRepository,
			PrivelegeRepository privelegeRepository, UserPrivelegeAssignmentRepository assignmentRepository) {
		super();
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.privelegeRepository = privelegeRepository;
		this.assignmentRepository = assignmentRepository;
	}

	//Get All Roles
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    //Get Role By Id
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    //Delete Role
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    //Update Role
    public Role save(Role role) {
        return roleRepository.save(role);
    }

	public void assignUserRole(Long userid,Long roleid) {
		// TODO Auto-generated method stub
		List<Privelege> priveleges = privelegeRepository.findByRoleid(roleid);
	  List<UserPrivelegeAssignment> existingAssignment = assignmentRepository.findByUserid(userid);
	  assignmentRepository.deleteAll(existingAssignment);
	  List<UserPrivelegeAssignment> assignments = priveleges.stream()
				.map(privelege -> new UserPrivelegeAssignment(userid,privelege.getId()))
				.toList();
	
	  assignmentRepository.saveAll(assignments);
	  
	
	}

	public void unAssignUserRole(Long userid, Long roleid) {
		List<Privelege> priveleges = privelegeRepository.findByRoleid(roleid); 
		List<UserPrivelegeAssignment> assignments = priveleges.stream()
					.map(privelege -> new UserPrivelegeAssignment(userid,privelege.getId()))
					.toList();
		assignmentRepository.deleteAll(assignments);
	}

	public List<Privelege> getPrivelegesInRole(Long roleid) {
		// TODO Auto-generated method stub
	return	privelegeRepository.findByRoleid(roleid);
	}
	



}