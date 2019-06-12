package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        User user = new User("", "", "");
        model.addAttribute("user", user);
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {

        // check fields not empty
        if (user.getName().isEmpty()) {
            user.setEmail(user.getEmail());
            return "user/add";
        }

        if (user.getEmail().isEmpty()) {
            user.setName(user.getName());
            return "user/add";
        }

        if (user.getPassword().isEmpty()) {
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            return "user/add";
        }
        // check if username is between 5 and 15 characters long
        if (!(user.getName().length() > 5 && user.getName().length() < 15)) {
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            return "user/add";
        }

        // check if username contains only letters
        /*if (!user.getName().contains("^[a-zA-Z]*$")){
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            return "user/add";
        }*/

        if (!user.getPassword().equals(verify)) {
            user.setEmail(user.getEmail());
            user.setName(user.getName());
            return "user/add";
        }

        user.setDateJoined(LocalDateTime.now());
        UserData.add(user);

        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "Welcome Users.");
        return "user/index";
    }

    @RequestMapping(value = "userList/{userId}")
    public String displayUsers(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);

        model.addAttribute("user", user);
        model.addAttribute("title", "User Information");
        return "user/userList";

    }


}
