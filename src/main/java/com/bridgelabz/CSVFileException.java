package com.bridgelabz;

public class CSVFileException extends Exception {

    public enum ExceptionType {INCORRECT_FILE_TYPE, INCORRECT_FILE_CONTENT, NO_SUCH_TYPE, BINDING_ERROR, HEADER_MISMATCH, NO_SUCH_FILE}
    ExceptionType type;
    public CSVFileException(String message, ExceptionType type)
    {
        super(message);
        this.type=type;
    }
}
