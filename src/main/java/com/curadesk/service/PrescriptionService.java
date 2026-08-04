package com.curadesk.service;

import com.curadesk.dto.PrescriptionRequestDto;
import com.curadesk.dto.PrescriptionResponseDto;
import com.curadesk.entity.MedicalRecord;
import com.curadesk.entity.Prescription;
import com.curadesk.exception.MedicalRecordNotFoundException;
import com.curadesk.exception.PrescriptionNotFoundException;
import com.curadesk.mapper.PrescriptionMapper;
import com.curadesk.repository.MedicalRecordRepository;
import com.curadesk.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final PrescriptionMapper prescriptionMapper;

    public PrescriptionResponseDto savePrescription(PrescriptionRequestDto dto) {

        MedicalRecord medicalRecord = medicalRecordRepository.findById(dto.getMedicalRecordId())
                .orElseThrow(() -> new MedicalRecordNotFoundException(
                        "Medical record not found with id: " + dto.getMedicalRecordId()));

        Prescription prescription = prescriptionMapper.toEntity(dto);

        prescription.setMedicalRecord(medicalRecord);

        Prescription savedPrescription = prescriptionRepository.save(prescription);

        return prescriptionMapper.toResponseDto(savedPrescription);
    }

    public PrescriptionResponseDto getPrescriptionById(Long id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(
                        "Prescription not found with id: " + id));

        return prescriptionMapper.toResponseDto(prescription);
    }

    public List<PrescriptionResponseDto> getAllPrescriptions() {

        return prescriptionRepository.findAll()
                .stream()
                .map(prescriptionMapper::toResponseDto)
                .toList();
    }

    public PrescriptionResponseDto updatePrescription(
            Long id,
            PrescriptionRequestDto dto) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(
                        "Prescription not found with id: " + id));

        MedicalRecord medicalRecord = medicalRecordRepository.findById(dto.getMedicalRecordId())
                .orElseThrow(() -> new MedicalRecordNotFoundException(
                        "Medical record not found with id: " + dto.getMedicalRecordId()));

        prescriptionMapper.updatePrescription(dto, prescription);

        prescription.setMedicalRecord(medicalRecord);

        Prescription updatedPrescription = prescriptionRepository.save(prescription);

        return prescriptionMapper.toResponseDto(updatedPrescription);
    }

    public void deletePrescription(Long id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new PrescriptionNotFoundException(
                        "Prescription not found with id: " + id));

        prescriptionRepository.delete(prescription);
    }
}
