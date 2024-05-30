package com.acciojob.HospitalManagementMayLearning.Controller;

import com.acciojob.HospitalManagementMayLearning.Models.Doctor;
import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import com.acciojob.HospitalManagementMayLearning.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("doctor")

public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            String response = doctorService.addDoctor(doctor);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getAllDoctor")
    public ArrayList<Doctor> getAllDoctor(){
        ArrayList<Doctor> list=new ArrayList<>();
        try {
            list = doctorService.getAllDoctor();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

}
