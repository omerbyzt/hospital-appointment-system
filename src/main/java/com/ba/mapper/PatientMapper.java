package com.ba.mapper;

import com.ba.dto.PatientDTO;
import com.ba.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toDTO(Patient patient);
    List<Patient> toEntityList(List<PatientDTO> patientDTOList) ;
    List<PatientDTO> toDTOList(List<Patient> patientList);
}
