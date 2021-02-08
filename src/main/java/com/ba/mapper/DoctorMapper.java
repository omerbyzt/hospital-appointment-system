package com.ba.mapper;

import com.ba.dto.DoctorDTO;
import com.ba.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HospitalMapper.class})
public interface DoctorMapper {
    Doctor toEntity(DoctorDTO doctorDTO);
    DoctorDTO toDTO(Doctor doctor);
    List<Doctor> toEntityList(List<DoctorDTO> doctorDTOList);
    List<DoctorDTO> toDTOList(List<Doctor> doctorList);
}
