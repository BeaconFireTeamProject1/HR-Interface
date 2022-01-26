package com.example.hrinterface.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="PersonalDocument")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DigitalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TemplateLocation")
    private String templateLocation;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    @Column(name = "Required")
    private boolean required;

}
