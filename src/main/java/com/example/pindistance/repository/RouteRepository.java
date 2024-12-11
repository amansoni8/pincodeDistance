package com.example.pindistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pindistance.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}


