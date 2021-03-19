package com.example.demo.services;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.persistence.domain.CatDomain;
import com.example.demo.persistence.dtos.CatDTO;
import com.example.demo.persistence.repos.CatRepo;



@SpringBootTest
public class CatServiceUnitTest {
	
	@MockBean //@Mock
	private ModelMapper mockedMapper;
	
	@MockBean //@Mock
	private CatRepo mockedRepo;
	
	@Autowired //@InjectMocks
	private CatService service;
	
	//CRUD Tests
	@Test
	public void create() {
		//RESOURCES
		CatDomain TEST_CAT = new CatDomain(1L, "Boris", 15, 5, null);
		CatDTO TEST_DTO = new CatDTO(1L, "Boris", 15);
		
		//RULES
		Mockito.when(this.mockedRepo.save(Mockito.any(CatDomain.class))).thenReturn(TEST_CAT);
		Mockito.when(this.mockedMapper.map(TEST_CAT, CatDTO.class)).thenReturn(TEST_DTO);
		
		// ACTIONS
		CatDTO result = this.service.create(TEST_CAT);
		
		//ASSERTIONS
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(TEST_DTO);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_DTO);
		
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(CatDomain.class));
		Mockito.verify(this.mockedMapper, Mockito.times(1)).map(TEST_CAT, CatDTO.class);
		
		}

	@Test
	public void readAll() {
			
		}
	
	@Test
	public void readOne() {
		//RESOURCES
		CatDomain TEST_CAT = new CatDomain(1L, "Boris", 15, 5, null);
		CatDTO TEST_DTO = this.mockedMapper.map(TEST_CAT, CatDTO.class);
		
		//RULES
		Mockito.when(this.mockedRepo.findById(TEST_CAT.getId() )).thenReturn(Optional.of(TEST_CAT));
		
		// ACTIONS
		CatDTO result = this.service.readOne(1L);
		
		//ASSERTIONS
		Assertions.assertThat(result).isEqualTo(TEST_DTO);
		
		Mockito.verify(this.mockedRepo, Mockito.times(1)).findById(1L);
		
		}
	
	@Test
	public void update() {
		//RESOURCES
		CatDomain TEST_CAT = new CatDomain(1L, "Felix", 15, 5, null);
		CatDTO TEST_DTO = new CatDTO(1L, "Felix", 15);
				
		//RULES
		Mockito.when(this.mockedRepo.findById(TEST_CAT.getId() )).thenReturn(Optional.of(TEST_CAT));
		Mockito.when(this.mockedRepo.save(Mockito.any(CatDomain.class))).thenReturn(TEST_CAT);
		Mockito.when(this.mockedMapper.map(TEST_CAT, CatDTO.class)).thenReturn(TEST_DTO);
				
		// ACTIONS
		CatDTO result = this.service.update(1L, TEST_CAT);
				
		//ASSERTIONS
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).isEqualTo(TEST_DTO);
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_DTO);
				
				
		Mockito.verify(this.mockedRepo, Mockito.times(1)).save(Mockito.any(CatDomain.class));
		Mockito.verify(this.mockedMapper, Mockito.times(1)).map(TEST_CAT, CatDTO.class);
			
			
		}
	
	@Test
	public void delete() {
		
			
		}

}
