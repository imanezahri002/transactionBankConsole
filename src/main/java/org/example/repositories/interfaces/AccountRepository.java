package org.example.repositories.interfaces;

import org.example.models.Account;
import org.example.models.User;

import java.util.List;

public interface AccountRepository {
    void save(Account account);
    List<Account> findAccountsByOwner(User owner);

}
