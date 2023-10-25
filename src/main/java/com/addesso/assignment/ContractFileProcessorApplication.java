package com.addesso.assignment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.addesso.assignment.model.InsuranceContract;
import com.addesso.assignment.service.InsuranceContractService;

/**
 * Provide an entry point for the springboot application
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
@SpringBootApplication
public class ContractFileProcessorApplication {
	private static Logger logger = LoggerFactory.getLogger(ContractFileProcessorApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ContractFileProcessorApplication.class, args);
		InsuranceContractService insuranceContractService = applicationContext
				.getBean(InsuranceContractService.class);
		if (args.length > 0) {
			initFileProcess(insuranceContractService, args[0]);
		} else {
			getProcessSize(insuranceContractService);
		}
	}

	/**
	 * File Processing logic starts from here.
	 * Include Parsing and Persisting to database.
	 * 
	 * @param insuranceContractService object have the business logic to invoke
	 *                                 parsing and persisting.
	 * @param filePath                 is a string object holding the path of input
	 *                                 file
	 **/
	private static void initFileProcess(InsuranceContractService insuranceContractService, String filePath) {
		try {
			List<InsuranceContract> contracts = insuranceContractService.parseFile(filePath);
			String outPutMsg = "\n\n\nFile Processed Successfully. " + contracts.size()
					+ " Record(s) saved to database.";
			logger.info(outPutMsg);
		} catch (DataIntegrityViolationException e) {
			logger.error(
					"\n\n\nOperaton failed. Unique Constraint found duplicate entry. Please verify Policy Number.");
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("\n\n\nOperaton failed. Please check the LOG and verify the input file");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
		 * 
		 **/
	private static void getProcessSize(InsuranceContractService insuranceContractService) {
		System.out.println("=========================================");
		System.out.println(insuranceContractService.getRecordLength());
		System.out.println("=========================================");
	}
}
