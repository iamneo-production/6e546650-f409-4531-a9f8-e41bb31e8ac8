package com.examly.springapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.BloodDonarModel;

public interface IBloodDonarModel extends JpaRepository<BloodDonarModel, Integer>{

	public List<BloodDonarModel> findByBloodGroup(String group);
}
