package com.sid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.model.Privelege;
import com.sid.model.Role;
import com.sid.repository.PrivelegeRepository;
import com.sid.repository.RoleRepository;
import com.sid.repository.UserRepository;
@Service
public class PrivelegeService {

    @Autowired
    private PrivelegeRepository privelegeRepository;

    @Autowired
    private UserRepository userRepository;

    //Get All  priveleges
    public List<Privelege> findAll() {
        return privelegeRepository.findAll();
    }

    //Get privelege By Id
    public Privelege findById(Long id) {
        return privelegeRepository.findById(id).orElse(null);
    }

    //Delete privelege
    public void delete(Long id) {
    	privelegeRepository.deleteById(id);
    }

    //Update Role
    public Privelege save(Privelege privelege) {
        return privelegeRepository.save(privelege);
    }
}
