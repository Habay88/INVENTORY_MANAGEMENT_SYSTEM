package com.sid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sid.model.Transaction;
import com.sid.service.TransactionService;

import java.util.List;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/transactions")
    public List<Transaction> getTransactiones(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") Long id){
        return transactionService.getTransactionById(id);
    }

    @PutMapping("/transaction/{id}")
    public Transaction updateTransaction(@RequestBody() Transaction transaction, @PathVariable("id") Long id){
        return transactionService.save(transaction);
    }

    @PostMapping("/transactions")
    public Transaction addNew(@RequestBody() Transaction transaction){
        return transactionService.save(transaction);
    }

    @DeleteMapping("/transaction/{id}")
    public void deleteTransaction(@PathVariable("id") Long id){
        transactionService.deleteTransaction(id);
    }
}
