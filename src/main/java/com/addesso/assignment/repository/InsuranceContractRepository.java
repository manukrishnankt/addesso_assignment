package com.addesso.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addesso.assignment.model.InsuranceContract;

public interface InsuranceContractRepository extends JpaRepository<InsuranceContract, Integer> {
    
}
