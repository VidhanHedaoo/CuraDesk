package com.curadesk.repository;

import com.curadesk.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository
        extends JpaRepository<Doctor, Long> {
}
