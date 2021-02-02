package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.domain.CatDomain;
import com.example.demo.persistence.dtos.CatDTO;
import com.example.demo.persistence.repos.CatRepo;

@Service
public class CatService {

	private CatRepo repo;
	private ModelMapper mapper;

	@Autowired
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}

	// POST
	public CatDTO create(CatDomain cat) {
		return this.mapToDTO(this.repo.save(cat));
	}

	// GET
	public List<CatDTO> readAll() {
		List<CatDomain> dbList = this.repo.findAll();
		List<CatDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;

	}

	public CatDTO readOne(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());

	}

	// PUT
	public CatDTO update(Long id, CatDomain newDetails) {
		this.repo.findById(id).orElseThrow();

		// cat target
		newDetails.setId(id);
		return this.mapToDTO(this.repo.save(newDetails));

	}

	// DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}
