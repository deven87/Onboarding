package java8.task1;

import java.util.Arrays;
import java.util.List;

public class Largest_2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 10, 9, 19, 200);
		System.out.println(list.stream().distinct().sorted().skip(list.size() - 2).findFirst().get());
	}
}
