package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
