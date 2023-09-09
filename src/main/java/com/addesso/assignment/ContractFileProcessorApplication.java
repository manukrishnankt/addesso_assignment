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

@SpringBootApplication
public class ContractFileProcessorApplication {
    private static Logger logger = LoggerFactory.getLogger(ContractFileProcessorApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ContractFileProcessorApplication.class, args);
		InsuranceContractService insuranceContractService = applicationContext
					.getBean(InsuranceContractService.class);
		if (args.length > 0) {
			initFileProcess(insuranceContractService, args[0]);
		} 
	}

	private static void initFileProcess(InsuranceContractService insuranceContractService, String filePath) {
		try {
			List<InsuranceContract> contracts = insuranceContractService.parseFile(filePath);
			String outPutMsg = "File Processed Successfully. " + contracts.size() + " Record(s) saved to database.";
			logger.info(outPutMsg);
		}catch (DataIntegrityViolationException e) {
			logger.error("Operaton failed. Unique Constraint found duplicate entry. Please verify Policy Number.");
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Operaton failed. Please check the LOG and verify the input file\n\n\n");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
