package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
