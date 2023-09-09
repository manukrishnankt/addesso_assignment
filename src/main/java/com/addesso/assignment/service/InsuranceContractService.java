package com.addesso.assignment.service;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

/**
 * Provide insurance file processing operations.
 * Also includes persisting of data into database after processing and parsing of record.
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public interface InsuranceContractService {
   /**
	 * Logic including parsing and persisting to database.
	 * 
	 * @param filePath is a string object holding the path of input file
	 **/
   List<InsuranceContract> parseFile(String filePath)
         throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException;
}
