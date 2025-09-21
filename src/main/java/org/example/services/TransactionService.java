package org.example.services;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.interfaces.AccountRepository;
import org.example.repositories.interfaces.TransactionRepository;

import java.math.BigDecimal;

public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository,AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository=accountRepository;
    }


    public void depositAccount(BigDecimal amount, String accountId, User owner) {
        Account acc = accountRepository.findAccountByIdAndOwner(accountId, owner);
        if (acc == null) {
            System.out.println("Compte introuvable");
            return;
        }

        if (!acc.isActive()) {
            System.out.println("Ce compte est désactivé");
            return;
        }
        transactionRepository.deposit(amount, acc);
    }

    public void withdrawAccount(BigDecimal amount, String accountId, User owner) {
        Account account = accountRepository.findAccountByIdAndOwner(accountId, owner);

        if (account == null) {
            System.out.println("Compte introuvable");
            return;
        }

        if (!account.isActive()) {
            System.out.println("Ce compte est désactivé, impossible de retirer.");
            return;
        }

        if (account.getBalance().compareTo(amount) < 0) {
            System.out.println("Solde insuffisant !");
            return;
        }

        transactionRepository.withdraw(amount, account);
        System.out.println("Retrait de " + amount + " effectué avec succès sur le compte " + account.getAccountId());
    }




}

