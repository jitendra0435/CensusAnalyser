package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();
    StateCSV stateCSV=new StateCSV();
    StateCensusCSV stateCensusCSV=new StateCensusCSV();

    private static String SAMPLE_CSV_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.csv";
    private static String SAMPLE_CSV_FILE_DUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode1.csv";

    private  static String STATE_CENSUS_DATA_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.csv";
    private static String STATE_CENSUS_DATA_FILE_PATHDUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.txt";
    private static String STATE_CENSUS_DATA_DUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusDataDummy.csv";
    @Test
    public void givenMethod_CheckNumberOfRecordesMatchesIfmatches_ShouldReturnTrue() throws IOException {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecordsStateCSV(SAMPLE_CSV_FILE_PATH,stateCSV);
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMethode_FoundIncorrectFileName_ThrowsException() throws IOException {
        try {
             statesCensusAnalyzer.checkNumberOfRecordsStateCSV(SAMPLE_CSV_FILE_DUMMY,stateCSV);
        }catch (CSVFileException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectFileType_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkNumberOfRecordsStateCSV(SAMPLE_CSV_FILE_DUMMY,stateCSV);
        }catch(CSVFileException  e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeter_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkNumberOfRecordsStateCSV(SAMPLE_CSV_FILE_PATH,stateCSV);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundIncCorrectHeader_ThrowsException() throws IOException {
        try {
            statesCensusAnalyzer.checkNumberOfRecordsStateCSV(SAMPLE_CSV_FILE_PATH,stateCSV);
        } catch (CSVFileException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR, e.type);
        }
    }
    @Test
    public void givenMethod_checkNumberOfRecordsMatchesOrNot() throws CSVFileException, IOException {
            int getRecords = statesCensusAnalyzer.checkRecordCensusCSV(STATE_CENSUS_DATA_FILE_PATH,stateCensusCSV);
            Assert.assertEquals(29, getRecords);
        }
    @Test
    public void givenMethod_FoundInCorrectFileName_ThrowsException() throws IOException {
        try {
            statesCensusAnalyzer.checkRecordCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY,stateCensusCSV);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_IfFoundInCorrectFileType_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY,stateCensusCSV);
        }catch(CSVFileException  e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeterInFile_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordCensusCSV(STATE_CENSUS_DATA_DUMMY,stateCensusCSV);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectHeaderInFile_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordCensusCSV(STATE_CENSUS_DATA_DUMMY,stateCensusCSV);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
 }