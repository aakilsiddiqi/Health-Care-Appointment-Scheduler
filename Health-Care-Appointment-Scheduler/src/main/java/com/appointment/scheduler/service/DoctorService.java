package com.appointment.scheduler.service;

import com.appointment.scheduler.dto.DoctorDTO;
import com.appointment.scheduler.entity.Doctor;
import com.appointment.scheduler.exception.AppointmentSchedulerException;

import java.time.LocalDate;
import java.util.List;

public interface DoctorService {

    public void addDoctorDetails(DoctorDTO doctorDTO) throws AppointmentSchedulerException;

    public void updateAvailableTime(Integer doctorId, String availableTime) throws AppointmentSchedulerException;

    public List<Doctor> listAllAvailableDoctors() throws AppointmentSchedulerException;

    public void updateAvailableDate(Integer doctorId, DoctorDTO doctorDTO) throws AppointmentSchedulerException;

    public List<Doctor> getDoctorsBySpecialization(String specialization) throws AppointmentSchedulerException;
}
