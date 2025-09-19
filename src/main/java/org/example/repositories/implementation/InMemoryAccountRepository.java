package org.example.repositories.implementation;

import org.example.models.Account;
import org.example.models.User;
import org.example.repositories.interfaces.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {
    private final List<Account> accounts=new ArrayList<>();

    @Override
    public void save(Account account){
        accounts.add(account);
    }

    @Override
    public List<Account> findAccountsByOwner(User owner) {
        List<Account> userAccounts=new ArrayList<>();
        for (Account account : accounts) {
            if (account.getOwnerUser().equals(owner)) {
                userAccounts.add(account);
                return userAccounts;
            }
        }
        return userAccounts;
    }
}
