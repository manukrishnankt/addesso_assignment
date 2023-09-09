package com.addesso.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.addesso.assignment.service.InsuranceContractService;

@SpringBootApplication
public class ContractFileProcessorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ContractFileProcessorApplication.class, args);
		if (args.length > 0) {
			InsuranceContractService insuranceContractService = applicationContext
					.getBean(InsuranceContractService.class);
			try {

				insuranceContractService.parseFile(args[0]);
				System.out.println("File Processed Successfully. All Records saved to Database.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
