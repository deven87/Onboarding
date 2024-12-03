package java8.task1;

import java.util.Scanner;
import java.util.function.Predicate;

public class Palindrom_1 {

	/**
	 * isPalindrom
	 *
	 * @param myString
	 * @return
	 */
	public static boolean isPalindrom(String myString) {

		Predicate<String> isPalindrom = (str) -> str.equals(new StringBuilder(str).reverse().toString());

		return isPalindrom.test(myString);
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter a String");

			String myString = scanner.next();

			System.out.println(Palindrom_1.isPalindrom(myString));
			
		}
	}

}
