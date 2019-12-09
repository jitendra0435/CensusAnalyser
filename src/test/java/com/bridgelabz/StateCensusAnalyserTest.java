package com.bridgelabz;
import org.junit.Assert;
import org.junit.Test;
public class StateCensusAnalyserTest {

    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();
    private  static String STATE_CENSUS_DATA_FILE_PATH="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.csv";
    private static String STATE_CENSUS_DATA_FILE_PATHDUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusData.txt";
    private static String STATE_CENSUS_DATA_DUMMY="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCensusDataDummy.csv";

    @Test
    public void givenMethod_checkNumberOfRecordsMatchesOrNot() {
        int getRecords = 0;
        try {
            getRecords = statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATH);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(29, getRecords);
        }
    }
    @Test
    public void givenMethod_FoundInCorrectFileName_ThrowsException() {
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        } catch (StateCensusAnalyserException e){
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE,e.type);
        }
    }

    @Test
    public void givenMethod_IfFoundInCorrectFileType_ThrowsException() {
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATHDUMMY);
        } catch(StateCensusAnalyserException e){
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenMethod_FoundInCorrectDelimeterInFile_ThrowsException() {
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_DUMMY);
        } catch (StateCensusAnalyserException e){
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.BINDING_ERROR,e.type);
        }
    }

    @Test
    public void givenMethod_FoundInCorrectHeaderInFile_ThrowsException() {
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_DUMMY);
        } catch (StateCensusAnalyserException e){
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.BINDING_ERROR,e.type);
        }
    }

    @Test
    public void givenMethod_ForSortTheCSVFileAndWriteIntoJson() {
        int records= 0;
        try {
            records = statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATH);
            Assert.assertEquals(29,records);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.ERROR_WHILE_WRITE,e.type);
        }

    }

    @Test
    public void gevenMethod_ForSortTheCSVDataAndWriteIntoJson(){
        try {
            statesCensusAnalyzer.checkRecordStateCensusCSV(STATE_CENSUS_DATA_FILE_PATH);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.ExceptionType.ERROR_WHILE_SORT,e.type);
        }
    }
 }