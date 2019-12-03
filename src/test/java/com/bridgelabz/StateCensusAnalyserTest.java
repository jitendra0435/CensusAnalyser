package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();

    private  static String STATE_CENSUS_DATA_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.csv";
    private static String STATE_CENSUS_DATA_FILE_PATHDUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.txt";
    private static String STATE_CENSUS_DATA_DUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusDataDummy.csv";

    @Test
    public void givenMethod_checkNumberOfRecordsMatchesOrNot() throws CSVFileException, IOException {
            int getRecords = statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATH);
            Assert.assertEquals(29, getRecords);
        }
    @Test
    public void givenMethod_FoundInCorrectFileName_ThrowsException() throws IOException {
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }
    @Test
    public void givenMethod_IfFoundInCorrectFileType_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        }catch(CSVFileException  e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectDelimeterInFile_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_DUMMY);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectHeaderInFile_ThrowsException() throws IOException {
        try{
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_DUMMY);
        }catch (CSVFileException e){
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.BINDING_ERROR,e.type);
        }
    }
    @Test
    public void givenMethod_ForSortTheCSVAndWriteIntoJson() throws CSVFileException, IOException {
        int records=statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATH);
        Assert.assertEquals(29,records);
    }
 }