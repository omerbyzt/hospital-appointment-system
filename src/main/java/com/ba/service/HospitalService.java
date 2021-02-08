package com.ba.service;

import com.ba.dto.DoctorDTO;
import com.ba.dto.HospitalDTO;
import com.ba.entity.Hospital;
import com.ba.mapper.DoctorMapper;
import com.ba.mapper.HospitalMapper;
import com.ba.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalMapper hospitalMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    public List<HospitalDTO> getHospitalList(){
        List<Hospital> hospitalList = hospitalRepository.findAll();
        return hospitalMapper.toDTOList(hospitalList);
    }

    public HospitalDTO getHospital(Long id){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return hospitalMapper.toDTO(hospital.get());
    }

    public List<DoctorDTO> getDoctorListByHospitalId(Long id){
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        return doctorMapper.toDTOList(hospital.get().getDoctors());
    }
}
