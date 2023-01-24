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

import com.examly.springapp.dao.IBloodDonarModel;
import com.examly.springapp.model.BloodDonarModel;

@RestController
public class BloodDonarController {

	@Autowired
	IBloodDonarModel iBloodDonarModel;
	
	@GetMapping("/donar")
	public List<BloodDonarModel> getAllDonar(){
		return iBloodDonarModel.findAll();
	}
	
//	@GetMapping("/donar/{group}")
//	public List<BloodDonarModel> getAllDonarBygroup(@PathVariable("group") String group){
//		try {
//		 return	iBloodDonarModel.findByBloodGroup(group);
//			
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
	@GetMapping("/donar/{id}")
	public BloodDonarModel getDonarById(@PathVariable("id") int id) {
		try {
			Optional<BloodDonarModel> bloodDonarModel= iBloodDonarModel.findById(id);
			if(bloodDonarModel.isEmpty()) return null;
			return bloodDonarModel.get();
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/admin/addDonar")
	public String addDonar(@RequestBody BloodDonarModel model) {
		try {
			iBloodDonarModel.save(model);
			return "Donar added";
		} catch (Exception e) {
			return "Donar add operation failed";
		}
	}
	
	@PutMapping("/admin/donar/{id}")
	public String updateDonar(@PathVariable("id") int id,@RequestBody BloodDonarModel model) {
		try {
			Optional<BloodDonarModel> bloodDonarModel = iBloodDonarModel.findById(id);
			if(bloodDonarModel.isEmpty()) return "Donar updation failed";
			bloodDonarModel.map(d->{
				d.setId(model.getId());
				d.setBloodGroup(model.getBloodGroup());
				d.setBloodPressure(model.getBloodPressure());
				d.setDonarEmail(model.getDonarEmail());
				d.setPhLevel(model.getPhLevel());
				d.setActive(model.isActive());
				return iBloodDonarModel.save(d);
			});
			return "Donar Updated";
		} catch (Exception e) {
			return "Donar updation failed";
		}
	}
	
	@DeleteMapping("/admin/donar/{id}")
	public String deleteDonar(@PathVariable("id") int id) {
		try {
			iBloodDonarModel.deleteById(id);
			return "Donar Removed";
		} catch (Exception e) {
			return "Donar deletion failed";
		}
	}
}
