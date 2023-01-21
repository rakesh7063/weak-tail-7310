package com.desidukaan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.desidukaan.model.Address;
import com.desidukaan.service.AddressService;

import jakarta.validation.Valid;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addServ;
	
	@PostMapping("/address")
	public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address add) {
		Address addr = addServ.addAddress(add);
		return new ResponseEntity<Address>(addr, HttpStatus.OK);
	}
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddressHandler(@RequestBody Address add) {
		Address addr = addServ.updateAddress(add);
		return new ResponseEntity<Address>(addr, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/address/{addressId}")
    public ResponseEntity<Address> deleteAddressHandler(@PathVariable("addressId") Integer addId) {

        Address addr = addServ.removeAddress(addId);

        return new ResponseEntity<Address>(addr, HttpStatus.OK);

    }
    @GetMapping("/getalladdress")
    public ResponseEntity<List<Address>> getAllAddressHandler() {

        List<Address> allAddress = addServ.viewAllAddress();

        return new ResponseEntity<List<Address>>(allAddress, HttpStatus.OK);

    }

    @GetMapping("/getaddress/{addressId}")
    public ResponseEntity<Address> getAddressHandler(@PathVariable("addressId") Integer addressId) {

        Address existingAddress = addServ.viewAddress(addressId);

        return new ResponseEntity<Address>(existingAddress, HttpStatus.OK);

    }

}
