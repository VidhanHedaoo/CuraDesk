package com.curadesk.entity;

import com.curadesk.enums.Qualification;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String specialization;
    private Integer yearsOfExperience;

    @Enumerated(EnumType.STRING)
    private Qualification qualification;
}
