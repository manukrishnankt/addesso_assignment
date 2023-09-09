package com.addesso.assignment.service.impl;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;
import com.addesso.assignment.repository.InsuranceContractRepository;
import com.addesso.assignment.service.InsuranceContractService;
import com.addesso.assignment.utils.InsuranceContractParser;

/**
 * Provide insurance file processing operations.
 * Also includes persisting of data into database after processing and parsing of record.
 * This is a concrete class of InsuranceContractService interface.
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
@Service
public class InsuranceContractServiceImpl implements InsuranceContractService {

    @Autowired
    private InsuranceContractRepository insuranceContractRepository;

    @Override
    public List<InsuranceContract> parseFile(String filePath) throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException {
        List<InsuranceContract> constractList = InsuranceContractParser.parseFileAndConvertToModel(filePath);
        return this.insuranceContractRepository.saveAll(constractList);

    }

}
