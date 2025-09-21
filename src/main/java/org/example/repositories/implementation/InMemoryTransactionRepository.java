package org.example.repositories.implementation;

import org.example.models.Account;
import org.example.repositories.interfaces.TransactionRepository;

import java.math.BigDecimal;

public class InMemoryTransactionRepository implements TransactionRepository {

    @Override
    public void deposit(BigDecimal amount, Account account){
        account.setBalance(account.getBalance().add(amount));
    }
}
