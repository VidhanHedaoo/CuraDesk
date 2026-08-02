package com.curadesk.dto;


import com.curadesk.enums.Qualification;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorRequestDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String specialization;

    @NotNull
    private Qualification qualification;

    @NotNull
    private Integer yearsOfExperience;
}
