package com.bridgelabz;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {

    public int OpenCSVBuilder(Reader reader, Object POJO)  {
        int noOfRecord = 0;
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(POJO.getClass())
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<Object> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()) {
            csvUserIterator.next();
            noOfRecord++;
        }

        return  noOfRecord;

    }

    public int checkNumberOfRecordsStateCSV(String SAMPLE_CSV_FILE_PATH,Object POJO) throws CSVFileException, IOException {
        int record=0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            record = OpenCSVBuilder(reader, POJO);
        } catch (NoSuchFileException e) {
            throw new CSVFileException("No such file or InCorrect file type", CSVFileException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            throw new CSVFileException("runtime error", CSVFileException.ExceptionType.BINDING_ERROR);
        }

        return record;
    }

    public int checkRecordCensusCSV(String SAMPLE_CSV_FILE_PATH, Object POJO) throws IOException, CSVFileException {
        int recordCount = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            recordCount = OpenCSVBuilder(reader, POJO);
        } catch (NoSuchFileException e) {
            throw new CSVFileException("enter proper file name", CSVFileException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            throw new CSVFileException("runtime error", CSVFileException.ExceptionType.BINDING_ERROR);
        }
        return recordCount;
    }
}

