package org.example.services;

import org.example.models.User;
import org.example.repositories.interfaces.UserRepository;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean register(String email,String password,String adresse,String fullname){
        if(userRepository.findUser(email)!=null) {
            return false;
        }
        User user=new User(email,password,adresse,fullname);
        userRepository.addUser(user);
        return true;
    }
    public User login(String email, String password) {
        User user = userRepository.findUser(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    public void editUser(User user) {
        userRepository.editUser(user);
    }



}



