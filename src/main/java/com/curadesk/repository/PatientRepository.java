package com.curadesk.repository;

import com.curadesk.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository
        extends JpaRepository<Patient, Long>{

}
