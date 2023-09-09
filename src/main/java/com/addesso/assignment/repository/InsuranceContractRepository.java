package com.addesso.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addesso.assignment.model.InsuranceContract;

@Repository
public interface InsuranceContractRepository extends JpaRepository<InsuranceContract, Integer> {
    
}
