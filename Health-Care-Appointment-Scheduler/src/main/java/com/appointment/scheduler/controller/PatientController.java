package com.appointment.scheduler.controller;

import com.appointment.scheduler.dto.PatientDTO;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping(value = "/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody PatientDTO patientDTO) throws AppointmentSchedulerException {
        patientService.addPatient(patientDTO);
        String msg = "Patient Added Successfully";
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/updateAppointmentTime/{patientId}")
    public ResponseEntity<String> updateAppointmentTime(@PathVariable Integer patientId, @RequestBody PatientDTO patientDTO) throws AppointmentSchedulerException {
        patientService.updateAppointmentTime(patientId,patientDTO);
        String msg = "Appointment Time Updated Successfully !!!";
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @PatchMapping(value = "/updateAppointmentDate/{patientId}")
    public ResponseEntity<String> updateAppointmentDate(@PathVariable Integer patientId, @RequestBody PatientDTO patientDTO) throws AppointmentSchedulerException {
        patientService.updateAppointmentDate(patientId,patientDTO);
        String msg = "Appointment Time Updated Successfully !!!";
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }
}
