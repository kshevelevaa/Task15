package com.example.demo.View;

import com.example.demo.Model.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    //    http://localhost:8080/add/patient?firstName=Ivan&lastName=Ivanov&address=moscow
    @GetMapping("add/patient")
    public String addPatient(@RequestParam(name = "firstName") String firstName,
                             @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "address") String address) {
        System.out.println(firstName + lastName);
        boolean isCreated = patientService.addPatient(new Patient(firstName, lastName, address));
        if (isCreated == true) {
            return "success";
        } else
            return "patient already exists";
    }

    // http://localhost:8080/delete/patient/0
    @GetMapping("delete/patient/{id}")
    public List<Patient> deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return patientService.printPatients();
    }

    // http://localhost:8080/print/patient/0
    @GetMapping("print/patient/{id}")
    public Patient printPatient(@PathVariable(name = "id") int id) {
        return patientService.printPatient(id);
    }

    // http://localhost:8080/print/patients
    @GetMapping("print/patients")
    public List<Patient> printPatients() {
        return patientService.printPatients();
    }

}
