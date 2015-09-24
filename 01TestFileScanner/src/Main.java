import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		writeToFile();

		File inputFile = new File("input.txt");

		try {
			Scanner in = new Scanner(inputFile);

			while (in.hasNext()) {
				System.out.println(in.next());
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void writeToFile() {

		// file will be deleted if already there!
		try {
			PrintWriter out = new PrintWriter("output.txt");
			out.println("What laberschsch!?");

			// wenn nicht geschlossen wird beim schreiben kann es sein, dass gar
			// nicht
			// geschrieben wird
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
