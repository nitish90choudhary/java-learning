import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

import com.learn.pojo.Employee;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		System.out.println(composeHashCodes3("Hello", "World"));
		//System.out.println(composeHashCodes3("Hello", null));

		// ####Composition examples

		//Example1 : Get the initial letter of an Employee's name
		Employee nitish = new Employee("Nitish", 100);

		Function<Employee, String> getName = Employee::getName;
		Function<String, Character> getFirstLetter = name -> name.charAt(0);

		Function<Employee, Character> getInitials = getName.andThen(getFirstLetter);

		System.out.println(getInitials.apply(nitish));

		//Compare Employee by name and then by salary
		Employee nitish2 = new Employee("Nitish", 120);

		Comparator<Employee> byName = Comparator.comparing(Employee::getName);
		Comparator<Employee> bySalary = Comparator.comparingInt(Employee::getSalary);
		Comparator<Employee> nameThenSalary = byName.thenComparing(bySalary);

		System.out.println(nameThenSalary.compare(nitish, nitish2));

	}

	public static int composeHashCodes(Object a, Object b) {
		return a.hashCode() ^ b.hashCode();
	}

	//A slow method
	public static String getApplicationStatus() {
		System.out.println("getApplication");
		return "It's " + LocalTime.now();
	}

	public static int composeHashCodes2(Object a, Object b) {
		Objects.requireNonNull(a, "a may not be null! " + getApplicationStatus());
		Objects.requireNonNull(b, "b may not be null! " + getApplicationStatus());
		return a.hashCode() ^ b.hashCode();
	}

	public static int composeHashCodes3(Object a, Object b) {
		//by using the supplier to build the String, we delayed the string building till it is required
		Objects.requireNonNull(a, () -> "a may not be null! " + getApplicationStatus());
		Objects.requireNonNull(b, () -> "b may not be null! " + getApplicationStatus());
		return a.hashCode() ^ b.hashCode();
	}
}
