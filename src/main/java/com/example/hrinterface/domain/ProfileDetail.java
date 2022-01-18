package com.example.hrinterface.domain;

import com.example.hrinterface.entity.Address;
import com.example.hrinterface.entity.Contact;
import com.example.hrinterface.entity.Employee;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDetail {
    Employee employee;
    Contact contact;
    List<Address> addressList;
}
