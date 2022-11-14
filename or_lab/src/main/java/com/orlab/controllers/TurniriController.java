package com.orlab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TurniriController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/filter")
    public String filter(){
        return "datatable";
    }

    @PostMapping("/filter")
    public String getInput(){
        return null;
    }
}
