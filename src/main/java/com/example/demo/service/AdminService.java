package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;

@Service
public interface AdminService {
	boolean loginValidate(Admin admin);
	
}