package com.example.hrinterface.domain;

import com.example.hrinterface.entity.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employment {
    public String workAuthorization;
    public String authorizationStartDate;
    public String authorizationEndDate;
    public String employmentStartDate;
    public String employmentEndDate;
    public String title;

    public Employment(Employee employee){
        this.workAuthorization = employee.getVisaStatus().getVisaType();
        this.authorizationStartDate = employee.getVisaStartDate();
        this.authorizationEndDate = employee.getVisaEndDate();
        this.title = employee.getTitle();
        this.employmentStartDate = employee.getStartDate();
        this.employmentEndDate = employee.getEndDate();
    }
}