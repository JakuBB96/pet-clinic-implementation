package com.barancewicz.petclinic.controllers;

import com.barancewicz.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"/owners","owners","/owners/index","/owners/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

}
