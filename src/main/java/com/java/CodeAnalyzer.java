package com.java;

import java.io.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class CodeAnalyzer {
	/*
	 * Ability for the analyser to load the Indian States Census 
	 * Information from a csv file - Create
	 */
	static int namOfEateries = 0;
    public int loadIndiaCodeData(String csvFilePath) throws CodeAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndianStateCode> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianStateCode.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStateCode> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianStateCode> codeCSVIterator = csvToBean.iterator();;
            while (codeCSVIterator.hasNext()) {
                namOfEateries++;
                IndianStateCode codeData = codeCSVIterator.next();
            }
            return namOfEateries;
        }
        catch (NoSuchFileException e) {
            if(!csvFilePath.contains(".csv")) {
                throw new CodeAnalyzerException(e.getMessage(), CodeAnalyserException.ExceptionType.WRONG_FILE_TYPE);
            }
        }
        catch (IOException e) {
            throw new CodeAnalyzerException(e.getMessage(),
                    CodeAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        catch (RuntimeException e) {
            throw new CodeAnalyserException(e.getMessage(), CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER);
        }
        return namOfEateries;
    }
}
