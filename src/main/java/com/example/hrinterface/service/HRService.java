package com.example.hrinterface.service;

import com.example.hrinterface.dao.EmployeeDAO;
import com.example.hrinterface.dao.PersonDAO;
import com.example.hrinterface.dao.RegistrationTokenDAO;
import com.example.hrinterface.dao.UserRoleDAO;
import com.example.hrinterface.entity.RegistrationToken;
import com.example.hrinterface.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {
    @Autowired
    RegistrationTokenDAO registrationTokenDAO;

    private static final Logger logger = LoggerFactory.getLogger(HRService.class);

    public void createToken(RegistrationToken registrationToken){
        try{
            registrationTokenDAO.createToken(registrationToken);
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
    }

    public RegistrationToken findToken(String token){
        try{
            return registrationTokenDAO.findTokenByToken(token);
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
        return null;
    }


}
