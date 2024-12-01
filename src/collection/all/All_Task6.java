package collection.all;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class All_Task6 {

	public static void main(String[] args) {

		// create student class objects

		Student student1 = new Student("name1", 1);
		Student student2 = new Student("name2", 3);
		Student student3 = new Student("name3", 5);
		Student student4 = new Student("name4", 3);
		Student student5 = new Student("name5", 10);

		// student hashset, wont store duplicate roll number objects
		Set<Student> studentHashSet = new HashSet<>();
		studentHashSet.add(student1);
		studentHashSet.add(student2);
		studentHashSet.add(student3);
		studentHashSet.add(student4);
		studentHashSet.add(student5);
		System.out.println("Unordered Not duplicate Student HashSet: " + studentHashSet);

		// student treeset, wont store duplicate roll number objects and store in sorted
		// order
		// order
		Set<Student> studentTreeSet = new TreeSet<>();
		studentTreeSet.add(student1);
		studentTreeSet.add(student2);
		studentTreeSet.add(student3);
		studentTreeSet.add(student4);
		studentTreeSet.add(student5);

		System.out.println("Sorted order Not duplicate Student Treeset: " + studentTreeSet);
	}
}

/**
 * Student Class
 */
class Student implements Comparable<Student> {

	private String name;
	private int rollNumber;

	Student(String name, int rollNumber) {

		this.name = name;
		this.rollNumber = rollNumber;
	}

	// since implementing comparable, we have to override compareTo, sort by roll
	// number ascending
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.rollNumber, o.rollNumber);
	}

	// since we are using Set, we need to override equals to not let set store
	// duplicate based on roll numbers
	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		return this.rollNumber == ((Student) o).rollNumber;

	}

	// since we are using set, override hashCode for duplicate check
	@Override
	public int hashCode() {
		return Integer.hashCode(rollNumber);
	}

	// for printing object in pretty format
	@Override
	public String toString() {

		return "Student " + this.name + " : " + this.rollNumber;
	}

}