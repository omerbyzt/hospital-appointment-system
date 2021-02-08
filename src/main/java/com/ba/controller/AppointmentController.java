package com.ba.controller;

import com.ba.dto.AppointmentDTO;
import com.ba.entity.Appointment;
import com.ba.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<List<Long>> getAppointmets(@RequestBody AppointmentDTO appointment){
        return ResponseEntity.ok(appointmentService.getAppointments(appointment.getId(), appointment.getDate()));
    }

    @PostMapping("/add")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        return ResponseEntity.ok(appointmentService.addAppointment(appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentByPatientId(@PathVariable Long id){
        return ResponseEntity.ok(appointmentService.getAppointmentByPatientId(id));
    }
}
