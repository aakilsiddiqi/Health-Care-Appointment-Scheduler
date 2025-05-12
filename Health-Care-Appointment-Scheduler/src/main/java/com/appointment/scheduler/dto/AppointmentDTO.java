package com.appointment.scheduler.dto;

import com.appointment.scheduler.entity.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {
    private Integer appointmentId;
    private Integer doctorId;
    private Integer patientId;
    private String appointmentTime;
    private LocalDate appointmentDate;
    private Status status;
}
