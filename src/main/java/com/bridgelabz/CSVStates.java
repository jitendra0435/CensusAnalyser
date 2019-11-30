package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
    @CsvBindByName
    int SrNo;

    @CsvBindByName
    String StateName;

    @CsvBindByName
    String TIN;

    @CsvBindByName
    String StateCode;

    public int getSrNo() {
        return SrNo;
    }

    public void setSrNo(int srNo) {
        SrNo = srNo;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
