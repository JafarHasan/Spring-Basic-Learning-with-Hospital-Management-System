package com.acciojob.HospitalManagementMayLearning.Service;

import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import com.acciojob.HospitalManagementMayLearning.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public String addPatient(Patient patient) throws Exception{
        return patientRepository.addPatient(patient);
    }

    public ArrayList<Patient> getAllPatient() throws Exception{

        ArrayList<Patient> list= patientRepository.getAllPatient();
        if(list.isEmpty()){
            throw new Exception("Database Empty!");
        }
        return list;
    }
    public ArrayList<Patient> getAllPatientWhoseNameStartsWIthA(){

        ArrayList<Patient> patientsList=patientRepository.getAllPatient();
        ArrayList<Patient> list=new ArrayList<>();
        for(Patient patient:patientsList){
            if((patient.getName().charAt(0)=='A')||(patient.getName().charAt(0)=='a')){
                list.add(patient);
            }
        }
        return list;
    }
    public String getPatientNameById(Integer patientId){
        ArrayList<Patient> patientsList=patientRepository.getAllPatient();
        for(Patient p:patientsList){
            if(p.getPatientId()==patientId){
                return p.getName();
            }
        }
        return  "Invalid ID";
    }

    public Patient getPatientById(Integer patientId){
        ArrayList<Patient> patientsList=patientRepository.getAllPatient();
        for(Patient p:patientsList){
            if(p.getPatientId()==patientId){
                return p;
            }
        }
        return null;//if id is invalid
    }

    public Patient getPatientByIdAndAge(Integer id,Integer age){
        List<Patient> patientList=patientRepository.getAllPatient();
        for(Patient p:patientList){
            if(p.getPatientId()==id && p.getAge()==age){
                return p;
            }
        }
        return null;
    }

    public String getPatientAddressByIdAndAge(Integer id,Integer age){
        List<Patient> patientList=patientRepository.getAllPatient();
        for(Patient p:patientList){
            if(p.getPatientId()==id && p.getAge()==age){
                return p.getAddress();
            }
        }
        return "not found!";
    }

    public String updatePatientName(Integer patientId,String name){
       return patientRepository.updatePatientName(patientId,name);
    }

    public String deleteById(Integer id){
        return patientRepository.deleteById(id);
    }

}
