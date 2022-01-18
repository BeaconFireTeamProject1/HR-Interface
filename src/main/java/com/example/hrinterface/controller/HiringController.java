package com.example.hrinterface.controller;

import com.example.hrinterface.constant.JwtConstant;
import com.example.hrinterface.security.util.JwtUtil;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

@RestController
public class HiringController {
    @PostMapping("/hiring/token")
    public String generateToken(@RequestBody Map<String, Object> payload){
        if(!payload.containsKey("email")){
            return "error";
        }
        else{
            String token = JwtUtil.generateToken((String)payload.get("email"), JwtConstant.JWT_VALID_DURATION);
            System.out.println(token);
            String email = JwtUtil.getSubjectFromJwt(token);
            System.out.println(email);
            return "http://localhost:8080/register/"+token;
        }
    }
}
