package com.acciojob.HospitalManagementMayLearning.Repository;

import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PatientRepository {
    HashMap<Integer, Patient> patientDB;

    public PatientRepository(){
        patientDB=new HashMap<>();
    }

    public String addPatient(Patient patient) throws Exception{

        int key=patient.getPatientId();
        if(patientDB.containsKey(key)){
            throw new Exception("this patient ID Already Exists");
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
    public String updatePatientName(Integer id,String name){
        if(patientDB.size()==0){
            return "Empty Database";
        }
        if(patientDB.containsKey(id)){
            Patient p=patientDB.get(id);
            String oldName=p.getName();
            p.setName(name);
            patientDB.put(id,p);
            return oldName+" changed to "+p.getName();
        }
        else{
            return "Some error occurred!";
        }
    }

    public String deleteById(Integer id){
        if(patientDB.size()==0)
            return "Database Empity";
        if(patientDB.containsKey(id)){
            patientDB.remove(id);
            return "patient removed!";
        }
        else{
            return "Invalid id!";
        }
    }
}
