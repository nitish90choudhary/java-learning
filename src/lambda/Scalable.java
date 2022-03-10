package lambda;

public interface Scalable {

	//implicitly public static final
	double DEFAULT_SCALE = 1.0;

	//concrete method - implicitly public
	static boolean isScalable(Object obj) {
		return obj instanceof Scalable;
	}

	//Default methods- concrete instance method, can be overridden
	default void resetScale() {
		setScale(DEFAULT_SCALE);
	}

	//implicitly public abstract
	void setScale(double scale);
}

/*Notes
1. Interfaces are still stateless (no instance field)

2. Interfaces now provide behaviour but not state, abstract class provide both behavior and state.

## Functional interface
-> Any interface with a single abstract method is FI.
->> An FI intended to be implemented by stateless class is called pure FI.
@FunctionalInterface - is intended for pure FIs
in Java9 - 40 FIs
examples:
Scalable - not pure
Runnable - not pure
Comparable - not pure
Comparator - pure ( Class implementing this Interfaces has no state)

# A Function accepting an object is Consumer
public interface Consumer<T> {
	void accept(T t);
}

# A Function producing an object is Supplier

public interface Supplier<T> {
	T get(();
}




*/
