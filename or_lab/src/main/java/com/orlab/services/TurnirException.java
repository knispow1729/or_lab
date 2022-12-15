package com.orlab.services;

import com.orlab.model.Turniri;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurnirException extends Exception{
    public TurnirException(String s){
        super(s);
    }
}
