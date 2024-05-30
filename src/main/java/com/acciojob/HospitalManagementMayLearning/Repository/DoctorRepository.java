package com.acciojob.HospitalManagementMayLearning.Repository;

import com.acciojob.HospitalManagementMayLearning.Models.Doctor;
import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class DoctorRepository {
    HashMap<Integer, Doctor> doctorDB;

    DoctorRepository(){
        doctorDB=new HashMap<>();
    }

    public String addDoctor(Doctor doctor) throws Exception{

        int key=doctor.getDoctorId();
        if(doctorDB.containsKey(key)){
            throw new Exception("this doctor ID Already Exists");
        }
        doctorDB.put(key,doctor);
        return "Doctor saved to DB with Id=" + doctor.getDoctorId();
    }

    public ArrayList<Doctor> getAllDoctor(){
        ArrayList<Doctor> list=new ArrayList<>();
        for(int key:doctorDB.keySet()) {
            list.add(doctorDB.get(key));
        }
        return list;
    }

}
