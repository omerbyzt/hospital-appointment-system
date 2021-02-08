package com.ba.controller;

import com.ba.dto.DoctorDTO;
import com.ba.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getDoctorList(){
        return ResponseEntity.ok(doctorService.getDoctorList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }
}
