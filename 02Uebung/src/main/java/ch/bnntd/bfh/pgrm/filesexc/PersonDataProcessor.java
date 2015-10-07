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
import java.io.IOException;
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
	 * 
	 * @throws EmptyFileException
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

			//Three of the params can be defined as null,
			//then no files will be created.
			if (outputFile != null) {
				outputFileWriter = new PrintWriter(outputFile);
			}
			if(outputErrorFile != null) {
				outputErrorFileWriter = new PrintWriter(outputErrorFile);
			}
			if(logFile != null) {
				logFileWriter = new PrintWriter(logFile);
			}

			if (inputFileScanner.hasNextLine()) {
				while (inputFileScanner.hasNextLine()) {
					String line = inputFileScanner.nextLine();
					if (checkLine(line)) {
						outputFileWriter.append(line);
					} else {
						outputErrorFileWriter.append(line);
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
			if (outputFileWriter!= null)
				outputFileWriter.close();
			if (outputErrorFileWriter!= null)
				outputErrorFileWriter.close();
			if (logFileWriter != null)
				logFileWriter.close();
		}

		return false;
	}

	private static boolean checkLine(String line) {
		logger.debug("Checking line: \n" + line);
		
		String[] splittedLine = line.split(";");


		return false;
	}
}
