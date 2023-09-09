package com.addesso.assignment.service;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

public interface InsuranceContractService {
   List<InsuranceContract> parseFile(String filePath)
         throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException;
}
