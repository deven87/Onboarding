package java8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	int empId;
	String empName;

	Employee(int empId, String empName) {

		this.empName = empName;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee: Id " + this.empId + " and Name " + this.empName;
	}
}

class SortByEmpidAndByName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {

		if (o1.empId == o2.empId) {
			return o1.empName.compareTo(o2.empName);
		}
		return Integer.compare(o1.empId, o2.empId);
	}

}

class SortByEmpIdAscending implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return Integer.compare(o1.empId, o2.empId);
	}

}

class SortByEmpIdDescending implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return Integer.compare(o2.empId, o1.empId);
	}
}

class SortByEmpNameAscending implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.empName.compareTo(o2.empName);
	}
}

class SortByEmpNameDescending implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.empName.compareTo(o1.empName);
	}
}

public class SortComparator_6 {

	public static void main(String[] args) {

		Employee employee1 = new Employee(1, "devendra");

		Employee employee2 = new Employee(100, "fevan");

		Employee employee3 = new Employee(100, "zevan");

		Employee employee4 = new Employee(50, "evan");

		Employee employee5 = new Employee(70, "fevan");

		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);

		System.out.println(employeeList);

		employeeList.sort(new SortByEmpIdAscending());

		System.out.println("Sorted by Employee ID ascending order: " + employeeList);

		employeeList.sort(new SortByEmpIdDescending());

		System.out.println("Sorted by Employee ID descending order: " + employeeList);

		employeeList.sort(new SortByEmpidAndByName());

		System.out.println("Sorted by Employee ID ascending and name in case id is same: " + employeeList);

		Collections.sort(employeeList, new SortByEmpNameAscending());

		System.out.println("Sorted by Employee Name ascending order: " + employeeList);

		Collections.sort(employeeList, new SortByEmpNameDescending());

		System.out.println("Sorted by Employee Name descending order: " + employeeList);

		Comparator<Employee> compareByName = (e1, e2) -> {
			return e1.empName.compareTo(e2.empName);
		};

		Collections.sort(employeeList, compareByName);

		System.out.println("Sorted by Employee Name ascending order: using lambda " + employeeList);

	}


}