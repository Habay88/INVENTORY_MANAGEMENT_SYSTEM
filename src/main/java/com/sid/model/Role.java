package com.sid.model;

import java.util.List;

import com.sid.security.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Auditable<String> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String description;
    private String details;
    
    @OneToMany(mappedBy="role")
    private List<Privelege> priveleges;
    //me
	/*
	 * @OneToMany(mappedBy="role") private List<Role> roles;
	 */
    
}