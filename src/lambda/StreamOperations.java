package lambda;

import java.util.Random;
import java.util.stream.Stream;

public class StreamOperations {
	public static void main(String[] args) {

		//1. Select 10 random positive distinct integers
		final Random rand = new Random();
		Stream<Integer> randoms = Stream.generate(rand::nextInt);
		randoms.filter(x -> x > 0).distinct().limit(10).forEach(System.out::println);

		//2. Print names of cities where at least one employee lives
//		emps.map(Employee::getAddress)
//				.map(Address::getCity)
//				.map(City::getName)
//				.distinct()
//				.forEach(System.out::println);

		
	}
}
