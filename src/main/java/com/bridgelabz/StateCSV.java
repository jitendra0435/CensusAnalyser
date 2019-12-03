package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class StateCSV {
    @CsvBindByName(column = "SrNo",required = true)
    int SrNo;

    @CsvBindByName(column = "StateName",required = true)
    String StateName;

    @CsvBindByName(column = "TIN",required = true)
    int TIN;

    @CsvBindByName(column = "StateCode",required = true)
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

    public int getTIN() {
        return TIN;
    }

    public void setTIN(int TIN) {
        this.TIN = TIN;
    }

    public String getStateCode() {
        return StateCode;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
    }
}
