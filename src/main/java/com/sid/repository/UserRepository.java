package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,  Long> {
    User findByUsername(String username);
}
