package com.curadesk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordResponseDto {
    private Long id;
    private String diagnosis;
    private String treatment;
    private String notes;
    private LocalDate visitDate;
    private Long patientId;
    private Long doctorId;
}
