package com.curadesk.service;

import com.curadesk.dto.PatientRequestDto;
import com.curadesk.dto.PatientResponseDto;
import com.curadesk.entity.Patient;
import com.curadesk.exception.PatientNotFoundException;
import com.curadesk.mapper.PatientMapper;
import com.curadesk.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto) {

        Patient patient = patientMapper.toEntity(patientRequestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toResponseDto(savedPatient);
    }

    public List<PatientResponseDto> getAllPatients(){
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponseDto)
                .toList();
    }

    public PatientResponseDto getPatientById(Long id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException
                        ("Patient not found with id: " + id));

        return patientMapper.toResponseDto(patient);
    }

    public PatientResponseDto updatePatient(Long id, PatientRequestDto dto) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException
                        ("Patient not found with id: " + id));

        patientMapper.updateEntity(dto, patient);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toResponseDto(savedPatient);
    }

    public void deletePatientById(Long id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException
                        ("Patient not found with id: " + id));

        patientRepository.delete(patient);
    }
}
