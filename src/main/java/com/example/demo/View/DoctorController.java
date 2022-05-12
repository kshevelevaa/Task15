package com.example.demo.View;

import com.example.demo.Model.Doctor;
import com.example.demo.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/")
    public String print(){
        return "/";
    }

    //    http://localhost:8080/add/doctor?firstName=Ivan&lastName=Ivanov&position=202
    @GetMapping("add/doctor")
    public String addDoctor(@RequestParam(name = "firstName") String firstName,
                                  @RequestParam(name = "lastName") String lastName,
                                  @RequestParam(name = "position") Integer position) {
        System.out.println(firstName + lastName);
        boolean isCreated = doctorService.addDoctor(new Doctor(firstName, lastName, position));
        if (isCreated == true){
            return "success";
        }
        else
            return  "doctor already exists";
    }

    // http://localhost:8080/delete/doctor/1
    @GetMapping("delete/doctor/{id}")
    public List<Doctor> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return doctorService.printDoctors();
    }

    // http://localhost:8080/print/doctor/0
    @GetMapping("print/doctor/{id}")
    public Doctor printDoctor(@PathVariable(name = "id") int id) {
        return doctorService.printDoctor(id);
    }

    // http://localhost:8080/print/doctors
    @GetMapping("print/doctors")
    public List<Doctor> printDoctors() {
        return doctorService.printDoctors();
    }

}
