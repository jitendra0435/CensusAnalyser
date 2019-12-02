package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();
    private static String SAMPLE_CSV_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.csv";
    private  static String STATE_CENSUS_DATA_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.csv";

    private static String STATE_CENSUS_DATA_FILE_PATHDUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.txt";
    private static String STATE_CENSUS_DATA_DUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusDataDummy.csv";
    @Test
    public void givenMethod_CheckNumberOfRecordesMatchesIfmatches_ShouldReturnTrue() {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords(SAMPLE_CSV_FILE_PATH);
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMethode_FoundIncorrectFileName_ThrowsException() {
        try {
             statesCensusAnalyzer.checkNumberOfRecords(SAMPLE_CSV_FILE_PATH);
        }catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectFileType_ThrowsException(){
        try{
            statesCensusAnalyzer.checkNumberOfRecords(SAMPLE_CSV_FILE_PATH);
        }catch(CSVFileException  e){
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeter_ThrowsException(){
        try{
            statesCensusAnalyzer.checkNumberOfRecords(SAMPLE_CSV_FILE_PATH);
        }catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundIncCorrectHeader_ThrowsException() {
        try {
            statesCensusAnalyzer.checkNumberOfRecords(SAMPLE_CSV_FILE_PATH);
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR, e.type);
        }
    }
    @Test
    public void givenMethod_checkNumberOfRecordsMatchesOrNot() throws CSVFileException {
            int getRecords = statesCensusAnalyzer.checkRecord(STATE_CENSUS_DATA_FILE_PATH);
            Assert.assertEquals(29, getRecords);
        }
    @Test
    public void givenMethod_FoundInCorrectFileName_ThrowsException(){
        try {
            statesCensusAnalyzer.checkRecord(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        }catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_IfFoundInCorrectFileType_ThrowsException(){
        try{
            statesCensusAnalyzer.checkRecord(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        }catch(CSVFileException  e){
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeterInFile_ThrowsException(){
        try{
            statesCensusAnalyzer.checkRecord(STATE_CENSUS_DATA_DUMMY);
        }catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectHeaderInFile_ThrowsException(){
        try{
            statesCensusAnalyzer.checkRecord(STATE_CENSUS_DATA_DUMMY);
        }catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
 }