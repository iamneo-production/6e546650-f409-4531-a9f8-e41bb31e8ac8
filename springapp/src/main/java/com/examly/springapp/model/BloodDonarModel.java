package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodDonarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id",unique = true,nullable = false)
	private int id;
	
	private String donarEmail;
	
	private String bloodGroup;
	
	private String phLevel; 
	
	private String bloodPressure;
	 
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonarEmail() {
		return donarEmail;
	}

	public void setDonarEmail(String donarEmail) {
		this.donarEmail = donarEmail;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	

	public String getPhLevel() {
		return phLevel;
	}

	public void setPhLevel(String phLevel) {
		this.phLevel = phLevel;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
