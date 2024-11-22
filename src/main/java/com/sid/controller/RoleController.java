package com.sid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sid.model.Privelege;
import com.sid.model.Role;
import com.sid.repository.PrivelegeRepository;
import com.sid.service.RoleService;
import com.sid.service.UserService;

import java.util.List;

@RestController
public class RoleController {

    
    private final RoleService roleService;
    private final PrivelegeRepository privelegeRepository;
    private final UserService userService;
    

    public RoleController(RoleService roleService, PrivelegeRepository privelegeRepository, UserService userService) {

		this.roleService = roleService;
		this.privelegeRepository = privelegeRepository;
		this.userService = userService;
	}

	@GetMapping("/roles")
    public List<Role> parameters(Model model) {
        return roleService.findAll();
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public Role getById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @PostMapping("/roles")
    public Role save(Role role) {
        return roleService.save(role);
    }

    @RequestMapping(value = "/role/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void delete(@PathVariable Integer id) {
        roleService.delete(id);
    }
    
    @PostMapping("/role/{roleid}/assign/user/{userid}")
    public void assignUserRole(@PathVariable ("roleid")Long roleid, @PathVariable("userid") Long userid) {
    	
    roleService.assignUserRole(userid, roleid);
    }
    @DeleteMapping("/role/{roleid}/unAssign/user/{userid}")
    public void unassignUserRole(@PathVariable ("roleid")Long roleid, @PathVariable("userid") Long userid) {
    	
    roleService.unAssignUserRole(userid, roleid);
    }
	@GetMapping("role/{roleid}/priveleges")
	public List<Privelege> getPrivelegsInRole(@PathVariable("roleid") Long roleid){
		
	return	roleService.getPrivelegesInRole(roleid);
	}
}
