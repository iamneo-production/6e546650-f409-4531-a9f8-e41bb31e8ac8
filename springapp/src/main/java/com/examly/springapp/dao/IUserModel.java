package com.examly.springapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.UserModel;

public interface IUserModel extends JpaRepository<UserModel, String>{

}
