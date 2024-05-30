package com.acciojob.HospitalManagementMayLearning.Controller;

import com.acciojob.HospitalManagementMayLearning.Models.Patient;
import com.acciojob.HospitalManagementMayLearning.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("addPatient")
    public String addPatient(@RequestBody Patient patient){
        try {
            String response = patientService.addPatient(patient);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("getAllPatient")
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
    @GetMapping("get_Oldest_patient")
    public String getOldestPatient(){

        int maxAge=Integer.MIN_VALUE;
        Patient ansPatient=null;
        try {
            List<Patient> list=patientService.getAllPatient();
            for(Patient p:list){
                if(p.getAge()>maxAge){
                    ansPatient=p;
                }
            }
            return ansPatient.getName();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @GetMapping("Get-All-Patient-Name-StratsWith-A")
    public List<Patient> getAllPatietsNameStarsWithA(){
        return patientService.getAllPatientWhoseNameStartsWIthA();
    }

    //using RequestParam
    @GetMapping("Get-patient-name-by-Id")
    public String patientNameById(@RequestParam("patientId")Integer patientId){
        return patientService.getPatientNameById(patientId);
    }

    //using PathVariable
    @GetMapping("get-patient-by-id/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    //using RequestMapping
    @GetMapping("Get-patient-by-id-age")
    public Patient patientNameByIdAndAName(@RequestParam("patientId")Integer patientId,
                                          @RequestParam("age")Integer age){
        return patientService.getPatientByIdAndAge(patientId,age);
    }

    //@PathVariable
    @GetMapping("Get-patient-address-by-id-age/{patientId}/{age}")
    public String patientAddressByIdAndAName(@PathVariable  Integer patientId,
                                           @PathVariable  Integer age){
        return patientService.getPatientAddressByIdAndAge(patientId,age);
    }

    //Put with @RequestParam
    @PutMapping("change-patient-Name-by-id")
    public String UpdateName(@RequestParam("patientId")Integer patientId,
                             @RequestParam("name") String name){
        return patientService.updatePatientName(patientId,name);
    }

    //delete mapping with @RequestParam
    @DeleteMapping("delete-by-id")
    public ResponseEntity deleteByid(@RequestParam("id")Integer id){
        String response=patientService.deleteById(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
