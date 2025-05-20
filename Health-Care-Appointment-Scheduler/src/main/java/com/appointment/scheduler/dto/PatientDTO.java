package com.appointment.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Integer patientId;
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$", message = "Please provide valid Name !!")
    private String patientName;
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;
    @NotNull
    private String patientIssue;
    @Pattern(regexp = "\\d{10}", message = "Contact number must be exactly 10 digits")
    private Long contactNumber;
    @NotNull(message = "Appointment Time is Required !!!")
    private String appointmentTime;
    @NotNull(message = "Appointment date is required !!")
    @FutureOrPresent(message = "Appointment date must be today or in the future !!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;
}
