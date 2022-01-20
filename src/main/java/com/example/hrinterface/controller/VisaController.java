package com.example.hrinterface.controller;

import com.example.hrinterface.domain.VisaDetail;
import com.example.hrinterface.domain.VisaProfile;
import com.example.hrinterface.entity.ApplicationWorkflow;
import com.example.hrinterface.entity.Employee;
import com.example.hrinterface.service.ProfileService;
import com.example.hrinterface.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VisaController {
    @Autowired
    ProfileService profileService;
    @Autowired
    VisaService visaService;

    @GetMapping({"/hr/visa-profile", "/hr/homepage"})
    public List<VisaProfile> getVisaProfile(){
        List<Employee> employeeList = profileService.getAllEmployee();
        List<VisaProfile> visaProfileList = new ArrayList<>();
        for(int i =0; i < employeeList.size(); i++){
            visaProfileList.add(new VisaProfile(employeeList.get(i)));
        }
        return visaProfileList;
    }

    @GetMapping({"/hr/visa-info", "/hr/visa-info/{id}"})
    public Object getVisaDetail(@PathVariable(required = false)Integer id){
        if(id == null){
            return "error";
        }
        Employee e = profileService.findEmployeeByID(id);
        if(e == null){
            return "error";
        }
        else {
            ApplicationWorkflow a = visaService.getWorkflowByEmployeeId(id);
            VisaDetail v = new VisaDetail(e, a);
            return v;
        }

    }
}
