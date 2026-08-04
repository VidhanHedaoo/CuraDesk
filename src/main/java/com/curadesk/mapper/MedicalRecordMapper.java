package com.curadesk.mapper;

import com.curadesk.dto.MedicalRecordRequestDto;
import com.curadesk.dto.MedicalRecordResponseDto;
import com.curadesk.entity.MedicalRecord;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordMapper {

    public MedicalRecord toEntity(MedicalRecordRequestDto dto) {

        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setDiagnosis(dto.getDiagnosis());
        medicalRecord.setTreatment(dto.getTreatment());
        medicalRecord.setNotes(dto.getNotes());

        return medicalRecord;
    }

    public MedicalRecordResponseDto toResponseDto(MedicalRecord medicalRecord) {

        MedicalRecordResponseDto dto = new MedicalRecordResponseDto();

        dto.setId(medicalRecord.getId());
        dto.setDiagnosis(medicalRecord.getDiagnosis());
        dto.setTreatment(medicalRecord.getTreatment());
        dto.setNotes(medicalRecord.getNotes());
        dto.setVisitDate(medicalRecord.getVisitDate());
        dto.setPatientId(medicalRecord.getPatient().getId());
        dto.setDoctorId(medicalRecord.getDoctor().getId());

        return dto;
    }

    public void updateMedicalRecord(MedicalRecordRequestDto dto, MedicalRecord medicalRecord) {

        medicalRecord.setDiagnosis(dto.getDiagnosis());
        medicalRecord.setTreatment(dto.getTreatment());
        medicalRecord.setNotes(dto.getNotes());
    }
}