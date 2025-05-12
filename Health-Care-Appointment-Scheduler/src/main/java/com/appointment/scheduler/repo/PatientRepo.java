package com.appointment.scheduler.repo;

import com.appointment.scheduler.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends CrudRepository<Patient,Integer> {
}
