package com.barancewicz.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping({"/owners","owners","/owners/index","/owners/index.html"})
    public String listOwners(Model model){
        return "owners/index";
    }

}
