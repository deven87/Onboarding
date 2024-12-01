package collection.stack;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Stack_Task4 {

	/**
	 * isBalanceString
	 * @param userString
	 * @return true if its balanced
	 */
	public static boolean isBalanceString(String userString) {

		Stack<Character> stack = new Stack<>();

		for (char ch : userString.toCharArray()) {

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				char popChar = stack.pop();

				if (ch == ']' && popChar != '[' || ch == ')' && popChar != '(' || ch == '}' && popChar != '{') {
					return false;
				}
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		Path path = Paths.get(System.getProperty("user.dir"), "src", "collection", "stack", "stackinput.txt");

		List<String> stringList = new ArrayList<>();

		stringList = readFile(path);

		if (stringList.isEmpty()) {
			System.out.println("Please check your input file");
			return;
		}

		for (String string : stringList) {
			System.out.println(string + " " + isBalanceString(string));
		}

	}

	/**
	 * read the file
	 * @param filePath path of the file
	 * @return list of string lines
	 */
	public static List<String> readFile(Path filePath) {

		List<String> stringList = new ArrayList<>();
		try (Scanner scanner = new Scanner(filePath)) {
			while (scanner.hasNextLine()) {
				stringList.add(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stringList;
	}
}
