package com.ba.service;

import com.ba.entity.Patient;
import com.ba.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String tc) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByTc(tc);
        return new org.springframework.security.core.userdetails.User(patient.getTc(), patient.getPassword(), new ArrayList<>());
    }
}
