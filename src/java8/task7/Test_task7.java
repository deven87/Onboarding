package java8.task7;

interface Emp {
	void getEmployeeDetail(String name, String account, double salary);
}

class Employee {
	String account;
	String name;
	double salary;

	Employee(String name, String account, double salary) {
		this.name = name;
		this.account = account;
		this.salary = salary;
		System.out.println("Emp: Name " + this.name + " Account " + this.account + " Salary " + this.salary);

	}
}

public class Test_task7 {

	public static void main(String[] args) {

		Emp emp = Employee::new;
		emp.getEmployeeDetail("devendra", "test", 100);

	}

}