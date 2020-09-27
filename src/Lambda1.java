import java.util.Comparator;
import java.util.function.Consumer;

import com.learn.pojo.Employee;

public class Lambda1 {
	public static void main(String[] args) {

		Comparator<Employee> byName = new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};

		//First lambda expression
		Comparator<Employee> byNameLambda = (Employee a, Employee b) -> a.getName().compareTo(b.getName());

		//Removing parameter Types
		Comparator<Employee> byNameLambda1 = (a, b) -> {
			return a.getName().compareTo(b.getName());
		};

		//Removing braces and return
		Comparator<Employee> byNameLambda2 = (a, b) -> a.getName().compareTo(b.getName());

		// Expression with one parameter
		Consumer<String> lengthPrinter = s -> System.out.println(s.length());
	}
}
