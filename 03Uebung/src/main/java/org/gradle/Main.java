package org.gradle;

public class Main {

	public static void main(String[] args) {

		printHello("Johnny");
		printHello("Chris");
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
}
