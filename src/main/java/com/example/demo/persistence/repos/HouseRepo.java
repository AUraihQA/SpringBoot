package com.example.demo.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.domain.HouseDomain;

public interface HouseRepo  extends JpaRepository<HouseDomain, Long>{

}
