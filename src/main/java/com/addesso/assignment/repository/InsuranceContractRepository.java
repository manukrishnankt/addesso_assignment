package com.addesso.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.addesso.assignment.dtos.InsuranceContractVo;
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

    @Query(value = "SELECT new com.addesso.assignment.dtos.InsuranceContractVo(c.id, c.policyHolderName) FROM InsuranceContract AS c")
    List<InsuranceContractVo> getInsuranceRecords();
}
