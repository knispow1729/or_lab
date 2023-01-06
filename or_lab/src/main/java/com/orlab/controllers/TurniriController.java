package com.orlab.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping(value = "/userpage/user")
    @ResponseBody
    public String home(final Authentication authentication) {
        TestingAuthenticationToken token = (TestingAuthenticationToken) authentication;
        DecodedJWT jwt = JWT.decode(token.getCredentials().toString());
        System.out.println(jwt.getClaims());

        String email = jwt.getClaims().get("email").asString();
        String email_vertified = String.valueOf(jwt.getClaims().get("email_verified"));
        String iss = jwt.getClaims().get("iss").asString();
        String sid = jwt.getClaims().get("sid").asString();

        String b =  "Welcome, " + email + " !\t"+ "\temail_vertified: " + email_vertified +"\tiss: "+ iss+"\tsid: "+sid;
        return b;
    }


    @GetMapping("/userpage/refresh")
    public String refreshUser(){
        return "refreshuser";
    }
}
