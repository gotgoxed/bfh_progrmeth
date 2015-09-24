package ch.bnntd.bfh.pgrm.persondata;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sun.javafx.tk.PrintPipeline;

import ch.bfh.modulBTX8051.Aufg14.base.Person;

public class PersonDataUtilTest {

	@Test
	public void testReadPersonsFromFile() {
		ArrayList<Person> persons = PersonDataUtil.readPersonsFromFile("testFile", ";");
	}

	@Test
	public void testWritePersonsToFile() {

	}

	@Test
	public void testPrintPersonList() {
		
		ArrayList<Person> persons = PersonDataUtil.readPersonsFromFile("PersonData.txt", ",");
		
		PersonDataUtil.printPersonList(persons);
	}


}
