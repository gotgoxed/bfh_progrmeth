package ch.bnntd.bfh.pgrm.filesexc;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import ch.bfh.modulBTX8051.Aufg14.base.Person;

public class Main {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

		File testFile = new File(Main.class.getResource("DataCSVerrors.txt").toURI());

		Scanner scanner = new Scanner(testFile, "UTF-8");

		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}

	}

}
