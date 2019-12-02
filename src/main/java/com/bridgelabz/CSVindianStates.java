package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class CSVindianStates {
    @CsvBindByName
    String State;
    @CsvBindByName
    int Population;

    @CsvBindByName
    int AreaInSqKm;

    @CsvBindByName
    int DensityPerSqKm;

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public int getAreaInSqKm() {
        return AreaInSqKm;
    }

    public void setAreaInSqKm(int areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public int getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setDensityPerSqKm(int densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

}
