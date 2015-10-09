import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyCollectionTests {

	public static void main(String[] args) {

		//LISTS
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		// int --> Integer, automated by Java

		intList.add(3);
		intList.add(4);
		intList.add(5);

		System.out.println(intList);
		intList.set(1, 8);
		System.out.println(intList);
		intList.add(1, 10);
		System.out.println(intList);
		
		//MAPS
		Map<String, String> stringMap = new HashMap<String, String>();
		
		for (String s : stringMap.keySet()) {
			System.out.println(s);
		}
		
		
	}
}
