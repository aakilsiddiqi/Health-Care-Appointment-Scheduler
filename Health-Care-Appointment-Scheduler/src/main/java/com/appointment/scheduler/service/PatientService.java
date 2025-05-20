package com.appointment.scheduler.service;

import com.appointment.scheduler.dto.PatientDTO;
import com.appointment.scheduler.exception.AppointmentSchedulerException;

public interface PatientService {

    public void addPatient(PatientDTO patientDTO) throws AppointmentSchedulerException;
    public void updateAppointmentTime(Integer patientId, PatientDTO patientDTO) throws AppointmentSchedulerException;
    public void updateAppointmentDate(Integer patientId, PatientDTO patientDTO) throws AppointmentSchedulerException;
}
