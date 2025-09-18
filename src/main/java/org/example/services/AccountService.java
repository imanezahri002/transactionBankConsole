package org.example.services;

import org.example.models.Account;
import org.example.repositories.interfaces.AccountRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


public class AccountService {

    private AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String accountId, UUID ownerUserId, BigDecimal initialBalance) {
        Account account = new Account(
                accountId,
                ownerUserId,
                true,
                Instant.now(),
                initialBalance
        );
        accountRepository.addAccount(account);
        return account;
    }


}
