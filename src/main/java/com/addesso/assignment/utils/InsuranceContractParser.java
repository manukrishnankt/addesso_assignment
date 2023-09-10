package com.addesso.assignment.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.addesso.assignment.exception.InvalidFileFormatException;
import com.addesso.assignment.model.InsuranceContract;

/**
 * Provide Utility operations such as Parsing of file and producing the Iterable
 * list of entity object InsuranceContract.
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public class InsuranceContractParser {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Private No Arg constructor to restrict user from creating an instance.
     * 
     **/
    private InsuranceContractParser() {
    }

    /**
     * File Processing logic.
     * Include Parsing from each line from text file.
     * 
     * @param filePath is a string object holding the path of input file
     * 
     * @throws IOException,DateTimeParseException,NumberFormatException,InvalidFileFormatException Exceptions
     * @return List<InsuranceContract> object
     **/
    public static List<InsuranceContract> parseFileAndConvertToModel(String filePath)
            throws IOException, DateTimeParseException, NumberFormatException, InvalidFileFormatException {
        List<InsuranceContract> insuranceContracts = new ArrayList<>();
        int lineNo = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
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

        } catch (IOException e) {
            throw new IOException(e);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "Exception at file line no " + lineNo + " : Contains invalid Policy number details.");
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException(
                    "Exception at file line no " + lineNo + " : Contains invalid Start Date and End Date.",
                    e.getParsedString(), e.getErrorIndex(), e);
        }
        return insuranceContracts;
    }

    /**
     * File Processing logic.
     * Include Parsing from each line from text file.
     * 
     * @param contractDetailsArr is a string array object holding the single
     *                           contract detail.
     * 
     * @return InsuranceContract
     **/
    private static InsuranceContract convertRecordToModel(String[] contractDetailsArr) {

        InsuranceContract insContract = new InsuranceContract();
        insContract.setPolicyHolderName(contractDetailsArr[0].trim());
        insContract.setPolicyNumber(Integer.parseInt(contractDetailsArr[1].trim()));
        insContract.setStartDate(LocalDate.parse(contractDetailsArr[2].trim(), dateFormatter));
        insContract.setEndDate(LocalDate.parse(contractDetailsArr[3].trim(), dateFormatter));
        return insContract;
    }
}
