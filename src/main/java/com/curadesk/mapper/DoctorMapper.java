package com.curadesk.mapper;

import com.curadesk.dto.DoctorRequestDto;
import com.curadesk.dto.DoctorResponseDto;
import com.curadesk.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDto doctorRequestDto){
        Doctor doctor = new Doctor();

        doctor.setFirstName(doctorRequestDto.getFirstName());
        doctor.setLastName(doctorRequestDto.getLastName());
        doctor.setEmail(doctorRequestDto.getEmail());
        doctor.setPhoneNumber(doctorRequestDto.getPhoneNumber());
        doctor.setQualification(doctorRequestDto.getQualification());
        doctor.setSpecialization(doctorRequestDto.getSpecialization());
        doctor.setYearsOfExperience(doctorRequestDto.getYearsOfExperience());

        return doctor;
    }

    public DoctorResponseDto toResponseDto(Doctor doctor){
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

        doctorResponseDto.setId(doctor.getId());
        doctorResponseDto.setFirstName(doctor.getFirstName());
        doctorResponseDto.setLastName(doctor.getLastName());
        doctorResponseDto.setEmail(doctor.getEmail());
        doctorResponseDto.setPhoneNumber(doctor.getPhoneNumber());
        doctorResponseDto.setQualification(doctor.getQualification());
        doctorResponseDto.setSpecialization(doctor.getSpecialization());
        doctorResponseDto.setYearsOfExperience(doctor.getYearsOfExperience());

        return doctorResponseDto;
    }

    public void updateEntity(DoctorRequestDto dto, Doctor doctor){
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setEmail(dto.getEmail());
        doctor.setPhoneNumber(dto.getPhoneNumber());
        doctor.setQualification(dto.getQualification());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setYearsOfExperience(dto.getYearsOfExperience());
    }
}
