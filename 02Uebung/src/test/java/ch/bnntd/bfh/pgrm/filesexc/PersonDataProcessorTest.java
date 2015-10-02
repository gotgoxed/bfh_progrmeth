package ch.bnntd.bfh.pgrm.filesexc;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.junit.Test;

public class PersonDataProcessorTest {

	@Test
	public void testDataAnalyzer() {
		File inputFile = new File("DataCSVerrors.txt");
		File outputFile = new File("FileWithRightLines.txt");
		File outputErrorFile = new File("FileWithErrorLines.txt");
		File logFile = new File("logFile.txt");

		boolean testFile = PersonDataProcessor.dataAnalyzer(inputFile,
				outputFile, outputErrorFile, logFile);

		assertFalse(testFile);
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
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
