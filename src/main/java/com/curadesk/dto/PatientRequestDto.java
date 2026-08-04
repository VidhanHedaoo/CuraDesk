package com.curadesk.dto;

import com.curadesk.enums.BloodGroup;
import com.curadesk.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PatientRequestDto {

    @NotBlank(message = "FirstName is required")
    private String firstName;

    @NotBlank(message = "LastName is required")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "PhoneNumber is required")
    private String phoneNumber;

    private String address;
    private String emergencyContact;
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "BloodGroup is required")
    private BloodGroup bloodGroup;
}
