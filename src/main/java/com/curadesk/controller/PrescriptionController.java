package com.curadesk.controller;

import com.curadesk.dto.PrescriptionRequestDto;
import com.curadesk.dto.PrescriptionResponseDto;
import com.curadesk.service.PrescriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<PrescriptionResponseDto> savePrescription(
            @Valid @RequestBody PrescriptionRequestDto dto) {

        PrescriptionResponseDto response =
                prescriptionService.savePrescription(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionResponseDto>> getAllPrescriptions() {

        List<PrescriptionResponseDto> response =
                prescriptionService.getAllPrescriptions();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> getPrescriptionById(
            @PathVariable Long id) {

        PrescriptionResponseDto response =
                prescriptionService.getPrescriptionById(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionResponseDto> updatePrescription(
            @PathVariable Long id,
            @Valid @RequestBody PrescriptionRequestDto dto) {

        PrescriptionResponseDto response =
                prescriptionService.updatePrescription(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(
            @PathVariable Long id) {

        prescriptionService.deletePrescription(id);

        return ResponseEntity.noContent().build();
    }
}
