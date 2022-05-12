package com.example.demo.repository;

import com.example.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    Doctor findDoctorById(Integer id);

    List<Doctor> findAllBy();

    Doctor findDoctorByPosition(int position);
}
