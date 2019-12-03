package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class StateCensusCSV {
    @CsvBindByName(column = "State",required = true)
    String State;
    @CsvBindByName(column = "Population",required = true)
    int Population;

    @CsvBindByName(column = "AreaInSqKm",required = true)
    int AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm",required = true)
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
