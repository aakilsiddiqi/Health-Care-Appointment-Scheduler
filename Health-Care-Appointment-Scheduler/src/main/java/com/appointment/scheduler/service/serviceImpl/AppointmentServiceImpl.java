package com.appointment.scheduler.service.serviceImpl;

import com.appointment.scheduler.dto.AppointmentDTO;
import com.appointment.scheduler.entity.Appointment;
import com.appointment.scheduler.entity.Status;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.repo.AppointmentRepo;
import com.appointment.scheduler.repo.DoctorRepo;
import com.appointment.scheduler.repo.PatientRepo;
import com.appointment.scheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DoctorRepo doctorRepo;


    @Override
    public Status bookAppointment(AppointmentDTO appointmentDTO) throws AppointmentSchedulerException {

        if (!doctorRepo.existsById(appointmentDTO.getDoctorId())) {
            throw new AppointmentSchedulerException("Doctor ID is not present in the System !!");
        }
        if (!patientRepo.existsById(appointmentDTO.getPatientId())) {
            throw new AppointmentSchedulerException("Patient ID is not present in the System !!");
        }

        boolean exists = appointmentRepo.existsByDoctorIdAndAppointmentDateAndAppointmentTime(appointmentDTO.getDoctorId(), appointmentDTO.getAppointmentDate(), appointmentDTO.getAppointmentTime());

        Appointment appointment = new Appointment();
        if (exists) {
            appointment.setStatus(Status.NOT_CONFIRMED);
            appointmentRepo.save(appointment);
            throw new AppointmentSchedulerException("Appointment not Available !!");
        }else{
            appointment.setDoctorId(appointment.getDoctorId());
            appointment.setPatientId(appointmentDTO.getPatientId());
            appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
            appointment.setAppointmentTime(appointment.getAppointmentTime());
            appointment.setStatus(Status.CONFIRMED);
            appointmentRepo.save(appointment);
        }
        return appointment.getStatus();
    }
}
