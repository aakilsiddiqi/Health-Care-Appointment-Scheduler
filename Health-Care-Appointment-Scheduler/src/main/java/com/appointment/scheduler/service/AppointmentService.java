package com.appointment.scheduler.service;

import com.appointment.scheduler.dto.AppointmentDTO;
import com.appointment.scheduler.entity.Status;
import com.appointment.scheduler.exception.AppointmentSchedulerException;

import java.time.LocalDate;

public interface AppointmentService {

   /* Acceptance Criteria:

    Patients should be able to select a doctor and choose a slot based on availability
    Once an appointment with a doctor is confirmed, no other patient should be able to
    schedule an appointment with the same doctor during the same time slot.
    This ensures proper scheduling and avoids conflicts
    If Appointment Booking is successful, then the status should be CONFIRMED
    Display success messages upon booking and error messages when applicable

    */

    public Status bookAppointment(AppointmentDTO appointmentDTO) throws AppointmentSchedulerException;

}
