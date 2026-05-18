package com.mycompany.viewprofile;

// encapsulation 
public class User {
    private String username;
    private String password;

    // base / parent 
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public String getConfDisplayInfo() {
        return "Welcome, " + username + "!";
    }
}