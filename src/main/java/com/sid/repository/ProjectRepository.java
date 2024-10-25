package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
