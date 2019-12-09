package com.bridgelabz;

public class StateCensusAnalyserException extends Exception {
    public enum ExceptionType {ERROR_WHILE_SORT,INCORRECT_FILE_TYPE,ILLEGAL_ACCESS, IO_EXCEPTION,INCORRECT_FILE_CONTENT,NO_SUCH_TYPE, BINDING_ERROR, HEADER_MISMATCH, NO_SUCH_METHOD, NO_SUCH_FILE, Invocation_ERROR, ERROR_WHILE_WRITE;
    }
    ExceptionType type;
    public StateCensusAnalyserException(String message, ExceptionType type)
    {
        super(message);
        this.type=type;
    }

}
