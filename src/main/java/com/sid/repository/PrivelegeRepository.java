package com.sid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.model.Privelege;

public interface PrivelegeRepository extends JpaRepository<Privelege, Long> {

	List<Privelege> findByRoleid(Long roleid);

}
