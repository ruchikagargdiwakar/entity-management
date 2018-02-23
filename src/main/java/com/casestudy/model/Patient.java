package com.casestudy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Patient extends EntityItem{
	
	private String address;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(name="PATIENT_DOCTOR",
	joinColumns = @JoinColumn(name="PATIENT_ID"),
	inverseJoinColumns = @JoinColumn(name="DOCTOR_ID"))
	private List<Doctor> doctors = new ArrayList<Doctor>();
	
	protected Patient() {}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void addDoctor(Doctor doctor) {
		this.doctors.add(doctor);
	}

	@Override
	public String toString() {
		return "Patient [address=" + address + ", doctors=" + doctors + "]";
	}
}
