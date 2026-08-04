package com.curadesk.controller;

import com.curadesk.dto.MedicalRecordRequestDto;
import com.curadesk.dto.MedicalRecordResponseDto;
import com.curadesk.service.MedicalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordResponseDto> saveMedicalRecord(
            @Valid @RequestBody MedicalRecordRequestDto dto) {

        MedicalRecordResponseDto response = medicalRecordService.saveMedicalRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MedicalRecordResponseDto>> getAllMedicalRecords() {

        List<MedicalRecordResponseDto> response =
                medicalRecordService.getAllMedicalRecords();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordResponseDto> getMedicalRecordById(
            @PathVariable Long id) {

        MedicalRecordResponseDto response =
                medicalRecordService.getMedicalRecordById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecordResponseDto> updateMedicalRecord(
            @PathVariable Long id,
            @Valid @RequestBody MedicalRecordRequestDto dto) {

        MedicalRecordResponseDto response =
                medicalRecordService.updateMedicalRecord(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(
            @PathVariable Long id) {

        medicalRecordService.deleteMedicalRecord(id);

        return ResponseEntity.noContent().build();
    }
}