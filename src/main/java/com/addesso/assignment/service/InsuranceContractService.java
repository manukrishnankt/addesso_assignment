package com.addesso.assignment.service;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

/**
<<<<<<< HEAD
 * Provide insurance file processing operations.
 * Also includes persisting of data into database after processing and parsing
 * of record.
=======
 * Provide insurance file processing operations. Also includes persisting of
 * data into database after processing and parsing of record.
>>>>>>> 9d5469372b9f215567fcd82ce0db80b93b0c6824
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public interface InsuranceContractService {
	/**
<<<<<<< HEAD
	 * Logic including parsing and persisting to database.
	 * 
	 * @param filePath is a string object holding the path of input file
	 **/
	List<InsuranceContract> parseFile(String filePath)
			throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException;

	int getRecordLength();
=======
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

>>>>>>> 9d5469372b9f215567fcd82ce0db80b93b0c6824
}
