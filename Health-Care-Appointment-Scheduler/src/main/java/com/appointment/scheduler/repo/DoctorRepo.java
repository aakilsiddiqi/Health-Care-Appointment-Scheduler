package com.appointment.scheduler.repo;

import com.appointment.scheduler.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor,Integer> {

    boolean existsByDoctorIdAndAvailableDate(Integer doctorId, LocalDate availableDate);

    List<Doctor> findDoctorsBySpecialization(String specialization);
}
