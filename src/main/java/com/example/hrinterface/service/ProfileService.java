package com.example.hrinterface.service;

import com.example.hrinterface.dao.*;
import com.example.hrinterface.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    PersonDAO personDAO;
    @Autowired
    ContactDAO contactDAO;
    @Autowired
    AddressDAO addressDAO;
    @Autowired
    UserRoleDAO userRoleDAO;

    private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

    public List<Employee> getAllEmployee(){
        try {
            return employeeDAO.getAllEmployee();
        }catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public Employee findEmployeeByID(int ID){
        try {
            return employeeDAO.findEmployeeByID(ID);
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public UserRole findUserRoleByID(int ID){
        try {
            return userRoleDAO.findUserRoleByID(ID);
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public Person findPersonByID(int ID){
        try {
            return personDAO.findPersonByID(ID);
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public Contact getContactById(int ID){
        try {
            return contactDAO.getContactByPersonId(ID);
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public List<Address> getAddressByPersonId(int ID){
        try {
            return addressDAO.getAddressByPersonId(ID);
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;}

    public void updateVisaInfo(int id, String name, String startDate, String endDate){
        String[] names = name.split(" ");
        if(names.length == 2) {
            try {
                personDAO.updateName(id, names);
            }catch (Exception e){
                logger.info("Catch an Exception: "+e );
            }
        }
        try {
            employeeDAO.updateVisaInfo(id, startDate, endDate);
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
    }

    public int createPerson(Person person){
        try{
           return personDAO.createPerson(person);
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
        return -1;
    }

    public Employee findEmployeebyUserID(int ID){
        try {
            return employeeDAO.findEmployeeByPersonID(personDAO.findPersonByUserID(ID).getID());
        }
        catch (Exception E){
            logger.info("Catch an Exception: "+ E );
        }
        return null;
    }

    public List<UserRole> getRegList(){
        try{
            return userRoleDAO.getRegList();
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
        return null;
    }

    public void updateUserRole(UserRole userRole){
        try{
            userRoleDAO.updateUserRole(userRole);
        }catch (Exception e){
            logger.info("Catch an Exception: "+e );
        }
    }
}
