package com.appointment.scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String patientName;
    private String gender;
    private String patientIssue;
    private Long contactNumber;
    private String appointmentTime;
    private LocalDate appointmentDate;
}
