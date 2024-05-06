package com.acciojob.HospitalManagementMayLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("addPatient")
    public String addPatient(@RequestBody Patient patient){
        String response=patientService.addPatient(patient);
        return response;
    }

    @GetMapping("getALlPatient")
    public ArrayList<Patient> getAllPatient(){
        ArrayList<Patient> list=new ArrayList<>();
        try {
             list = patientService.getAllPatient();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
