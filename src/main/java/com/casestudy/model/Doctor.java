package com.casestudy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor extends EntityItem{
	
	private String name;
	private String hospitalName;
	
	@ManyToMany(fetch= FetchType.EAGER, mappedBy="doctors")
	private List<Patient> patients = new ArrayList<Patient>();
	
	protected Doctor() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@JsonIgnore
	public List<Patient> getPatients() {
		return patients;
	}

	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", hospitalName=" + hospitalName + ", patients=" + patients + "]";
	}	
}
