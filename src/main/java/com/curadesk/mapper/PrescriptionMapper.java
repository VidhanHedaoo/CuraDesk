package com.curadesk.mapper;

import com.curadesk.dto.PrescriptionRequestDto;
import com.curadesk.dto.PrescriptionResponseDto;
import com.curadesk.entity.Prescription;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionMapper {

    public Prescription toEntity(PrescriptionRequestDto dto) {

        Prescription prescription = new Prescription();

        prescription.setMedicineName(dto.getMedicineName());
        prescription.setDosage(dto.getDosage());
        prescription.setFrequency(dto.getFrequency());
        prescription.setDurationInDays(dto.getDurationInDays());
        prescription.setInstructions(dto.getInstructions());

        return prescription;
    }

    public PrescriptionResponseDto toResponseDto(Prescription prescription) {

        PrescriptionResponseDto dto = new PrescriptionResponseDto();

        dto.setId(prescription.getId());
        dto.setMedicineName(prescription.getMedicineName());
        dto.setDosage(prescription.getDosage());
        dto.setFrequency(prescription.getFrequency());
        dto.setDurationInDays(prescription.getDurationInDays());
        dto.setInstructions(prescription.getInstructions());
        dto.setMedicalRecordId(
                prescription.getMedicalRecord().getId()
        );

        return dto;
    }

    public void updatePrescription(
            PrescriptionRequestDto dto,
            Prescription prescription) {

        prescription.setMedicineName(dto.getMedicineName());
        prescription.setDosage(dto.getDosage());
        prescription.setFrequency(dto.getFrequency());
        prescription.setDurationInDays(dto.getDurationInDays());
        prescription.setInstructions(dto.getInstructions());
    }
}