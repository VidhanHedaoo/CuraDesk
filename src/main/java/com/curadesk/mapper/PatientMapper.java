package com.curadesk.mapper;

import com.curadesk.dto.PatientRequestDto;
import com.curadesk.dto.PatientResponseDto;
import com.curadesk.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDto dto) {
        Patient patient = new Patient();

        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setGender(dto.getGender());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setEmergencyContact(dto.getEmergencyContact());
        patient.setPhoneNumber(dto.getPhoneNumber());

        return patient;
    }

    public PatientResponseDto toResponseDto(Patient patient) {
        PatientResponseDto dto = new PatientResponseDto();

        dto.setId(patient.getId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setGender(patient.getGender());
        dto.setBloodGroup(patient.getBloodGroup());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setEmergencyContact(patient.getEmergencyContact());
        dto.setPhoneNumber(patient.getPhoneNumber());

        return dto;
    }

    public void updateEntity(PatientRequestDto dto,Patient patient) {

        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setGender(dto.getGender());
        patient.setBloodGroup(dto.getBloodGroup());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setEmergencyContact(dto.getEmergencyContact());
        patient.setPhoneNumber(dto.getPhoneNumber());

    }
}
