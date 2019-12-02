package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();

    @Test
    public void givenMethod_CheckNumberOfRecordesMatchesIfmatches_ShouldReturnTrue() {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords("/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.csv");
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMethode_FoundIncorrectFileName_ThrowsException() throws IOException {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords("/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode1.csv");
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectFileType_ThrowsException(){
        try{
            int getRecord=statesCensusAnalyzer.checkNumberOfRecords("/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.csv1");
        }catch(CSVFileException  e){
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_TYPE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeter_ThrowsException(){
        try{
            int getRecords=statesCensusAnalyzer.checkNumberOfRecords("/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCodeDummy.csv");
            Assert.assertEquals(37,getRecords);
        }catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundIncCorrectHeader_ThrowsException() {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords("/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCodeDummy.csv");
            Assert.assertEquals(37, getRecords);
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR, e.type);
        }
    }
 }