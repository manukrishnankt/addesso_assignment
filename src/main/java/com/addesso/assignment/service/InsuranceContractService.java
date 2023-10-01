package com.addesso.assignment.service;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

/**
 * Provide insurance file processing operations. Also includes persisting of
 * data into database after processing and parsing of record.
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public interface InsuranceContractService {
	/**
	 *
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @throws DateTimeParseException
	 * @throws NumberFormatException
	 * @throws InvalidFileFormatException
	 */
	List<InsuranceContract> parseFile(String filePath)
			throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException;

}
