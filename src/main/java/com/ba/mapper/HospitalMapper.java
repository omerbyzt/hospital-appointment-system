package com.ba.mapper;

import com.ba.dto.HospitalDTO;
import com.ba.entity.Hospital;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface HospitalMapper {
    @Mapping(ignore = true, source = "doctors", target = "doctors")
    Hospital toEntity(HospitalDTO hospitalDTO);
    @Mapping(ignore = true, source = "doctors", target = "doctors")
    HospitalDTO toDTO(Hospital hospital);

    List<Hospital> toEntityList(List<HospitalDTO> hospitalDTOList);
    List<HospitalDTO> toDTOList(List<Hospital> hospitalList);
}
