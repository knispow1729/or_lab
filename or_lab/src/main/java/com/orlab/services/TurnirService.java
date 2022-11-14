package com.orlab.services;

import com.orlab.model.Turniri;
import com.orlab.repository.TurniriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnirService {

    private final TurniriRepository turniriRepository;

    @Autowired
    public TurnirService(TurniriRepository turniriRepository) {
        this.turniriRepository = turniriRepository;
    }

    public List<Turniri> getAllTurniri(){
        return turniriRepository.findAll();
    }
}
