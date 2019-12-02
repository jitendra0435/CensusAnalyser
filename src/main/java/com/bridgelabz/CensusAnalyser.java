package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;

public class CensusAnalyser {

    public int checkNumberOfRecords(String SAMPLE_CSV_FILE_PATH) throws  CSVFileException {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVStates> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStates> statesIterator = csvToBean.iterator();
            while (statesIterator.hasNext()) {
                count++;
                CSVStates csvStates = statesIterator.next();
            }

        } catch (NoSuchFileException e) {
            throw new CSVFileException("NO_SUCH_FILE", CSVFileException.ExceptionType.NO_SUCH_FILE,e.getMessage());
        } catch (RuntimeException e) {
            throw new CSVFileException("Incorrect File Type", CSVFileException.ExceptionType.NO_SUCH_TYPE, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}