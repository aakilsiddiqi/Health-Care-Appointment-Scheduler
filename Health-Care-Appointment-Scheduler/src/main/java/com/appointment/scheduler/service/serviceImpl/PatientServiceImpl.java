package com.appointment.scheduler.service.serviceImpl;

import com.appointment.scheduler.dto.PatientDTO;
import com.appointment.scheduler.entity.Patient;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.repo.PatientRepo;
import com.appointment.scheduler.service.PatientService;
import com.appointment.scheduler.utility.AppointmentSchedulerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(value = "patientService")
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @Override
    public void addPatient(PatientDTO patientDTO) throws AppointmentSchedulerException {
        if (AppointmentSchedulerUtility.isWithinAllowedTime(patientDTO.getAppointmentTime())) {
            Patient patient = new Patient();
            patient.setPatientName(patientDTO.getPatientName());
            patient.setPatientIssue(patientDTO.getPatientIssue());
            patient.setGender(patientDTO.getGender());
            patient.setContactNumber(patientDTO.getContactNumber());
            patient.setAppointmentDate(patientDTO.getAppointmentDate());
            patient.setAppointmentTime(patientDTO.getAppointmentTime());
            patientRepo.save(patient);
        } else
            throw new AppointmentSchedulerException("Appointment time should be a future time between 10:00 AM to 8:00PM !!");

    }

    @Override
    public void updateAppointmentTime(Integer patientId,PatientDTO patientDTO) throws AppointmentSchedulerException {
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new AppointmentSchedulerException("No Records Found for provided Patient Id !!"));

        if (AppointmentSchedulerUtility.isWithinAllowedTime(patientDTO.getAppointmentTime())){
           patient.setAppointmentTime(patient.getAppointmentTime());
           patientRepo.save(patient);
        }else
            throw new AppointmentSchedulerException("Appointment time should be a future time between 10:00 AM to 8:00PM !!");
    }

    @Override
    public void updateAppointmentDate(Integer patientId, PatientDTO patientDTO) throws AppointmentSchedulerException {
        LocalDate today = LocalDate.now();

        if (patientDTO.getAppointmentDate().isBefore(today)){
            throw new AppointmentSchedulerException("Appointment date should be a present/future date.");
        }
        if (patientRepo.existsByPatientIdAndAppointmentDate(patientId,patientDTO.getAppointmentDate())){
            throw new AppointmentSchedulerException("Same Date is already Present, No update required !!");
        }
        Patient patient = patientRepo.findById(patientId).orElseThrow(()-> new AppointmentSchedulerException("No Records Found for provided Patient Id !!"));
        patient.setAppointmentDate(patientDTO.getAppointmentDate());
        patientRepo.save(patient);
    }

}
