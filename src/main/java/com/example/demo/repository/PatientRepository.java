package com.example.demo.repository;

import com.example.demo.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findPatientById(Integer id);

    List<Patient> findAllBy();

    Patient findPatientByAddress(String address);
}
