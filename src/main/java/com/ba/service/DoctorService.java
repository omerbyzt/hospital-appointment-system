package com.ba.service;

import com.ba.dto.DoctorDTO;
import com.ba.entity.Doctor;
import com.ba.mapper.DoctorMapper;
import com.ba.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    public List<DoctorDTO> getDoctorList(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorMapper.toDTOList(doctorList);
    }

    public DoctorDTO getDoctor(Long id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctorMapper.toDTO(doctor.get());
    }
}
