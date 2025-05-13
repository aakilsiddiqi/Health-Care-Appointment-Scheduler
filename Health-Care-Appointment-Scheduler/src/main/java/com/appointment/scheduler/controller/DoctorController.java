package com.appointment.scheduler.controller;

import com.appointment.scheduler.dto.DoctorDTO;
import com.appointment.scheduler.entity.Doctor;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@Validated
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(value = "/addDoctor")
    public ResponseEntity<String> addDoctor(@Valid @RequestBody DoctorDTO doctorDTO) throws AppointmentSchedulerException {
        doctorService.addDoctorDetails(doctorDTO);
        String msg = "Doctors Details Added !!!";
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PatchMapping("/updateAvailableTime/{doctorId}")
    public ResponseEntity<String> updateAvailableTime(@PathVariable Integer doctorId, @RequestBody String availableTime) throws AppointmentSchedulerException {
        doctorService.updateAvailableTime(doctorId,availableTime);
        String msg = "Available Time Updated Successfully !!";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllAvailableDoctors")
    public ResponseEntity<List<Doctor>> getAllAvailableDoctors() throws AppointmentSchedulerException {
        List<Doctor> doctorList = doctorService.listAllAvailableDoctors();
        return new ResponseEntity<>(doctorList,HttpStatus.OK);
    }

    @PatchMapping("/updateAvailableDate/{doctorId}")
    public ResponseEntity<String> updateAvailableTime(@PathVariable Integer doctorId, @RequestBody DoctorDTO doctorDTO) throws AppointmentSchedulerException {
        doctorService.updateAvailableDate(doctorId,doctorDTO);
        String msg = "Available Date Updated Successfully !!";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @GetMapping(value = "/getDoctorBySpecialization/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialization(@PathVariable String specialization) throws AppointmentSchedulerException {
        List<Doctor> doctorList = doctorService.getDoctorsBySpecialization(specialization);
        return new ResponseEntity<>(doctorList,HttpStatus.OK);
    }

}
