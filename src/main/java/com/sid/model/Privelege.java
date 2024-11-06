package com.sid.model;

import java.util.List;

import com.sid.security.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Privelege extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="userid", insertable = false, updatable=false)
	private User user;
	private Long userid;
	
	@ManyToOne
	@JoinColumn(name="roleid", insertable = false, updatable=false)
	private Role role;
	private Long roleid;
	
	  @OneToMany(mappedBy="privelege")
	    private List<UserPrivelegeAssignment> users;
}
