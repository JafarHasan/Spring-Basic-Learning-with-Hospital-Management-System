package com.acciojob.HospitalManagementMayLearning.Service;

import com.acciojob.HospitalManagementMayLearning.Controller.DoctorController;
import com.acciojob.HospitalManagementMayLearning.Models.Doctor;
import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import com.acciojob.HospitalManagementMayLearning.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) throws Exception{
        return doctorRepository.addDoctor(doctor);
    }

    public ArrayList<Doctor> getAllDoctor() throws Exception{

        ArrayList<Doctor> list= doctorRepository.getAllDoctor();
        if(list.isEmpty()){
            throw new Exception("Database Empty!");
        }
        return list;
    }
}
