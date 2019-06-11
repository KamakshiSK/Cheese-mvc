package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getAll() {
        return users;
    }

    public static void add(User newUser) {
        users.add(newUser);
    }

    public static User getById(int id) {
        User aUser = null;
        for (User eachUser : users) {
            if (eachUser.getUserId() == id)
                aUser = eachUser;
        }
        return aUser;
    }

    public static void deleteUser(int id) {
        User deleterUser = getById(id);
        users.remove(deleterUser);
    }

}
