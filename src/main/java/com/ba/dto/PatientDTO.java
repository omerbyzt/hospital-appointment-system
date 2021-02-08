package com.ba.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private Long tc;
    private String name;
    private String surname;
    private Long age;
    private String gender;
}
