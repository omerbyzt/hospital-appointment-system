package com.ba.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorAppointment{
    private String day;
    private List<Integer> hours;
}
