package com.orlab.controllers;

import com.orlab.model.Turniri;
import com.orlab.repository.TurniriRepository;
import com.orlab.services.TurnirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TurnirRestController {

    @Autowired
    TurnirService turnirService;

    @GetMapping("/turniri")
    public List<Turniri> getTurniri(Model model){
        return turnirService.getAllTurniri();
    }
}
