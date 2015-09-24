package ch.bnntd.bfh.pgrm.persondata;

import org.junit.Test;

import ch.bfh.modulBTX8051.Aufg14.base.Person;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPerson() {
    	Person person = new Person("Meier", "Johnny");
    	assertTrue(person.getName().equals("Meier"));
    }
}
