package com.appointment.scheduler.repo;

import com.appointment.scheduler.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepo extends CrudRepository<Patient,Integer> {

    boolean existsByPatientIdAndAppointmentDate(Integer patientId, LocalDate appointmentDate);
}
