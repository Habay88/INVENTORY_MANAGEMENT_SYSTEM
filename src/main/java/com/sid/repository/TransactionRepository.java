package com.sid.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sid.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}