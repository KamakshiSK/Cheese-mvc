package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    @RequestMapping(value="")
    public String index(){
        return "cheese/index";
    }
}
