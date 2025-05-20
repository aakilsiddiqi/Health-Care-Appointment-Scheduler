package com.appointment.scheduler.repo;

import com.appointment.scheduler.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment,Integer> {

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(Integer doctorId, LocalDate appointmentDate,String appointmentTime);
}
