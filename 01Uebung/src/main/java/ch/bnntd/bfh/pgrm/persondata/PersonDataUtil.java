package ch.bnntd.bfh.pgrm.persondata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bfh.modulBTX8051.Aufg14.base.Person;

public class PersonDataUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonDataUtil.class.getName());

	/**
	 * Reads the definitions for Doctor or Patient objects from a defined file
	 * and returns the read data in an ArrayList.
	 * 
	 * @param inputFileName
	 * @param delimiter
	 * @return ArrayList with persons
	 */
	public static ArrayList<Person> readPersonsFromFile(String inputFileName,
			String delimiter) {
		ArrayList<Person> persons = new ArrayList<Person>();

		try {
			Scanner scanner = new Scanner(new File(inputFileName));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().trim();

				logger.debug("Read line: " + line);

				String[] lineArr = line.split(delimiter);

				Person person = new Person(lineArr[0].trim(), lineArr[1].trim());

				persons.add(person);
				// TODO add logging
			}

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return persons;
	}

	/**
	 * Writes the data of the defined ArrayList to a file which name can be
	 * defined.
	 * 
	 * @param persons
	 * @param outputFile
	 * @param delimiter
	 */
	public static void writePersonsToFile(ArrayList<Person> persons,
			String outputFile, String delimiter) {

		// TODO: loggin hinzufügen
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(outputFile);

			for (Person person : persons) {
				writer.println(person.getName() + delimiter
						+ person.getFirstName());

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * This functions helps to print out an ArrayList with Persons in a table.
	 * 
	 * @param persons
	 */
	public static void printPersonList(ArrayList<Person> persons) {

		System.out.printf("|-----------------------------------------|\n");
        System.out.printf("|%-20s|%-20s|\n", "Prename", "Name");
        System.out.printf("|-----------------------------------------|\n");
		for (Person person : persons) {
			System.out.printf("|%20s|%20s|\n", person.getFirstName(), person.getName());
		}
        System.out.printf("|-----------------------------------------|\n");
	}
}
