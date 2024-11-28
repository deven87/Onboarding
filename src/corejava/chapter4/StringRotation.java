package corejava.chapter4;

public class StringRotation {

	public static void main(String[] args) {

		String str1 = new String("abcd");

		String str2 = new String("dabc");

		System.out.println("String 1 is " + str1);
		System.out.println("String 2 is " + str2);


		if (str1.length() != str2.length()) {

			System.out.println("Strings entered are not rotation of each other");
			return;

		}

		// Concatenate str1 with itself and verify that if it contains str2 now
		String concatenatedString = str1 + str1;

		if (concatenatedString.contains(str2)) {
			System.out.println("Strings entered are rotation of each other");
		} else {
			System.out.println("Strings entered are not rotation of each other");

		}

	}

}
