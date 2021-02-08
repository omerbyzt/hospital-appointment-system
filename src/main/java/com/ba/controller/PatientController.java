package com.ba.controller;

import com.ba.dto.PatientDTO;
import com.ba.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getPatientList(){
        return ResponseEntity.ok(patientService.getPatientList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatient(id));
    }
}
