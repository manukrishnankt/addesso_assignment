package com.addesso.assignment.exception;

/**
 * Thrown to indicate the file for processing is of invalid format
 * 
 * 
 * @author Manu Krishnan K
 * @version 1.0
 * @since 2023-09-09
 */
public class InvalidFileFormatException  extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}
