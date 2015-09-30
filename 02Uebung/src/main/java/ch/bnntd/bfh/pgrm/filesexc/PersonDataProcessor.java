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

/**
 * @author jnt
 *
 */
public class PersonDataProcessor {

	/**
	 * @param inputFile
	 * - name of the file which should be read. Must always be defined 
	 * and can't be an empty string ("") or null.
	 * 
	 * @param outputFileName
	 * - name of the file to write the correct lines to. 
	 * If the name is defined as an empty string (""), no file is created.
	 * 
	 * @param outputErrorFileName
	 * - name of the file to write the wrong lines to. 
	 * If the name is defined as an empty string (""), no file is created.
	 * 
	 * @param logFileName
	 * - the name of the file to which the log should be written to. 
	 * If the name is defined as an empty string (""), no file is created.
	 * 
	 * Die Methode gibt true zurück, wenn alle Zeilen der Input-Daten das 
	 * geforderte Format erfüllen.
	 * 
	 */
	public static boolean dataAnalyzer(File inputFile, File outputFile,
			File outputErrorFile, File logFile) {
		
		return false;
	}
}
