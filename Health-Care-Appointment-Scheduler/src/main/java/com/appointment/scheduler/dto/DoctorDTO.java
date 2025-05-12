package com.appointment.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Integer doctorID;
    @NotNull(message = "Doctor Name is Required !!")
    private String doctorName;
    @NotNull(message = "Specialization details required !!")
    private String specialization;
    @NotNull(message = "Available Time is Required !!")
    private String availableTime;
    @NotNull(message = "Available date is required !!")
    @FutureOrPresent(message = "Available date must be today or in the future !!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate availableDate;
}
