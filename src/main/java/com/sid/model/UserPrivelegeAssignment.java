package com.sid.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivelegeAssignment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    
    @ManyToOne
	@JoinColumn(name="userid", insertable = false, updatable=false)
	private User user;
	private Long userid;
	
	@ManyToOne
	@JoinColumn(name="privelegeid", insertable = false, updatable=false)
	private Privelege privelege;
	private Long privelegeid;
}
