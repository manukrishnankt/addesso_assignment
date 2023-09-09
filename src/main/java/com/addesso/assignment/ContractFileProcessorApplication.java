package com.addesso.assignment;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.addesso.assignment.model.InsuranceContract;
import com.addesso.assignment.service.InsuranceContractService;

@SpringBootApplication
public class ContractFileProcessorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ContractFileProcessorApplication.class, args);
		if (args.length > 0) {
			InsuranceContractService insuranceContractService = applicationContext
					.getBean(InsuranceContractService.class);
			initFileProcess(insuranceContractService, args[0]);
		}
	}

	private static void initFileProcess(InsuranceContractService insuranceContractService, String filePath) {
		try {
			List<InsuranceContract> contracts = insuranceContractService.parseFile(filePath);
			System.out
					.println("==============================================================================\n\n");
			System.out.println("File Processed Successfully. " + contracts.size() + " Record(s) saved to database.");
			System.out
					.println("\n\n==============================================================================");
		}catch (DataIntegrityViolationException e) {
			System.out
					.println("==============================================================================\n\n");
			System.out.println("Operaton failed. Please check the LOG and verify the input file.");
			System.err.println(e.getRootCause() +"\n\n");
			e.printStackTrace();
			System.out
					.println("\n\n==============================================================================");
		} catch (Exception e) {
			System.out
					.println("==============================================================================\n\n");
			System.out.println("Operaton failed. Please check the LOG and verify the input file\n\n\n");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.out
					.println("\n\n==============================================================================");
		}
	}

}
