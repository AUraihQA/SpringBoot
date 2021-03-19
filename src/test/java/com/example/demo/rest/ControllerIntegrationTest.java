package com.example.demo.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.persistence.domain.CatDomain;
import com.example.demo.persistence.dtos.CatDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql", "classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ControllerIntegrationTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private CatDTO mapToDTO(CatDomain model) {
		return this.mapper.map(model, CatDTO.class);
	}
	
	private final int ID = 1;
	
	//READ
	@Test
	public void readAll() {
		
	}
	
	@Test
	public void readCat() throws Exception {
		
		//RESOURCES
		CatDTO expectedResult = new CatDTO(1L, "TESLA", 11);
		
		
		//Set up request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "http://localhost:8080/cat/read/" + ID);
		
		//Set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		//PERFORM
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
	
	
	//CREATE
		@Test
		public void create() throws Exception {
			
			//RESOURCES
			CatDomain contentBody = new CatDomain(5L, "NEW", 11, 7, null);
			CatDTO expectedResult = mapToDTO(contentBody);
			expectedResult.setId(5L);
			
			
			//Set up request
			MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
					.request(HttpMethod.POST, "http://localhost:8080/cat/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(jsonifier.writeValueAsString(contentBody))
					.accept(MediaType.APPLICATION_JSON);
			
			//Set up expectations
			ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
			ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
			
			//PERFORM
			this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
		}
	
		
	//DELETE
		@Test
		public void delete() throws Exception {
			
			//RESOURCES
			
			//Mock Request
			MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
					.request(HttpMethod.DELETE,"http://localhost:8080/cat/delete/2");
			
			//AssertChecks
			ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
			
			//Perform/verify
			this.mock.perform(mockRequest)
			.andExpect(matchStatus);
		}
		
		@Test
		public void deleteCatFailure() throws Exception {
			
			//RESOURCES
			
			//Mock Request
			MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
					.request(HttpMethod.DELETE,"http://localhost:8080/cat/delete/10");
			
			//AssertChecks
			ResultMatcher matchStatus = MockMvcResultMatchers.status().isInternalServerError();
			
			//Perform/verify
			this.mock.perform(mockRequest)
			.andExpect(matchStatus);
		}
		
		

}
