package java8.task1;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Employee1 {
	int empId;
	String empName;

	Employee1(int empId, String empName) {

		this.empName = empName;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee: Id " + this.empId + " and Name " + this.empName;
	}
}

public class SortSet_7 {

	public static void main(String[] args) {

		Employee1 employee1 = new Employee1(1, "devendra");

		Employee1 employee2 = new Employee1(100, "fevan");

		Employee1 employee3 = new Employee1(100, "zevan");

		Employee1 employee4 = new Employee1(50, "evan");

		Employee1 employee5 = new Employee1(70, "fevan");

		Comparator<Employee1> compareByName = (e1, e2) -> {

			return e1.empName.compareTo(e2.empName);
		};

		Set<Employee1> employeeSet = new TreeSet<>(compareByName);

		employeeSet.add(employee1);
		employeeSet.add(employee2);
		employeeSet.add(employee3);
		employeeSet.add(employee4);
		employeeSet.add(employee5);

		// elements are displayed with natural added sorting
		System.out.println(employeeSet);

	}
}