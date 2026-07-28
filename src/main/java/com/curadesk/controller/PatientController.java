package com.curadesk.controller;

import com.curadesk.dto.PatientRequestDto;
import com.curadesk.dto.PatientResponseDto;
import com.curadesk.service.PatientService;
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
            @RequestBody PatientRequestDto patientRequestDto) {

        PatientResponseDto response = patientService.savePatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){
        List<PatientResponseDto> response = patientService.getAllPatients();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable Long id){
        PatientResponseDto responselist = patientService.getPatientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(responselist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDto dto){
        PatientResponseDto response = patientService.updatePatient(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
