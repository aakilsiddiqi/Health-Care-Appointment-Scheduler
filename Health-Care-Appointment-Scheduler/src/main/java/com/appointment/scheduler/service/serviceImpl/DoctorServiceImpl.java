package com.appointment.scheduler.service.serviceImpl;

import com.appointment.scheduler.dto.DoctorDTO;
import com.appointment.scheduler.entity.Doctor;
import com.appointment.scheduler.exception.AppointmentSchedulerException;
import com.appointment.scheduler.repo.DoctorRepo;
import com.appointment.scheduler.service.DoctorService;
import com.appointment.scheduler.utility.AppointmentSchedulerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service(value = "doctorService")
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public void addDoctorDetails(DoctorDTO doctorDTO) throws AppointmentSchedulerException {

        if (AppointmentSchedulerUtility.isWithinAllowedTime(doctorDTO.getAvailableTime())) {
            Doctor doctor = new Doctor();
            doctor.setDoctorName(doctorDTO.getDoctorName());
            doctor.setSpecialization(doctorDTO.getSpecialization());
            doctor.setAvailableDate(doctorDTO.getAvailableDate());
            doctor.setAvailableTime(doctorDTO.getAvailableTime());
            doctorRepo.save(doctor);
        } else throw new AppointmentSchedulerException("Please provide available time in Between 10 AM to 8 PM !!");

    }

    @Override
    public void updateAvailableTime(Integer doctorId, String availableTime) throws AppointmentSchedulerException {
        Optional<Doctor> doctor = doctorRepo.findById(doctorId);
        Doctor doctor1 = doctor.orElseThrow(() -> new AppointmentSchedulerException("Doctor Id Not Exists for this !!!"));
        if (AppointmentSchedulerUtility.isWithinAllowedTime(availableTime)) {
            doctor1.setAvailableTime(availableTime);
            doctorRepo.save(doctor1);
        } else throw new AppointmentSchedulerException("Please provide available time in Between 10 AM to 8 PM !!");

    }

    @Override
    public List<Doctor> listAllAvailableDoctors() throws AppointmentSchedulerException {
        List<Doctor> doctorList = (List<Doctor>) doctorRepo.findAll();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        if (doctorList.isEmpty()) {
            throw new AppointmentSchedulerException("No Records Found !!!");
        }

        return doctorList.stream()
                .filter(x -> {
                    LocalDate date = x.getAvailableDate();
                    String availableTime = x.getAvailableTime();
                    try {
                        String[] parts = availableTime.split(" - ");
                        LocalTime startTime = LocalTime.parse(parts[0].trim(), formatter);

                        return date.isAfter(today) || (date.isEqual(today) && startTime.isAfter(now));
                    } catch (Exception e) {
                        // Log and skip invalid entries
                        System.err.println("Invalid time format: " + availableTime);
                        return false;
                    }

                }).toList();
    }

    @Override
    public void updateAvailableDate(Integer doctorId, DoctorDTO doctorDTO) throws AppointmentSchedulerException {
        LocalDate today = LocalDate.now();
        if (doctorDTO.getAvailableDate().isBefore(today)) {
            throw new AppointmentSchedulerException("Please enter present or future date !!");
        }
        boolean alreadyExists = doctorRepo.existsByDoctorIdAndAvailableDate(doctorId, doctorDTO.getAvailableDate());
        if (alreadyExists) {
            throw new AppointmentSchedulerException("Same Date is already Present, No update required !! ");
        }
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new AppointmentSchedulerException("Doctor Id Not Exists for this !!!"));
        doctor.setAvailableDate(doctorDTO.getAvailableDate());
        doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> getDoctorsBySpecialization(String specialization) throws AppointmentSchedulerException {
        List<Doctor> doctorList = doctorRepo.findDoctorsBySpecialization(specialization);
        if (doctorList.isEmpty()) {
            throw new AppointmentSchedulerException("No Doctors Found for this Specialization !!! ");
        }
        return doctorList.stream().sorted(Comparator.comparing(Doctor::getAvailableDate).reversed()).toList();

    }
}
