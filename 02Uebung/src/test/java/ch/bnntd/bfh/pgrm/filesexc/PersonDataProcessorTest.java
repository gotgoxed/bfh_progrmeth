package ch.bnntd.bfh.pgrm.filesexc;

import static org.junit.Assert.*;

import java.io.File;

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

}
