package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "My Cheese ");
        model.addAttribute("cheeses", cheeses);

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        cheeses.put(cheeseName, cheeseDescription);
        // redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String deleteCheeseForm(@RequestParam ArrayList<String> delCheese) {
        for (String del : delCheese)
            cheeses.remove(del);
        return "redirect:";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deleteCheeseFormSingle(@RequestParam String delCheese) {
        cheeses.remove(delCheese);
        return "redirect:";
    }

    //public String deleteCheeseFormSingle(@Requ)
}
