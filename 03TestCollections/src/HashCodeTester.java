import java.util.HashSet;

public class HashCodeTester {

	public static void main(String[] args) {

		HashSet<String> hSet = new HashSet<>(10);

		Object obj = new Object();
		System.out.println(obj.hashCode());
		
		
		String bla = new String("Christian");
		System.out.println(bla.hashCode());
		
	}

	public static void howAHashTableWorks() {

		final int CAPACITY = 11; // Defines the size of the hash table.

		String[] strings = { "Java", "Pascal", "Fortran", "Cobol", "C",
				"Basic", "Simula", "Algol", "Logo" };

		for (String s : strings) {
			System.out.println('"' + s + '"' + " | " + "hash code: "
					+ s.hashCode() + " | array index: "
					+ Math.abs(s.hashCode() % CAPACITY));
		}
	}
}