package com.appointment.scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "doctor")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    private String doctorName;
    private String specialization;
    private String availableTime;
    private LocalDate availableDate;

}
