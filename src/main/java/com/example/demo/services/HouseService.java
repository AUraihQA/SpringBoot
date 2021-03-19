package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.HouseDomain;
import com.example.demo.persistence.dtos.HouseDTO;
import com.example.demo.persistence.repos.HouseRepo;
import com.example.demo.utils.MyBeanUtils;

@Service
public class HouseService {
	private HouseRepo repo;
	private ModelMapper mapper;

	@Autowired
	public HouseService(HouseRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private HouseDTO mapToDTO(HouseDomain model) {
		return this.mapper.map(model, HouseDTO.class);
	}

	// POST
	public HouseDTO create(HouseDomain house) {
		return this.mapToDTO(this.repo.save(house));
	}

	// GET
	public List<HouseDTO> readAll() {
		List<HouseDomain> dbList = this.repo.findAll();
		List<HouseDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;

	}

	public HouseDTO readOne(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// PUT
	public HouseDTO update(Long id, HouseDomain newDetails) {
		
		HouseDomain updatedHouse = this.repo.findById(id).orElseThrow();
		MyBeanUtils.mergeNotNull(newDetails, updatedHouse);

		return this.mapToDTO(this.repo.save(updatedHouse));

	}

	// DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}


}
