package org.example.services;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.interfaces.AccountRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(User user, BigDecimal balance) {
        String accountId = UUID.randomUUID().toString();
        Account account = new Account(accountId,user,balance);
        accountRepository.save(account);
        return account;
    }

    public List<Account> findAccountByOwner(User owner){
        return accountRepository.findAccountsByOwner(owner);
    }

    public void desactivateAccount(String accountId, User owner) {
        List<Account> userAccounts = accountRepository.findAccountsByOwner(owner);

        for (Account acc : userAccounts) {
            if (acc.getAccountId().equals(accountId)) {
                if (acc.getBalance().compareTo(BigDecimal.ZERO) == 0) {
                    accountRepository.desactivateAccount(acc); // appel repo
                    System.out.println("Compte " + acc.getAccountId() + " clôturé avec succès !");
                } else {
                    System.out.println("Impossible de clôturer, solde non nul : " + acc.getBalance());
                }
                return;
            }
        }
        System.out.println("Compte introuvable ou vous n'êtes pas le propriétaire.");
    }



}
