package com.java;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CodeAnalyzerTest {
	 private static final String INDIA_CODE_CSV_FILE_PATH = "C:\\Users\\Shita\\Downloads\\IndiaStateCode.csv";
	    private static final String WRONG_CSV_FILE_PATH = "F:\\Users\\Shita\\Downloads\\IndiaStateCode.csv";
	    private static final String WRONG_FILE_TYPE_PATH = "C:\\Users\\Shita\\Downloads\\IndiaStateCode.txt";
	    private static final String WRONG_DELIMITER_FILE_PATH = "C:\\Users\\Shita\\Downloads\\WrongDelimiterIndiaStateCode.csv";
	    private static final String WITHOUT_HEADER_FILE_PATH = "C:\\Users\\Shita\\Downloads\\WithoutHeaderIndiaStateCode.csv";

	    /*
	     * TC 1.1
	     * Given the States Census CSV file, Check to ensure the Number of Record matches
	     */
	    @Test
	    public void given_IndianCodeCSVFile_ReturnsCorrectRecords() {
	        try {
	            CodeAnalyzer codeAnalyser = new CodeAnalyzer();
	            int numOfRecords = codeAnalyser.loadIndiaCodeData(INDIA_CODE_CSV_FILE_PATH);
	            Assert.assertEquals(29,numOfRecords);
	        } catch (CodeAnalyzerException e) { }
	    }

	    /*
	     * TC 1.2
	     * Given the State Census CSV File if incorrect Returns a custom Exception
	     */
	    @Test
	    public void given_IndiaCodeData_WithWrongFilePath_ShouldThrowException() {
	        try {
	            CodeAnalyzer codeAnalyser = new CodeAnalyzer();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CodeAnalyserException.class);
	            codeAnalyser.loadIndiaCodeData(WRONG_CSV_FILE_PATH);
	        } catch (CodeAnalyzerException e) {
	            Assert.assertEquals(CodeAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
	        }
	    }

	    /*
	     * TC 1.3
	     * Given the State Census CSV File when correct but type incorrect Returns a custom Exception
	     */
	    @Test
	    public void given_IndiaCodeData_WithWrongFileType_ShouldThrowException() {
	        try {
	            CodeAnalyser codeAnalyser = new CodeAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CodeAnalyserException.class);
	            codeAnalyser.loadIndiaCodeData(WRONG_FILE_TYPE_PATH);
	        } catch (CodeAnalyserException e) {
	            Assert.assertEquals(CodeAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
	        }
	    }

	    /*
	     * TC 1.4
	     * Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
	     */
	    @Test
	    public void given_IndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
	        try {
	            CodeAnalyser codeAnalyser = new CodeAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CodeAnalyserException.class);
	            codeAnalyser.loadIndiaCodeData(WRONG_DELIMITER_FILE_PATH);
	        } catch (CodeAnalyserException e) {
	            Assert.assertEquals(CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
	        }
	    }

	    /*
	     * TC 1.5
	     * Given the State Census CSV File when correct but csv header incorrect Returns a
	     * custom Exception
	     */
	    @Test
	    public void given_IndiaCodeData_WithoutHeader_ShouldThrowException() {
	        try {
	            CodeAnalyser codeAnalyser = new CodeAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CodeAnalyserException.class);
	            codeAnalyser.loadIndiaCodeData(WITHOUT_HEADER_FILE_PATH);
	        } catch (CodeAnalyserException e) {
	            Assert.assertEquals(CodeAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_HEADER, e.type);
	        }
	    }
}
