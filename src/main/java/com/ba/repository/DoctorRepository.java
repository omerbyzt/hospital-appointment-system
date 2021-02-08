package com.ba.repository;

import com.ba.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
