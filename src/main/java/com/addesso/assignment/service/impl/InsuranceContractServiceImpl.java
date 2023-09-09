package com.addesso.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addesso.assignment.model.InsuranceContract;
import com.addesso.assignment.repository.InsuranceContractRepository;
import com.addesso.assignment.service.InsuranceContractService;
import com.addesso.assignment.utils.InsuranceContractParser;

@Service
public class InsuranceContractServiceImpl implements InsuranceContractService{

    @Autowired
    private InsuranceContractRepository insuranceContractRepository;

    @Override
    public void parseFile(String filePath) throws Exception {
        List<InsuranceContract> constractList = InsuranceContractParser.parseFileAndConvertToModel(filePath);
        this.insuranceContractRepository.saveAll(constractList);
        
    }
    
}
