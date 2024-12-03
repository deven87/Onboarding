package java8.task1;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Employee2 {
	int empId;
	String empName;

	Employee2(int empId, String empName) {

		this.empName = empName;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee: Id " + this.empId + " and Name " + this.empName;
	}
}

public class SortMap_8 {

	public static void main(String[] args) {

		Employee2 employee1 = new Employee2(1, "devendra");

		Employee2 employee2 = new Employee2(100, "fevan");

		Employee2 employee3 = new Employee2(100, "zevan");

		Employee2 employee4 = new Employee2(50, "evan");

		Employee2 employee5 = new Employee2(70, "fevan");

		Comparator<Employee2> compareByName = (e1, e2) -> {

			return e2.empName.compareTo(e1.empName);
		};

		Map<Employee2, String> employeeMap = new TreeMap<>(compareByName);

		employeeMap.put(employee1, "IT");
		employeeMap.put(employee2, "IT");
		employeeMap.put(employee3, "IT");
		employeeMap.put(employee4, "IT");
		employeeMap.put(employee5, "HR");

		// elements are displayed with natural added sorting
		System.out.println("Sorted Employee Map with Emp Name in Descending" + employeeMap);

	}
}