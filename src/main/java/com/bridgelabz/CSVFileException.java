package com.bridgelabz;

public class CSVFileException extends Exception {

    ExceptionType type;

    public enum ExceptionType {NO_SUCH_FILE}

    public CSVFileException(String msg, ExceptionType type) {
        super(msg);
        this.type=type;

    }
}
