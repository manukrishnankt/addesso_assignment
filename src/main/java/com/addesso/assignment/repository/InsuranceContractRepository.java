package com.addesso.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addesso.assignment.model.InsuranceContract;

/**
 * For the standard crud database operations and built in hibernate JPA support
 * for InsuranceContract entity
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public interface InsuranceContractRepository extends JpaRepository<InsuranceContract, Integer> {

}
