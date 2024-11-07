package com.sid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.model.UserPrivelegeAssignment;

public interface UserPrivelegeAssignmentRepository extends JpaRepository<UserPrivelegeAssignment, Long> {

	public  void deleteByUserId(Long userid);

	public List<UserPrivelegeAssignment> findByUserid(Long userid);
}
