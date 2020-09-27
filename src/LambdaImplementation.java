import java.util.function.Consumer;

public class LambdaImplementation {
	private static int staticID = 10;
	private int id = 1;

	public static void main(String[] args) {
		//Anonymous class, multiple instances
		System.out.println("#Anonymous Class");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter1 = new Consumer<String>() {
				@Override
				public void accept(String s) {
					System.out.println("Consuming :" + s);
				}
			};
			myPrinter1.accept(myPrinter1.toString());
		}

		//Non-capturing lambda, one instance is created
		System.out.println("#Non-capturing lambda");
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter2 = s -> System.out.println("Consuming :" + s);
			myPrinter2.accept(myPrinter2.toString());
		}

		//Constant-capturing lambda, one instance is created
		System.out.println("#Constant-capturing lambda");
		final int secret = 21;//local variable capturing
		for (int i = 0; i < 5; i++) {
			Consumer<String> myPrinter3 = s -> System.out.println("Consuming :" + s + ", " + secret);
			myPrinter3.accept(myPrinter3.toString());
		}

		//Instance capturing lambda, creates multiple instances
		new LambdaImplementation().printInstanceVariable();

		// if instance variable is static then it will create one instance
		new LambdaImplementation().printStaticInstanceVariable();
	}

	public void printInstanceVariable() {
		//Instance-capturing lambda
		System.out.println("#Instance-capturing lambda");
		for (int i = 0; i < 5; i++) {
			//this-capturing lambda, many instances
			Consumer<String> myPrinter4 = s -> System.out.println("Consuming :" + s + ", " + id);
			myPrinter4.accept(myPrinter4.toString());
		}
	}

	public void printStaticInstanceVariable() {
		//Instance-capturing lambda
		System.out.println("#Static Instance-capturing lambda");
		for (int i = 0; i < 5; i++) {
			//this-capturing lambda, only one instances
			Consumer<String> myPrinter4 = s -> System.out.println("Consuming :" + s + ", " + staticID);
			myPrinter4.accept(myPrinter4.toString());
		}
	}
}
