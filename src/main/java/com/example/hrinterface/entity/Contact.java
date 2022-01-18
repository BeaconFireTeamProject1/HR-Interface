package com.example.hrinterface.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("ID")
    public int ID;

    @Column(name = "personID")
    public int personID;

    @Column(name = "relationship")
    public String relationship;

    @Column(name = "title")
    public String title;

    @Column(name = "isReferrence")
    public boolean isReferrence;

    @Column(name = "isEmergency")
    public boolean isEmergency;
}
