package ch.bnntd.bfh.pgrm.persondata;

import java.util.ArrayList;

import ch.bfh.modulBTX8051.Aufg14.base.Person;

public class Main {

	public static void main(String[] args) {
		System.out.println("Program started...");
		read();
	}
	
	private static void write() {
		ArrayList<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Johnny", "Meier"));
		
		PersonDataUtil.writePersonsToFile(persons, "output.txt", ",");
	}
	
	private static void read() {
		ArrayList<Person> persons = PersonDataUtil.readPersonsFromFile("PersonData.txt", ",");
		for (Person person : persons) {
			System.out.println(person.getName() + " " + person.getFirstName());
		}
	}
}
