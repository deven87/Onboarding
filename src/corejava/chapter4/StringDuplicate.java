package corejava.chapter4;

import java.util.HashMap;
import java.util.Map;

public class StringDuplicate {

	public static void main(String[] args) {

		String str = new String("devendra");

		System.out.println("given string is " + str);

		System.out.println("duplicate characters in the string are");

		Map<Character, Integer> charCountMap = new HashMap<>();

		for (char c : str.toCharArray()) {

			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

		}

		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {

			if (entry.getValue() > 1) {

				System.out.println("Character " + entry.getKey() + " occurance " + entry.getValue() + " times");
			}

		}


	}

}
