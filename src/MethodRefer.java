import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.learn.pojo.Employee;

public class MethodRefer {
	public static void main(String[] args) {

		//Ref to static method
		Supplier<Thread> s1 = Thread::currentThread;

		//Our own supplier
		ThreadSupplier ts = Thread::currentThread;

		//Instance method - specified
		Employee frank = new Employee("Frank", 3000);
		Integer i = frank.getSalary();
		Supplier<Integer> s2 = frank::getSalary;
		System.out.println(s2.get());

		// A common instance method
		Consumer<String> c1 = System.out::println;

		//An instance method -unspecified
		Function<Employee, Integer> f1 = Employee::getSalary;
		Integer frankSalary = f1.apply(frank);
		System.out.println(frankSalary);

		// A useful application : building a comparator based on field of class

		// comparing expects Function<Employee,U>, where U supports natural ordering (i.e comparable)

		Comparator<Employee> byName = Comparator.comparing(Employee::getName);
		Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);

		Employee dept[] = new Employee[5];
		dept[0] = new Employee("Alec", 1500);
		dept[1] = new Employee("Bob", 2500);
		dept[2] = new Employee("Claire", 5500);
		dept[3] = new Employee("Douglas", 1700);
		dept[4] = new Employee("Ethan", 1600);

		printAll(dept, Employee::getName);

		//Compile time error: reason: Incompatible types: int is not convertible to String
		//printAll(dept, Employee::getSalary);

		printAll(dept, employee -> "" + employee.getSalary());
	}

	public static <T> void printAll(T[] array, Function<T, String> toStringFun) {
		int i = 0;
		for (T t : array) {
			System.out.println(i++ + ":\t" + toStringFun.apply(t));
		}

	}

	interface ThreadSupplier {
		Thread giveMeAThread();
	}
}
