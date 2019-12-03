package com.bridgelabz;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CensusAnalyser {

    private static String SAMPLE_CSV_FILE_PATH ="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.JSON";
    private static String SAMPLE_CSV_POPULATION="/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/PopulationSample.JSON";
    public int checkRecordStateCensusCSV(String SAMPLE_CSV_FILE_PATH) throws CSVFileException, IOException {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<StateCensusCSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<StateCensusCSV> StateData=new ArrayList<>();

            Iterator<StateCensusCSV> statesIterator = csvToBean.iterator();
            while (statesIterator.hasNext()) {
                count++;
                StateCensusCSV csvStates = statesIterator.next();
                StateData.add(csvStates);
            }

            sortingStateByName(StateData);
            sortThisListBasedOnStatePopulation(StateData);
            writeIntoJSON(StateData);

        } catch (NoSuchFileException e) {
            throw new CSVFileException("NO_SUCH_FILE", CSVFileException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            throw new CSVFileException("Runtime Error", CSVFileException.ExceptionType.BINDING_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static void sortingStateByName(List<StateCensusCSV> list) {
        Comparator<StateCensusCSV> data = Comparator.comparing(StateCensusCSV::getState);
        list.sort(data);
       System.out.println(list.toString());
    }

    private static void writeIntoJSON(List<StateCensusCSV> list) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(SAMPLE_CSV_POPULATION);
        writer.write(json);
        writer.close();
    }

    private static void sortThisListBasedOnStatePopulation(List<StateCensusCSV> list) {
        Comparator<StateCensusCSV> data = (s1, s2) -> (s2.getPopulation())- (s1.getPopulation());
        list.sort(data);
    }

}
