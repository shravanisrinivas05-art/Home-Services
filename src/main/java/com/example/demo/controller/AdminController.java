package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping(value = "/adminLogin")
	public ResponseEntity<Object> adminLogin(@RequestBody Admin admin) {
		boolean flag = adminService.loginValidate(admin);
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
}