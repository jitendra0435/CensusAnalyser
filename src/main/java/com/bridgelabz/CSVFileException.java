package com.bridgelabz;

public class CSVFileException extends Exception {

    ExceptionType type;

    public enum ExceptionType {INCORRECT_FILE_TYPE, INCORRECT_FILE_CONTENT,NO_SUCH_FILE}

    public CSVFileException(String msg, ExceptionType type) {
        super(msg);
        this.type=type;
    }
}
