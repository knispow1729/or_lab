package com.orlab.services;

public class TurnirNotFoundException extends RuntimeException {
    public TurnirNotFoundException(Integer id){
        super("Could not find turnir "+id);
    }
}
