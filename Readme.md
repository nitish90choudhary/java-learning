#Interfaces
1. Interfaces are still stateless (no instance field)

2. Interfaces now provide behaviour but not state, abstract class provide both behavior and state.

## Functional interface
Any interface with a single abstract method is FI.
### Pure Functional interfaces
An FI intended to be implemented by stateless class is called pure FI.
#####@FunctionalInterface - is intended for pure FIs
In Java9 - 40 FIs
#### Examples:
1. Scalable - not pure
2. Runnable - not pure
3. Comparable - not pure
4. Comparator - pure ( Class implementing this Interfaces has no state)

###Consumer
A Function accepting an object is Consumer

<code>public interface Consumer<T> {
	void accept(T t);
}</code>

### Supplier
A Function producing an object is Supplier.

<code>public interface Supplier<T> {
	T get(();
}</code>

#Lambda Expression
It is compact syntax to implement FIs.

<code>Comparator<Employee> byLength = (String a, String b)-> {
				return Integer.compare(a.length(),b.length());
			};</code>

##Type Inference
It is way compiler infers type of missing type during compile time. This is present since Java 5.

In Java 8 & 9 type inference are implemented for FIs.
Context must contain enough info to identify the receiving FIs.
1. RHS of assignment
    <code>Consumer<String> = lambda </code>
2. An actual parameter of a method or constructor.
    <code>new Thread (lambda)</code>
3. Argument of return
    <code>return lambda</code>
    
4. Argument of cast
    <code>(Consumer<Sting>) lambda</code>
    
##Capturing Fields
1. Lambda expression can access:
    1. Static fields of enclosing class
    2. instance fields of enclosing object.
 HOW?? : they store a reference to the enclosing object
    3. Lambda expr can access local variables of the enclosing method provided they are effectively final.
    How?? : They store a copy of their value (same rule as anonymous class)
    
##Difference b/w lambda expr and anonymous classes
1. Lambda are more brief but anonymous classes require more code.
2. Lambda do not create additional class files, but for anonymous class compiler generates class files in byte-code folder.
3. Not every occurrence of lambda creates a new object, 

Limitations:
1. Lambda only work for FIs (if we have more than 1 abstract method, then we need anonymous class)
2. Lambda can't have state, but Anonymous classes can have state (i.e fields)

##Method References
It is an expression of denoting a method. Similar to function pointer in C/C++.
Also, it is more efficient than reflection.

###Various methods of using
1. Static method                             Employee::getMaxSalary
2. Instance method, unspecified instance     Employee::getSalary
3. Instance method, specified instance       mike::getSalary
4. Constructor                               Employee::new
5. Instance method of super-class            super::foo 
6. Array Constructor                         A[]::foo 

Legal context of method reference are same as of lambda expression
1. RHS of assignment
    <code>T var = method ref </code>
2. An actual parameter of a method or constructor.
    <code>Foo (method ref)</code> - type of the corresponding formal parameter.
3. Argument of return
    <code>return method ref</code> - return type of current method
4. Argument of cast
    <code>(T) method ref</code>