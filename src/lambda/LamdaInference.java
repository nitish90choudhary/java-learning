package lambda;

import java.util.function.Consumer;

public class LamdaInference {
	public static void main(String[] args) {

		//Standard syntax
		Consumer<String> c1 = msg -> System.out.println(msg.length());

		//Compile time erorr : not enough info
		//Object x1 = msg -> System.out.println(msg.length());

		//Compile time erorr : still not enough info
		//Object x2 = (String msg) -> System.out.println(msg.length());

		//Compile time erorr : not enough info
		Object x3 = (Consumer<String>) (String msg) -> System.out.println(msg.length());

		//Part 2

		//Standard syntax
		Consumer<?> c2 = msg -> System.out.println(msg);

		//Compile time error : Inference is NOT based on body of lambda
		//Consumer<?> c3 = msg -> System.out.println(msg.length());

		//OK: Added manifest type to param
		Consumer<?> c4 = (String msg) -> System.out.println(msg.length());
	}
}
