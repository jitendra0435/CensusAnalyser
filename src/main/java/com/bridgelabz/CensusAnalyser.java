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
            throw new CSVFileException("NO_SUCH_FILE", CSVFileException.ExceptionType.NO_SUCH_FILE);
        } catch (RuntimeException e) {
            throw new CSVFileException("Runtime Error", CSVFileException.ExceptionType.BINDING_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int checkRecord(String CSV_DATA_PATH) throws CSVFileException {
        int count = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_DATA_PATH));
        ) {
            CsvToBean<CSVindianStates> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVindianStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVindianStates> statesIterator = csvToBean.iterator();
            while (statesIterator.hasNext()) {
                count++;
                CSVindianStates csvStates = statesIterator.next();
            }
        } catch (NoSuchFileException e) {
            throw new CSVFileException("NO_SUCH_FILE", CSVFileException.ExceptionType.NO_SUCH_FILE);
        }catch (RuntimeException e) {
            throw new CSVFileException("Runtime Error", CSVFileException.ExceptionType.BINDING_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }


}
