package com.ba.repository;

import com.ba.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    SELECT * FROM APPOINTMENT where doctor_id = 1 and date = 'Feb 10 2021'

    @Query("SELECT u.hour FROM Appointment u WHERE u.doctor.id = :id and u.date = :date")
    List<Long> findAppointmentsByDoctor_IdAndDateEquals(Long id, String date);

    @Query("SELECT u FROM Appointment u WHERE u.patient.id = :id")
    List<Appointment> getAppointmentByPatientId(Long id);

    @Query("SELECT u FROM Appointment u WHERE u.patient.tc = :tc")
    List<Appointment> getAppointmentByPatientTc(String tc);
}
