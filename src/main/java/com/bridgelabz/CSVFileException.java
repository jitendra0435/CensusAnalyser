package com.bridgelabz;

public class CSVFileException extends Exception {

    public enum ExceptionType {INCORRECT_FILE_TYPE, INCORRECT_FILE_CONTENT, NO_SUCH_TYPE, NO_SUCH_FILE}
    ExceptionType type;
    public CSVFileException(String msg, ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
