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
import java.io.PrintWriter;
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
	 *            is defined as an empty string (""), no file is created.
	 * 
	 * @param outputErrorFileName
	 *            - name of the file to write the wrong lines to. If the name is
	 *            defined as an empty string (""), no file is created.
	 * 
	 * @param logFileName
	 *            - the name of the file to which the log should be written to.
	 *            If the name is defined as an empty string (""), no file is
	 *            created.
	 * 
	 *            Die Methode gibt true zurück, wenn alle Zeilen der
	 *            Input-Daten das geforderte Format erfüllen.
	 * 
	 */
	public static boolean dataAnalyzer(File inputFile, File outputFile,
			File outputErrorFile, File logFile) {

		Scanner inputFileScanner = null;
		PrintWriter outputFileWriter = null;
		PrintWriter outputErrorFileWriter = null;
		PrintWriter logFileWriter = null;

		try {

			inputFileScanner = new Scanner(inputFile);
			outputFileWriter = new PrintWriter(outputFile);
			outputErrorFileWriter = new PrintWriter(outputErrorFile);
			logFileWriter = new PrintWriter(logFile);

			if (inputFileScanner.hasNext(".")) {
				while (inputFileScanner.hasNextLine()) {
					String line = inputFileScanner.nextLine();
					if (checkLine(line)) {
						outputFileWriter.append(line);
					} else {
						outputErrorFileWriter.append(line);
					}
				}

			} else
				throw new EmptyFileException();

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			return false;
		}
		finally {
			if(inputFileScanner != null) inputFileScanner.close();
			if(inputFileScanner != null) outputFileWriter.close();
			if(inputFileScanner != null) outputErrorFileWriter.close();
			if(inputFileScanner != null) logFileWriter.close();
		}

		return false;
	}

	private static boolean checkLine(String line) {

		return false;
	}

	/**
	 * Thrown to indicate that a method tried to work with a File which is
	 * empty.
	 * 
	 * @author jnt
	 *
	 */
	public static class EmptyFileException extends IllegalArgumentException {

	}
}
