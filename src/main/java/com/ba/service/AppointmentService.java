package com.ba.service;

import com.ba.entity.Appointment;
import com.ba.entity.Patient;
import com.ba.repository.AppointmentRepository;
import com.ba.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Long> getAppointments(Long id, String date){
        List<Long> result = appointmentRepository.findAppointmentsByDoctor_IdAndDateEquals(id,date);
        return result;
    }

    public Appointment addAppointment(Appointment appointment){
        Patient patient = patientRepository.findByTc(appointment.getPatient().getTc());
        appointment.setPatient(patient);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        appointment.setId(savedAppointment.getId());
        return appointment;
    }

    public List<Appointment> getAppointmentByPatientId(Long id) {
        return appointmentRepository.getAppointmentByPatientId(id);
    }

    public List<Appointment> getAppointmentByPatientTc(String tc){
        return appointmentRepository.getAppointmentByPatientTc(tc);
    }

    public Boolean deleteAppointment(Long id) throws Exception {
        try{
            Optional<Appointment> app = appointmentRepository.findById(id);
            app.get().setStatus(1L);
            appointmentRepository.save(app.get());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void checkAppointmentsTime(){
        List<Appointment> allAppointment = appointmentRepository.findAll();
//        Wed Feb 10 20:37:20 EET 2021
//        Feb 16 2021 8
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd yyyy HH", Locale.ENGLISH);

        Date currentDate = new Date();

        allAppointment.forEach(appointment -> {
            try {
                Date appointmentDate = dateFormatter.parse(appointment.getDate() + " " + appointment.getHour());
                if(appointment.getStatus() == 0 && appointmentDate.before(currentDate)){
                    appointment.setStatus(2L);
                    appointmentRepository.save(appointment);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
