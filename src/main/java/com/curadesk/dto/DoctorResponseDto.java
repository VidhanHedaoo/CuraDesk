package com.curadesk.dto;

import com.curadesk.enums.Qualification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;
    private Qualification qualification;
    private Integer yearsOfExperience;
}
