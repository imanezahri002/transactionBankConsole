package org.example.repositories.implementation;

import org.example.models.Account;
import org.example.repositories.interfaces.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {
    private final List<Account> accounts=new ArrayList<>();

    @Override
    public void addAccount(Account account){
        accounts.add(account);
    }

}
