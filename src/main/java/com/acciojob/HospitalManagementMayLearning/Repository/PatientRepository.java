package com.acciojob.HospitalManagementMayLearning;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class PatientRepository {
    HashMap<Integer,Patient> patientDB;

    PatientRepository(){
        patientDB=new HashMap<>();
    }

    public String addPatient(Patient patient) throws Exception{

        int key=patient.getPatientId();
        if(patientDB.containsKey(key)){
            throw new Exception("this ID Already Exists");
        }
        patientDB.put(key,patient);
        return "Patient saved to DB with Id=" + patient.getPatientId();
    }

    public ArrayList<Patient> getAllPatient(){
        ArrayList<Patient> list=new ArrayList<>();
        for(int key:patientDB.keySet()) {
            list.add(patientDB.get(key));
        }
        return list;
    }
}
