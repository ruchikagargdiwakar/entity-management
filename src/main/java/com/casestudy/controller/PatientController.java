package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Doctor;
import com.casestudy.model.EntityItem;
import com.casestudy.model.Patient;
import com.casestudy.service.EntityService;

@RestController
public class PatientController {
	
	@Autowired
	EntityService entityService;
	
	/**
	 * create patient entity
	 * @param patient
	 */
	@PostMapping("/entities/patient")
	public void savePatientEntity(@RequestBody Patient patient){
		
		entityService.saveEntityItem(patient);
		List<Doctor> doctors = patient.getDoctors();
		for(Doctor doctor:doctors) {
			System.out.println("Inside doctor loop");
			entityService.saveEntityItem(doctor);
		}
	}
	
	/**
	 * update patient
	 * @param id
	 * @param patient
	 * @return
	 */
	@PutMapping("/entities/patient/{id}")
	public ResponseEntity<Patient> updatePatientEntity(@PathVariable Long id, @RequestBody Patient patient){
		
		Patient patientDetail = (Patient) entityService.findEntityItemById(id);
		if(patientDetail == null) {
			return ResponseEntity.notFound().build();
		}
		patientDetail.setName(patient.getName());
		patientDetail.setDescription(patient.getDescription());
		List<Doctor> doctors = patient.getDoctors();
		for(Doctor doctor:doctors) {
			patientDetail.addDoctor(doctor);
		}
		patientDetail.setAddress(patient.getAddress());
		entityService.updateEntityItem(patientDetail);
		
		return ResponseEntity.ok(patientDetail);
	}
	
	

}
