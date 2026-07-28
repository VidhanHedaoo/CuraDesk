package com.curadesk.dto;

import com.curadesk.enums.BloodGroup;
import com.curadesk.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String emergencyContact;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BloodGroup bloodGroup;
}
