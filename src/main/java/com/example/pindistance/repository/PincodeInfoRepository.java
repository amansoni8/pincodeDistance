package com.example.pindistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pindistance.entity.PincodeInfo;

public interface PincodeInfoRepository extends JpaRepository<PincodeInfo, String> {
	
}

