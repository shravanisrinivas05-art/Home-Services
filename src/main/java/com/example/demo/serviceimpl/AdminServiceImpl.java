package com.example.demo.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public boolean loginValidate(Admin admin) {
		/*
		 * Optional<Admin> adminObj = adminRepository.findById(admin.getUserName()); if
		 * (adminObj.isPresent()) { Admin ob = (Admin)adminObj.get(); String
		 * DBpwd=ob.getPassword(); if (DBpwd.equals(admin.getPassword())) { return true;
		 * }else { return false; } } else {
		 * 
		 * return false; }
		 */

		Admin admin1 = adminRepository.findByUserNameAndPassword(admin.getUserName(), admin.getPassword());
		System.out.println("Admin=" + admin1);
		if (admin1 == null)
			return false;
		else
			return true;
	}

}