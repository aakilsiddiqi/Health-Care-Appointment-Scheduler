package com.appointment.scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    private Integer doctorId;
    private Integer patientId;
    private String appointmentTime;
    private LocalDate appointmentDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
