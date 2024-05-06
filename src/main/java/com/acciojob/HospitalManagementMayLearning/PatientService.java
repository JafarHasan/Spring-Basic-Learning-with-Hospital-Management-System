package com.acciojob.HospitalManagementMayLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public String addPatient(Patient patient){
        return patientRepository.addPatient(patient);
    }

    public ArrayList<Patient> getAllPatient() throws Exception{

        ArrayList<Patient> list= patientRepository.getAllPatient();
        if(list.isEmpty()){
            throw new Exception("Database Empty!");
        }
        return list;
    }

}
