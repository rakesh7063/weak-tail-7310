package com.desidukaan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidukaan.model.Admin;
import com.desidukaan.model.LoginDTO;
import com.desidukaan.service.AdminService;
import com.desidukaan.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService logser;
	
	@Autowired
	private AdminService adminser;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginhandle(@RequestBody LoginDTO dto){
		String result = logser.login(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutHandle(@RequestParam (required = false) String key) {
	return new ResponseEntity<String>(logser.logout(key),HttpStatus.OK);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdminHandle(@Valid @RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminser.registerAdmin(admin),HttpStatus.CREATED);
	}
}
