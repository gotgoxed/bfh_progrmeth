package org.gradle;

public class Main {

	public static void main(String[] args) {

		printHello("Johnny");
		printHello("Chris");
		
		System.out.println(addTwoNumbers(5, 7));
	}

	/**
	 * Prints "Hello" + the name. e.g. "Hello Johnny!"
	 * 
	 * @param name
	 * @author chris
	 */
	public static void printHello(String name) {

		System.out.println("Hello " + name);
	}

	/**
	 * Adds the two numbers
	 * 
	 * @return addition of i & b
	 * @param i
	 * @param b
	 */
	public static int addTwoNumbers(int i, int b) {
		//TODO Chris
		int result = i + b;
		return result;
	}
}
