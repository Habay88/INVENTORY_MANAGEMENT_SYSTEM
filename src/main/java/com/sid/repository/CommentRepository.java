package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
