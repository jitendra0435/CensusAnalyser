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

    private static String sortByState = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/StateCode.JSON";
    private static String sortByPopulation = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/PopulationSample.JSON";
    private static String sortByDensity = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/PopulationDensity.JSON";
    private static String sortByArea = "/home/admin1/Desktop/CensusAnalyserProblem/src/test/resources/SortByArea.JSON";

    public int checkRecordStateCensusCSV(String SAMPLE_CSV_FILE_PATH) throws CSVFileException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int Recordcount = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<StateCensusCSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<StateCensusCSV> StateData = new ArrayList<>();

            Iterator<StateCensusCSV> statesIterator = csvToBean.iterator();
            while (statesIterator.hasNext()) {
                Recordcount++;
                StateCensusCSV csvStates = statesIterator.next();
                StateData.add(csvStates);
            }
            ascendingSort(StateData, "getState", sortByState);
            descendingSort(StateData, "getPopulation", sortByPopulation);
            descendingSort(StateData,"getDensityPerSqKm",sortByDensity );
            descendingSort(StateData,"getAreaInSqKm",sortByArea );

        } catch (NoSuchFileException e) {
            throw new CSVFileException("NO_SUCH_FILE", CSVFileException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            throw new CSVFileException("Runtime Error", CSVFileException.ExceptionType.BINDING_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Recordcount;
    }
    private static void writeIntoJSON(List<StateCensusCSV> list,String fileName) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }
    void ascendingSort(List<StateCensusCSV> list, String methodname, String fileName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
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

    void descendingSort(List<StateCensusCSV> list, String methodname, String fileName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
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