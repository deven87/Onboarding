package java8.task1;

import java.util.function.BiPredicate;

public class Rotation_3 {

	public static boolean isRotation(String str1, String str2) {

		BiPredicate<String, String> isRotation = (str11, str22) -> {
			return str11.length() == str22.length() && (str11 + str11).contains(str22);
		};

		return isRotation.test(str1, str2);
	}

	public static void main(String[] args) {

		String str1 = new String("abc");
		String str2 = new String("cab");
		System.out.println(Rotation_3.isRotation(str1, str2));
	}
}
