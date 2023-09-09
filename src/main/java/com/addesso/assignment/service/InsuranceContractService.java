package com.addesso.assignment.service;

import java.util.List;

import com.addesso.assignment.model.InsuranceContract;

public interface InsuranceContractService {
   List<InsuranceContract> parseFile(String filePath) throws Exception;
}
