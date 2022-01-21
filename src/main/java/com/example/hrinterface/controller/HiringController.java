package com.example.hrinterface.controller;

import com.example.hrinterface.constant.JwtConstant;
import com.example.hrinterface.entity.RegistrationToken;
import com.example.hrinterface.security.util.HiringJwtUtil;
import com.example.hrinterface.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@RestController
public class HiringController {
    @Autowired
    HRService hrService;

    @PostMapping("/hr/token")
    public String generateToken(@RequestBody Map<String, Object> payload){
        if(!payload.containsKey("email")){
            return "error";
        }
        else{
            Date expiration = Date.from(ZonedDateTime.now().plusMinutes(JwtConstant.JWT_VALID_DURATION).toInstant());
            String email = (String)payload.get("email");
            String subject = email + expiration.toString();
            String token = HiringJwtUtil.generateToken(subject, JwtConstant.JWT_VALID_DURATION);
            RegistrationToken registrationToken = new RegistrationToken();
            registrationToken.setToken(token);
            registrationToken.setEmail(email);
            registrationToken.setValidDuration(expiration.toString());
            hrService.createToken(registrationToken);
            System.out.println(hrService.findToken(token));
            return "http://localhost:9999/auth/register/"+token;
        }
    }
}
