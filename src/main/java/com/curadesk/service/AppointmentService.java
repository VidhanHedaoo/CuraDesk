package com.curadesk.service;

import com.curadesk.dto.AppointmentRequestDto;
import com.curadesk.dto.AppointmentResponseDto;
import com.curadesk.entity.Appointment;
import com.curadesk.entity.Doctor;
import com.curadesk.entity.Patient;
import com.curadesk.enums.AppointmentStatus;
import com.curadesk.exception.AppointmentNotFoundException;
import com.curadesk.exception.DoctorNotFoundException;
import com.curadesk.exception.PatientNotFoundException;
import com.curadesk.mapper.AppointmentMapper;
import com.curadesk.repository.AppointmentRepository;
import com.curadesk.repository.DoctorRepository;
import com.curadesk.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;


    public AppointmentResponseDto saveAppointment(AppointmentRequestDto dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()-> new PatientNotFoundException
                        ("Patient not found with id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new DoctorNotFoundException
                        ("Doctor not found with id: " + dto.getDoctorId()));

        Appointment appointment = appointmentMapper.toEntity(dto);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus(AppointmentStatus.SCHEDULED);

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponseDto(savedAppointment);
    }

    public AppointmentResponseDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new AppointmentNotFoundException("Appointment not found with id: " + id));

        return appointmentMapper.toResponseDto(appointment);
    }

    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointmentMapper :: toResponseDto)
                .toList();
    }

    public AppointmentResponseDto updateAppointmentById(Long id, AppointmentRequestDto dto) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new AppointmentNotFoundException("Appointment not found with id: " + id));

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(()-> new PatientNotFoundException
                        ("Patient not found with id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(()-> new DoctorNotFoundException
                        ("Doctor not found with id: " + dto.getDoctorId()));

        appointmentMapper.updateAppointment(dto, appointment);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponseDto(updatedAppointment);
    }

    public void deleteAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(()-> new AppointmentNotFoundException("Appointment not found with id: " + id));

        appointmentRepository.delete(appointment);
    }
}
