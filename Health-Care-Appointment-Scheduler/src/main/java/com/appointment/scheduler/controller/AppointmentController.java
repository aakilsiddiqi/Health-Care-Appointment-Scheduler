package com.appointment.scheduler.controller;

import com.appointment.scheduler.dto.AppointmentDTO;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(value = "/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDTO appointmentDTO) throws AppointmentSchedulerException {
        appointmentService.bookAppointment(appointmentDTO);
        String msg = "Appointment Booked Successfully !!";
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
