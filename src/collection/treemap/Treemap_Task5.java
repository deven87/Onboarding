package collection.treemap;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Treemap_Task5 {

	private static Map<Integer, Integer> treeMap;

	public static void main(String[] args) throws IOException {

		// file path for reading input data
		Path path = Paths.get(System.getProperty("user.dir"), "src", "collection", "treemap", "inputfile.txt");
		try (Scanner scanner = new Scanner(path)) {

			// read first line int for no of test cases
			int noOfTestCases = scanner.nextInt();

			// consume next line
			scanner.nextLine();

			for (int i = 1; i <= noOfTestCases; i++) {

				// create new map for each test case
				treeMap = new TreeMap<>();

				// get next int value as no of queries
				int noOfQueries = scanner.nextInt();

				// consume next line
				scanner.nextLine();

				// split the next line each with a single operation
				String[] commands = scanner.nextLine().split("(?=[a-zA-Z])");

				for (int j = 0; j < noOfQueries; j++) {

					// split each command further into operative and operands
					String[] command = commands[j].split(" ");

					// manuipulate map based on the operative which is stored as first value in each
					// command
					switch (command[0]) {
					case "a":
						treeMap.put(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
						break;
					case "b":
						Integer value = treeMap.get(Integer.parseInt(command[1]));
						if ( value == null) {
							System.out.print(-1 + "\t");
						} else {
							System.out.print(value + "\t");
						}
						break;
					case "c":
						System.out.print(treeMap.size() + "\t");
						break;
					case "d":
						treeMap.remove(Integer.parseInt(command[1]));
						break;
					case "e":
						System.out.print(treeMap.keySet() + "\t");
						break;
					default:
						throw new IllegalArgumentException("Unexpected map operation: " + command[j]);
					}
				}
				System.out.println();

			}

		}

	}
}

