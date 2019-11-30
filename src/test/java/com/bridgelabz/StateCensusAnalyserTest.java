package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();

    @Test
    public void givenMethod_CheckNumberOfRecordesMatchesIfmatches_ShouldReturnTrue() throws IOException {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords();
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMethode_FoundIncorrectFileName_ThrowsException() throws IOException {
        try {
            int getRecords = statesCensusAnalyzer.checkNumberOfRecords();
            Assert.assertEquals(37, getRecords);
        }catch (CSVFileException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMethod_FoundInCorrectFileType_ThrowsException(){
        try{
            int getRecord=statesCensusAnalyzer.checkNumberOfRecords();
            Assert.assertEquals(37,getRecord);
        }catch(CSVFileException | IOException e){
            e.printStackTrace();
        }
    }
 }
