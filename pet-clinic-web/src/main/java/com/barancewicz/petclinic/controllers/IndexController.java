package com.barancewicz.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/","/index","/index.html"})
    public String getIndexPage(Model model){

        return "index";
    }

    @GetMapping("/oups")
    public String oupsHandler(){
        return "notimplemented";
    }
}
