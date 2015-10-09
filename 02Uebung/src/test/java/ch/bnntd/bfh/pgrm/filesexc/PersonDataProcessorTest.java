package ch.bnntd.bfh.pgrm.filesexc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.junit.Test;

public class PersonDataProcessorTest {

	/**
	 * Tests the dataAnalyzer function.
	 */
	@Test
	public void testDataAnalyzerWithWrongInputFile() {
		File inputFile;
		try {
			inputFile = new File(PersonDataProcessorTest.class.getResource(
					"DataCSVerrors.txt").toURI());
			File outputFile = new File("test/FileWithRightLines.txt");
			File outputErrorFile = new File("test/FileWithErrorLines.txt");
			File logFile = new File("test/logFile.txt");

			boolean validFile = PersonDataProcessor.dataAnalyzer(inputFile,
					outputFile, outputErrorFile, logFile);

			assertFalse(validFile);

		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail();
		} catch (EmptyFileException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDataAnalyzerWithCorrectInputFile() {
		File inputFile;
		try {
			inputFile = new File(PersonDataProcessorTest.class.getResource(
					"DataCSVmn.txt").toURI());
			File outputFile = new File("test/FileWithRightLines.txt");
			File outputErrorFile = new File("test/FileWithErrorLines.txt");
			File logFile = new File("test/logFile.txt");

			boolean validFile = PersonDataProcessor.dataAnalyzer(inputFile,
					outputFile, outputErrorFile, logFile);

			assertTrue(validFile);

		} catch (URISyntaxException e) {
			e.printStackTrace();
			fail();
		} catch (EmptyFileException e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Tests if {@link EmptyFileException} gets thrown if overgiven file is
	 * empty.
	 * 
	 * @throws EmptyFileException
	 * @throws URISyntaxException
	 */
	@Test(expected = EmptyFileException.class)
	public void testEnterEmptyFile() throws EmptyFileException,
			URISyntaxException {
		File inputFile = new File(PersonDataProcessorTest.class.getResource(
				"DataCSVempty.txt").toURI());

		PersonDataProcessor.dataAnalyzer(inputFile, null, null, null);
	}

	@Test
	public void testResourcePath() {

		System.out.println(this.getClass().getResource("."));

		Scanner scanner;
		try {
			File newFile = new File(PersonDataProcessor.class.getResource(
					"DataCSVerrors.txt").toURI());

			System.out.println(newFile.toString());

			scanner = new Scanner(newFile, "UTF-8");

			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMatchStrings() {
		assertFalse("öäüAbuelasn".matches("[a-zA-Z]"));

		assertFalse("askld8372äü=".matches("[a-zA-Z]"));

		// kind a joke
		assertFalse("asdlklsköüé".matches("\\w"));

		assertTrue("8956781".matches("\\d+"));

		assertTrue("qweröo;".matches("\\D+"));

		assertFalse("alsc=32".matches("\\d+"));
	}

	@Test
	public void testGetNameOfActualMethod() {
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfDataAnalyzerReturnsRightExceptions() {
		try {
			PersonDataProcessor.dataAnalyzer(null, null, null, null);
		} catch (EmptyFileException e) {
			e.printStackTrace();
		}
	}
}
