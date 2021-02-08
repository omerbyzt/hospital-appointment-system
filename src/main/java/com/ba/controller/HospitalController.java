package com.ba.controller;

import com.ba.dto.DoctorDTO;
import com.ba.dto.HospitalDTO;
import com.ba.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<List<HospitalDTO>> getHospitalList(){
        return ResponseEntity.ok(hospitalService.getHospitalList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalDTO> getHospital(@PathVariable Long id){
        return ResponseEntity.ok(hospitalService.getHospital(id));
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<List<DoctorDTO>> getDoctorListByHospitalId(@PathVariable Long id){
        return ResponseEntity.ok(hospitalService.getDoctorListByHospitalId(id));
    }
}
