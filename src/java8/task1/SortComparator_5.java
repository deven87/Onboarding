package java8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortComparator_5 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(5);

		System.out.println(list);
		Collections.sort(list);

		System.out.println("Natural sorting on integer list: " + list);

		Comparator<Integer> compare = (x, y) -> Integer.compare(y, x);

		Collections.sort(list, compare);
		System.out.println("Comparator sorting on integer list: " + list);

	}

}
