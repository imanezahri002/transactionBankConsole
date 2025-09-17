package org.example.models;
import java.util.UUID;


public class User {
    private UUID id;
    private  String fullname;
    private String email;
    private String adresse;
    private String password;

    public User(String fullname, String email, String adresse, String password) {
      this.id=UUID.randomUUID();
      this.fullname = fullname;
      this.email = email;
      this.adresse = adresse;
      this.password = password;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String newName){
        this.fullname=newName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String newEmail){
        this.email=newEmail;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String newAdresse){
        this.adresse=newAdresse;
    }
    public UUID getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String newPassword){
        this.password=newPassword;
    }


}
