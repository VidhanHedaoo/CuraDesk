package com.curadesk.controller;

import com.curadesk.dto.PatientRequestDto;
import com.curadesk.dto.PatientResponseDto;
import com.curadesk.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(
            @Valid @RequestBody PatientRequestDto patientRequestDto) {

        PatientResponseDto response = patientService.savePatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){
        List<PatientResponseDto> responselist = patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(responselist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id){
        PatientResponseDto response = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto> updatePatient(
            @PathVariable Long id,@Valid @RequestBody PatientRequestDto dto){
        PatientResponseDto response = patientService.updatePatient(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
