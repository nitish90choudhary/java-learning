package lambda.pojo;

public class Employee {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		setName(name);
		setSalary(salary);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
