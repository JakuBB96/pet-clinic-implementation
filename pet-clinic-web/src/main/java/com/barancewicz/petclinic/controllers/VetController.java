package com.barancewicz.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {


    @GetMapping({"/vets","vets","/vets/index","/vets/index.html"})
    public String listVets(Model model){
        return "vets/index";
    }
}
