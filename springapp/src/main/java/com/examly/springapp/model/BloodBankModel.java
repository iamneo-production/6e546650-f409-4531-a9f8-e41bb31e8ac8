package com.examly.springapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodBankModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id",unique = true,nullable = false)
	private int bloodBankId;
	
	private String bloodGroup;
	private String bloodPressure; 
	private String phLevel;
	private int quantity;
	public int getBloodBankId() {
		return bloodBankId;
	}
	public void setBloodBankId(int bloodBankId) {
		this.bloodBankId = bloodBankId;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getPhLevel() {
		return phLevel;
	}
	public void setPhLevel(String phLevel) {
		this.phLevel = phLevel;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
