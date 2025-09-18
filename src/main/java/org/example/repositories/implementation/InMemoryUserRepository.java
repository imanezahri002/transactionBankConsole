package org.example.repositories.implementation;

import org.example.repositories.interfaces.UserRepository;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users=new ArrayList<>();
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User findUser(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
    @Override
    public void displayUsers() {

            for (User u : users) {
                System.out.println("- " + u.getFullname() + " | " + u.getEmail());
            }

    }
    @Override
    public void editUser(User user) {
        users.add(user);
        System.out.println("mis a jour " + user.getFullname() + " | " + user.getEmail());
    }



}
