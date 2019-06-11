package org.launchcode.cheesemvc.models;

import java.time.LocalDateTime;

public class User {
    private static int nextUserId = 1;
    private int userId;
    private String name;
    private String password;
    private String email;
    private LocalDateTime dateJoined;

    public User(String name, String password, String email) {
        this();
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {
        userId = nextUserId;
        nextUserId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }
}
