package com.appointment.scheduler.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Integer patientId;
    private String patientName;
    private String gender;
    private String patientIssue;
    private Long contactNumber;
    private String appointmentTime;
    private LocalDate appointmentDate;
}
