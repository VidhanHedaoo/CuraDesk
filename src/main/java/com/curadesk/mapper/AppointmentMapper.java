package com.curadesk.mapper;

import com.curadesk.dto.AppointmentRequestDto;
import com.curadesk.dto.AppointmentResponseDto;
import com.curadesk.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public Appointment toEntity(AppointmentRequestDto dto){
        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setReason(dto.getReason());

        return appointment;
    }

    public AppointmentResponseDto toResponseDto(Appointment appointment){
        AppointmentResponseDto dto = new AppointmentResponseDto();

        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setReason(appointment.getReason());
        dto.setId(appointment.getId());
        dto.setStatus(appointment.getStatus());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorId(appointment.getDoctor().getId());

        return dto;
    }

    public void updateAppointment(AppointmentRequestDto dto, Appointment appointment){
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setReason(dto.getReason());
    }
}
