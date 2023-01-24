package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dao.IBloodBankModel;
import com.examly.springapp.model.BloodBankModel;

@RestController
public class BloodBankController {

	@Autowired
	IBloodBankModel iBloodBankModel;
	
	@GetMapping("/sample")
	public List<BloodBankModel> getAllSamples(){
		return iBloodBankModel.findAll();
	}
	
//	@GetMapping("/sample/{group}")
//	public List<BloodBankModel> getAllSamplesBygroup(@PathVariable("group") String group){
//		try {
//			return iBloodBankModel.findByBloodGroup(group);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	@GetMapping("/sample/{id}")
	public BloodBankModel getSampleById(@PathVariable("id") int id) {
		try {
			Optional<BloodBankModel>bloodBankModel= iBloodBankModel.findById(id);
			if(bloodBankModel.isEmpty()) return null;
			return bloodBankModel.get();
		} catch (Exception e) {
		return null;
		}
	}
	
	@PostMapping("/admin/addSample")
	public String addSample(@RequestBody BloodBankModel model) {
		try {
			iBloodBankModel.save(model);
			return "Sample added";
		} catch (Exception e) {
			return "Sample add operation failed";
		}
	}
	
	@PutMapping("/admin/sample/{id}")
	public String updateSample(@PathVariable("id") int id,@RequestBody BloodBankModel model) {
		try {
			Optional<BloodBankModel>bloodBankModel= iBloodBankModel.findById(id);
			if(bloodBankModel.isEmpty()) return "Update Failed";
			bloodBankModel.map(b->{
				b.setBloodBankId(model.getBloodBankId());
				b.setBloodGroup(model.getBloodGroup());
				b.setBloodPressure(model.getBloodPressure());
				b.setPhLevel(model.getPhLevel());
				b.setQuantity(model.getQuantity());
				return iBloodBankModel.save(b);
			});
			return "Sample Updated";
		} catch (Exception e) {
			 return "Update Failed";
		}
	}
	
	@DeleteMapping("/admin/sample/{id}")
	public String deleteSample(@PathVariable("id") int id) {
		try {
			iBloodBankModel.deleteById(id);
			return "Sample deleted";
		} catch (Exception e) {
			return "Sample delete operation failed";
		}
	}
}
