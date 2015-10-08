/**
 * Uebung 02
 * 
 * Ziele
 * 
 * Mit der Aufgabe soll exemplarisch gezeigt werden, wie die Definitionen von Filenamen 
 * und die Filedaten mit der Nutzung von Exceptions abschliessend validiert werden können.
 */
package ch.bnntd.bfh.pgrm.filesexc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jnt
 *
 */
public class PersonDataProcessor {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonDataProcessor.class);

	/**
	 * @param inputFile
	 *            - name of the file which should be read. Must always be
	 *            defined and can't be an empty string ("") or null.
	 * 
	 * @param outputFileName
	 *            - name of the file to write the correct lines to. If the name
	 *            is defined as null, no file is created.
	 * 
	 * @param outputErrorFileName
	 *            - name of the file to write the wrong lines to. If the name is
	 *            defined as null, no file is created.
	 * 
	 * @param logFileName
	 *            - the name of the file to which the log should be written to.
	 *            If the name is defined as null, no file is created.
	 * 
	 *            Die Methode gibt true zurück, wenn alle Zeilen der
	 *            Input-Daten das geforderte Format erfüllen.
	 * @throws EmptyFileException
	 * @throws IOException
	 * 
	 */
	public static boolean dataAnalyzer(File inputFile, File outputFile,
			File outputErrorFile, File logFile) throws EmptyFileException {

		Scanner inputFileScanner = null;
		PrintWriter outputFileWriter = null;
		PrintWriter outputErrorFileWriter = null;
		PrintWriter logFileWriter = null;

		try {

			inputFileScanner = new Scanner(inputFile, "UTF-8");

			// Three of the params can be defined as null,
			// then no files will be created.
			if (outputFile != null) {
				outputFileWriter = new PrintWriter(outputFile);
			}
			if (outputErrorFile != null) {
				outputErrorFileWriter = new PrintWriter(outputErrorFile);
			}
			if (logFile != null) {
				logFileWriter = new PrintWriter(logFile);
			}

			if (inputFileScanner.hasNextLine()) {
				while (inputFileScanner.hasNextLine()) {
					String line = inputFileScanner.nextLine();
					try {
						if (checkLine(line, logFileWriter)) {
							logger.debug("Line is valid.");
							outputFileWriter.println(line);
						} else {
							logger.debug("Line is invalid.");
							outputErrorFileWriter.println(line);
						}
					} catch (IOException e) {
						logger.debug("Error with logfileWriter.");
					}
				}
			} else
				throw new EmptyFileException("Input file is empty.");

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			return false;
		} finally {
			if (inputFileScanner != null)
				inputFileScanner.close();
			if (outputFileWriter != null)
				outputFileWriter.close();
			if (outputErrorFileWriter != null)
				outputErrorFileWriter.close();
			if (logFileWriter != null)
				logFileWriter.close();
		}

		return false;
	}

	// valid line:
	// 21196;Helfenstein;Ruth;1931;W
	/**
	 *
	 * @param line
	 * @return true if line is ok, throws {@link WrongLineFormatException} if
	 *         not.
	 * @throws IOException
	 */
	private static boolean checkLine(String line, PrintWriter logfileWriter)
			throws IOException {

		boolean logToFile = false;
		if (logfileWriter != null)
			logToFile = true;

		logger.debug("Checking line: [" + line + "]");
		if (logToFile)
			logfileWriter.println("Checking line: [" + line + "]");

		String[] splittedLine = line.split(";");
		boolean returnValue = true;
		String errorMessage = null;

		if (splittedLine.length != 5) {
			errorMessage = "Wrong line format: Line contains more or less than 5 entries.";
			logger.debug(errorMessage);
			if (logToFile) {
				logfileWriter.println(errorMessage);
				logfileWriter.println();
			}
			return false;
		}

		//check if one ore more entry is empty
		for (String string : splittedLine) {
			if (string.matches("")) {
				errorMessage = "One ore more entries are empty.";
				logger.debug(errorMessage);
				if (logToFile) {
					logfileWriter.println(errorMessage);
					logfileWriter.println();
				}
				return false;
			}
		}

		if (!splittedLine[0].matches("\\d\\d\\d\\d\\d?")) {
			errorMessage = "Wrong line format: ID contains not between 4 and 5 digits.";
			logger.debug(errorMessage);
			if (logToFile)
				logfileWriter.println(errorMessage);
			returnValue = false;
		}

		if (!splittedLine[1].matches("\\D+")) {
			errorMessage = "Wrong line format: Name contains numbers.";
			logger.debug(errorMessage);
			if (logToFile)
				logfileWriter.println(errorMessage);
			returnValue = false;
		}

		if (!splittedLine[2].matches("\\D+")) {
			errorMessage = "Wrong line format: Name contains numbers.";
			logger.debug(errorMessage);
			if (logToFile)
				logfileWriter.println(errorMessage);
			returnValue = false;
		}

		if (!splittedLine[3].matches("\\d\\d\\d\\d")) {
			errorMessage = "Wrong line format: Volume has other format than 4 digits.";
			logger.debug(errorMessage);
			if (logToFile)
				logfileWriter.println(errorMessage);
			returnValue = false;
		}

		if (!splittedLine[4].matches("W|M|w|m")) {
			errorMessage = "Wrong line format: Gender format contains other char than W/M/m/w.";
			logger.debug(errorMessage);
			if (logToFile)
				logfileWriter.println(errorMessage);
			returnValue = false;
		}

		if (logToFile) {
			if (returnValue)
				logfileWriter.println("Line valid.");
			logfileWriter.println();
		}
		return returnValue;
	}
}
