package org.example.repositories.interfaces;

import org.example.models.User;

public interface UserRepository {
    void addUser(User user);
    User findUser(String email);
    void displayUsers();

}
