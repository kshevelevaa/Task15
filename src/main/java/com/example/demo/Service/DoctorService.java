package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public boolean addDoctor(Doctor doctor) {
        Doctor doctorFromDB = doctorRepository.findDoctorByPosition(doctor.getPosition());
        if (doctorFromDB == null) {
            doctorRepository.save(doctor);
            return true;
        } else
            return false;
    }

    public boolean deleteDoctor(int id) {
        Doctor doctorFromDB = doctorRepository.findDoctorById(id);
        if (doctorFromDB == null) {
            return false;
        } else {
            doctorRepository.delete(doctorFromDB);
            return true;
        }
    }


    public Doctor printDoctor(int id) {
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> printDoctors() {
        return doctorRepository.findAllBy();
    }
}
