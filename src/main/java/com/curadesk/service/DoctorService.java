package com.curadesk.service;

import com.curadesk.dto.DoctorRequestDto;
import com.curadesk.dto.DoctorResponseDto;
import com.curadesk.entity.Doctor;
import com.curadesk.exception.DoctorNotFoundException;
import com.curadesk.mapper.DoctorMapper;
import com.curadesk.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorResponseDto saveDoctor(DoctorRequestDto doctorRequestDto){
        Doctor doctor = doctorMapper.toEntity(doctorRequestDto);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponseDto(savedDoctor);
    }

    public List<DoctorResponseDto> getAllDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toResponseDto)
                .toList();
    }

    public DoctorResponseDto getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException
                        ("Doctor not found with id " + id));

        return doctorMapper.toResponseDto(doctor);
    }

    public DoctorResponseDto updateDoctor(Long id ,DoctorRequestDto dto){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException
                        ("Doctor not found with id " + id));

        doctorMapper.updateEntity(dto, doctor);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponseDto(savedDoctor);
    }

    public void deleteDoctorById(Long id){

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException
                        ("Doctor not found with id " + id));

        doctorRepository.delete(doctor);
    }

}
