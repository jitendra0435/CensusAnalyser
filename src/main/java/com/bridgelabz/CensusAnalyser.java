package com.bridgelabz;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class CensusAnalyser<T extends Comparable<T>> {
     String sortByState = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.JSON";
     String sortByPopulation = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/PopulationSample.JSON";
     String sortByDensity = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/PopulationDensity.JSON";
     String sortByArea = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/SortByArea.JSON";

    public  int checkRecordStateCensusCSV(String SAMPLE_CSV_FILE_PATH) throws StateCensusAnalyserException{
        int recordCount = 0;
        List<StateCensusCSV> stateData = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<StateCensusCSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<StateCensusCSV> statesIterator = csvToBean.iterator();
            while (statesIterator.hasNext()) {
                recordCount++;
                StateCensusCSV csvStates = statesIterator.next();
                stateData.add(csvStates);
            }
            ascendingSort(stateData, "getState", sortByState);
            descendingSort(stateData, "getPopulation", sortByPopulation);
            descendingSort(stateData,"getDensityPerSqKm",sortByDensity );
            descendingSort(stateData,"getAreaInSqKm",sortByArea );

        }catch (NoSuchFileException e) {
            throw new StateCensusAnalyserException("No such file present", StateCensusAnalyserException.ExceptionType.NO_SUCH_FILE);
        }catch (RuntimeException e) {
            throw new StateCensusAnalyserException("Runtime Error", StateCensusAnalyserException.ExceptionType.BINDING_ERROR);
        }catch (IOException e) {
            throw new StateCensusAnalyserException("IO Exception",StateCensusAnalyserException.ExceptionType.IO_EXCEPTION);
        }catch (NoSuchMethodException e) {
            throw new StateCensusAnalyserException("Method not found",StateCensusAnalyserException.ExceptionType.NO_SUCH_METHOD);
        }catch (IllegalAccessException e) {
            throw new StateCensusAnalyserException("Illegal access",StateCensusAnalyserException.ExceptionType.ILLEGAL_ACCESS);
        }catch (InvocationTargetException e) {
            throw new StateCensusAnalyserException("Invocation target error",StateCensusAnalyserException.ExceptionType.Invocation_ERROR);
        }
        return recordCount;
    }

    private static void writeIntoJSON(List<StateCensusCSV> list,String fileName) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }

    public void ascendingSort(List<StateCensusCSV> list, String methodname, String fileName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Class cls = list.get(j).getClass();
                Method methodcall = cls.getDeclaredMethod(methodname);
                T value1 = (T) methodcall.invoke(list.get(j));
                Class cls1 = list.get(j + 1).getClass();
                Method methodcall1 = cls1.getDeclaredMethod(methodname);
                T value2 = (T) methodcall1.invoke(list.get(j + 1));
                if (value1.compareTo(value2) > 0) {
                    StateCensusCSV tempObj = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempObj);
                }
            }
        }
        writeIntoJSON(list, fileName);
    }

    public void descendingSort(List<StateCensusCSV> list, String methodname, String fileName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Class cls = list.get(j).getClass();
                Method methodcall = cls.getDeclaredMethod(methodname);
                T value1 = (T) methodcall.invoke(list.get(j));
                Class cls1 = list.get(j + 1).getClass();
                Method methodcall1 = cls1.getDeclaredMethod(methodname);
                T value2 = (T) methodcall1.invoke(list.get(j + 1));
                if (value1.compareTo(value2) < 0) {
                    StateCensusCSV tempObj = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempObj);
                }
            }
            writeIntoJSON(list, fileName);
        }
    }
}