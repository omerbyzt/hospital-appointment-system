package com.ba.service;

import com.ba.entity.Appointment;
import com.ba.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Long> getAppointments(Long id, String date){
        List<Long> result = appointmentRepository.findAppointmentsByDoctor_IdAndDateEquals(id,date);
        return result;
    }

    public Appointment addAppointment(Appointment appointment){
        Appointment savedAppointment = appointmentRepository.save(appointment);
        appointment.setId(savedAppointment.getId());
        return appointment;
    }

    public List<Appointment> getAppointmentByPatientId(Long id) {
        return appointmentRepository.getAppointmentByPatientId(id);
    }
}
