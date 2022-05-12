package com.example.demo.Service;

import com.example.demo.Model.Patient;
import com.example.demo.Model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public boolean addPatient(Patient patient) {
        Patient patientFromDB = patientRepository.findPatientByAddress(patient.getAddress());
        if (patientFromDB == null) {
            patientRepository.save(patient);
            return true;
        } else
            return false;
    }

    public boolean deletePatient(int id) {
        Patient patientFromDB = patientRepository.findPatientById(id);
        if (patientFromDB == null) {
            return false;
        } else {
            patientRepository.delete(patientFromDB);
            return true;
        }
    }


    public Patient printPatient(int id) {
        return patientRepository.findPatientById(id);
    }

    public List<Patient> printPatients() {
        return patientRepository.findAllBy();
    }
}
