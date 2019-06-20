package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class User {
    private static int nextUserId = 1;
    private int userId;
    @NotNull
    @NotEmpty(message = "Please provide user name.")
    private String name;
    @NotNull
    @NotEmpty(message = "Please provide password.")
    @Size(min = 5, max = 15)
    private String password;

    @Email(message = "Please provide valid e-mail.")
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
