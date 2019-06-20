package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("title", "My Cheese ");
        model.addAttribute("cheeses", cheeseDao.findAll());

        return "cheese/index";
    }

    // displays add form on GET request and renders add view
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    // when add button is clicked this POST method is called and redirected to the same page
    @RequestMapping(value = "add", method=RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }

        cheeseDao.save(newCheese);
        // redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Delete Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam int[] delCheese) {
        for (int del : delCheese)
            cheeseDao.delete(del);
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        Cheese c = cheeseDao.findOne(cheeseId);
        model.addAttribute("cheese", c);
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        // Need to fix this code
        Cheese c = cheeseDao.findOne(newCheese.getId());
        cheeseDao.delete(c.getId());
        cheeseDao.save(newCheese);
        //model.addAttribute("cheese", newCheese);
        /*c.setName(newCheese.getName());
        c.setDescription(newCheese.getDescription());
        c.setType(newCheese.getType());
        c.setRatings(newCheese.getRatings())*/
        return "redirect:";
    }

}
