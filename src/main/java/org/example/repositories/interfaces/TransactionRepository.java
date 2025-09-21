package org.example.repositories.interfaces;

import org.example.models.Account;

import java.math.BigDecimal;

public interface TransactionRepository {
    void deposit(BigDecimal amount, Account account);
    void withdraw(BigDecimal amount, Account account);
}
