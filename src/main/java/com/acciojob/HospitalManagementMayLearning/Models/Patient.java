package com.acciojob.HospitalManagementMayLearning.Models;

public class Patient {
   private Integer patientId;
   private Integer age;
   private String name;
   private String address;
   private String phoneNo;

   public Patient(){

   }
    public Patient(Integer patientId, Integer age, String name, String address, String phoneNo) {
        this.patientId = patientId;
        this.age = age;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
