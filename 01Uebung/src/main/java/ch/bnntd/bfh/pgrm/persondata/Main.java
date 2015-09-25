package ch.bnntd.bfh.pgrm.persondata;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bfh.modulBTX8051.Aufg14.base.Person;

public class Main {
	public static final Logger logger = LoggerFactory.getLogger(Main.class
			.getName());

	public static void main(String[] args) {
		logger.debug("Program started...");
		read();
		// write();
	}

	private static void write() {
		ArrayList<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Johnny", "Meier"));
		persons.add(new Person("Test", "Bob"));

		PersonDataUtil.writePersonsToFile(persons, "output.txt", ",");
	}

	private static void read() {
		ArrayList<Person> persons = PersonDataUtil.readPersonsFromFile(
				"PersonData.txt", ",");
		for (Person person : persons) {
			System.out.println(person.getName() + " " + person.getFirstName());
		}

		PersonDataUtil.printPersonList(persons);
	}
}
