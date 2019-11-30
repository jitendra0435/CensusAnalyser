package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    CensusAnalyser statesCensusAnalyzer = new CensusAnalyser();

    @Test
    public void givenMethod_CheckNumberOfRecordesMatchesIfmatches_ShouldReturnTrue() throws IOException {

        int getRecords = statesCensusAnalyzer.checkNumberOfRecords();
        Assert.assertEquals(37, getRecords);
    }
}