import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTester {

	public static void main(String[] args) {

		//TreeSet: sorted, after tree algorithm
		//HashMap: not sorted, but fast

		Map<String, String> hashMap = new HashMap<>();
		fillMap(hashMap);
		
		Map<String, String> treeMap = new TreeMap<>();
		fillMap(treeMap);
		
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		fillMap(linkedHashMap);


		System.out.println("TreeMap:");
		System.out.println(treeMap);
		printMap(treeMap);

		System.out.println();

		System.out.println("HashMap:");
		System.out.println(hashMap);
		printMap(hashMap);

		System.out.println();

		System.out.println("LinkedHashMap:");
		System.out.println(linkedHashMap);
		printMap(linkedHashMap);
	}
	
	public static void fillMap(Map<String, String> map) {
		map.put("3000", "Phil");
		map.put("5000", "Konrad");
		map.put("4000", "Jürgen");
		map.put("2000", "Bobby");
		map.put("1000", "Ashley");
	}
	
	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
