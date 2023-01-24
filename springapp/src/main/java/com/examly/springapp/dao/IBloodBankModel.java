package com.examly.springapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.BloodBankModel;

public interface IBloodBankModel extends JpaRepository<BloodBankModel, Integer> {

	public List<BloodBankModel> findByBloodGroup(String group);
}
