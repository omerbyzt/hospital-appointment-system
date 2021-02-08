package com.ba.service;

import com.ba.dto.PatientDTO;
import com.ba.entity.Patient;
import com.ba.mapper.PatientMapper;
import com.ba.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public List<PatientDTO> getPatientList(){
        List<Patient> patientList = patientRepository.findAll();
        return patientMapper.toDTOList(patientList);
    }

    public PatientDTO getPatient(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        return patientMapper.toDTO(patient.get());
    }
}
