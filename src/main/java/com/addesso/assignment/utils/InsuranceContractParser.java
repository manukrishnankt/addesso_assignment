package com.addesso.assignment.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

public class InsuranceContractParser {
    private static Logger logger = LoggerFactory.getLogger(InsuranceContractParser.class);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static List<InsuranceContract> parseFileAndConvertToModel(String filePath)
            throws Exception {
        BufferedReader reader = null;
        List<InsuranceContract> insuranceContracts = new ArrayList<>();
        int lineNo = 0;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                lineNo++;
                String[] contractDetailsArr = line.split(",");
                if (contractDetailsArr.length != 4) {
                    throw new InvalidFileFormatException(
                            "Exception at file line no " + lineNo + " : Missing record details.");
                }
                InsuranceContract contractRecord = convertRecordToModel(contractDetailsArr);
                insuranceContracts.add(contractRecord);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            throw new IOException(e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "Exception at file line no " + lineNo + " : Contains invalid Policy number details.");
        } catch (DateTimeParseException e) {
            throw new NumberFormatException(
                    "Exception at file line no " + lineNo + " : Contains invalid Start Date and End Date.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                logger.info(e.getMessage());
                throw new Exception(e);
            }
        }

        return insuranceContracts;
    }

    private static InsuranceContract convertRecordToModel(String[] contractDetailsArr) {

        InsuranceContract insContract = new InsuranceContract();
        insContract.setPolicyHolderName(contractDetailsArr[0]);
        insContract.setPolicyNumber(Integer.parseInt(contractDetailsArr[1]));
        insContract.setStartDate(LocalDate.parse(contractDetailsArr[2], dateFormatter));
        insContract.setEndDate(LocalDate.parse(contractDetailsArr[3], dateFormatter));
        return insContract;
    }
}
