package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    @RequestMapping(value="")
    public String index(Model model){

        ArrayList<String> chesses = new ArrayList<>();
        chesses.add("Parmesan");
        chesses.add("Cheddar");
        chesses.add("Sharp Cheddar");
        chesses.add("Colby Jack");

        model.addAttribute("title", "My Cheese ");
        model.addAttribute("cheeses", chesses );

        return "cheese/index";
    }
}
