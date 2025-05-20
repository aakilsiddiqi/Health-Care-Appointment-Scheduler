package com.appointment.scheduler.dto;

import com.appointment.scheduler.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {
    private Integer appointmentId;
    @NotNull(message = "Doctor Id is required !!!")
    private Integer doctorId;
    @NotNull(message = "Patient Id is required !!!")
    private Integer patientId;
    @NotNull(message = "Appointment Time is required !!!")
    private String appointmentTime;
    @NotNull(message = "Available date is required !!")
    @FutureOrPresent(message = "Available date must be today or in the future !!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;
    private Status status;
}
