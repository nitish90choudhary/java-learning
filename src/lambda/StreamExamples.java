package lambda;

import java.util.Arrays;

import lambda.pojo.Employee;

public class StreamExamples {
	public static void main(String[] args) {
		Employee employees[] = new Employee[5];
		employees[0] = new Employee("Alec", 1500);
		employees[1] = new Employee("Claire", 4500);
		employees[2] = new Employee("Bob", 2500);
		employees[3] = new Employee("Ethan", 1600);
		employees[4] = new Employee("Douglas", 1700);

		Arrays.stream(employees).filter(e -> e.getSalary() >= 2500)
				.map(Employee::getName)
				.sorted()
				.forEach(System.out::println);

	}
}
