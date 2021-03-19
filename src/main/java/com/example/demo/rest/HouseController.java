package com.example.demo.rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.domain.HouseDomain;
import com.example.demo.persistence.dtos.HouseDTO;
import com.example.demo.services.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {
	private HouseService service;
	
	@Autowired
	public HouseController(HouseService service) {
		super();
		this.service = service;
	}

	
	//POST
	@PostMapping("/create")
	public ResponseEntity<HouseDTO> create(@RequestBody HouseDomain house) {
		return new ResponseEntity<HouseDTO> (this.service.create(house), HttpStatus.CREATED);
	}
	
	//GET
	@GetMapping("/getHouse")
	public ResponseEntity<List<HouseDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<HouseDTO> readOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}
	
	
	//PUT
	@PutMapping("/update/{id}")
	public ResponseEntity <HouseDTO> update(@PathVariable("id") Long id, @RequestBody HouseDomain house) {
		return new ResponseEntity<HouseDTO>(this.service.update(id, house), HttpStatus.ACCEPTED);
	}
	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable ("id") Long id) {
		return this.service.delete(id) ? 
				new ResponseEntity<>(HttpStatus.NO_CONTENT):
				new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
