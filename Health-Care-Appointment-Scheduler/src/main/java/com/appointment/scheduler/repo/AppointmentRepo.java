package com.appointment.scheduler.repo;

import com.appointment.scheduler.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends CrudRepository<Appointment,Integer> {
}
