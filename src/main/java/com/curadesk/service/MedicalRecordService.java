package com.curadesk.service;

import com.curadesk.dto.MedicalRecordRequestDto;
import com.curadesk.dto.MedicalRecordResponseDto;
import com.curadesk.entity.Doctor;
import com.curadesk.entity.MedicalRecord;
import com.curadesk.entity.Patient;
import com.curadesk.exception.DoctorNotFoundException;
import com.curadesk.exception.MedicalRecordNotFoundException;
import com.curadesk.exception.PatientNotFoundException;
import com.curadesk.mapper.MedicalRecordMapper;
import com.curadesk.repository.DoctorRepository;
import com.curadesk.repository.MedicalRecordRepository;
import com.curadesk.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final MedicalRecordMapper medicalRecordMapper;

    public MedicalRecordResponseDto saveMedicalRecord(MedicalRecordRequestDto dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException(
                        "Patient not found with id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(
                        "Doctor not found with id: " + dto.getDoctorId()));

        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(dto);

        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setVisitDate(LocalDate.now());

        MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);

        return medicalRecordMapper.toResponseDto(savedMedicalRecord);
    }

    public MedicalRecordResponseDto getMedicalRecordById(Long id) {

        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new MedicalRecordNotFoundException(
                        "Medical record not found with id: " + id));

        return medicalRecordMapper.toResponseDto(medicalRecord);
    }

    public List<MedicalRecordResponseDto> getAllMedicalRecords() {

        return medicalRecordRepository.findAll()
                .stream()
                .map(medicalRecordMapper::toResponseDto)
                .toList();
    }

    public MedicalRecordResponseDto updateMedicalRecord(Long id, MedicalRecordRequestDto dto) {

        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new MedicalRecordNotFoundException(
                        "Medical record not found with id: " + id));

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException(
                        "Patient not found with id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(
                        "Doctor not found with id: " + dto.getDoctorId()));

        medicalRecordMapper.updateMedicalRecord(dto, medicalRecord);

        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);

        MedicalRecord updatedMedicalRecord = medicalRecordRepository.save(medicalRecord);

        return medicalRecordMapper.toResponseDto(updatedMedicalRecord);
    }

    public void deleteMedicalRecord(Long id) {

        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new MedicalRecordNotFoundException(
                        "Medical record not found with id: " + id));

        medicalRecordRepository.delete(medicalRecord);
    }
}