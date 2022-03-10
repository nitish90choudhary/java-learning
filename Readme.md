#Interfaces
1. Interfaces are still stateless (no instance field)

2. Interfaces now provide behaviour but not state, abstract class provide both behavior and state.

## Functional interface
Any interface with a single abstract method is FI.
### Pure Functional interfaces
An FI intended to be implemented by stateless class is called pure FI.
#####FunctionalInterface - is intended for pure FIs
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
    
## Pre-Java 8 functional Interfaces
1. Runnable and Callable - Multi threading
2. ActionListener - GUIs
3. Comparable & Comparator - Sorting

Because many of interfaces with a single abstract method.

## New Functional Interfaces
40+ FIs in java.util.function

There are 6 types of FI
1. Supplier         nothing -> T         get()
2. Consumer         T-> nothing          accept()
3. UnaryOperator    T-> T                apply() e.g replaceAll in List
4. BinaryOperator   T,T -> T             apply() e.g reduce
5. Function         S -> T               apply() e.g map
6. Predicate        T -> boolean         test() e.g filter

## Functional Interfaces for Primitive Types
whose arguments and return types are primitive types.
BinaryOperator - IntBinaryOperator sum = (a,b) - > a+b;
 XSupplier , XConsumer , XUnaryOperator, XBinaryOpertor, XPredicate
 
 Where X can be Int, Long, Double
 
 Variant of Functions
 ToXFunction<T>  Where X can be Int, Long, Double
 XToYFunction  Where X & Y can be Int, Long, Double but X !=Y
 
 BooleanSupplier 
 eg, final Random rand = new Random();
 BooleansSupplier randomBS= rand::nextBoolean;
 
## Composing Functions
1. Predicate - 3 boolean connectives and, or, not.
<code>Predicate<T> a= ..., b=...;
Predicate<T> c= a.and(b),
             d= a.or(b),
             e= a.negate();
</code>

2. Consumer -  apply two consumers to the same argument sequential composition.
<code>Consumer<T> a= ..., b=...;
Consumer<T> c= a.andThen(b);</code>
e.g Writing the same string to screen adn to a file
<code>PrintWriter writer = new PrintWriter("filename.txt");
Consumer<String> logger = writer::println;
Consumer<String> screener = System.out::println;
Consumer<String> both = screener.andThen(logger);
both.accept("Program Started")</code>

- f.andThen(g) - reads left-to-right
- g.compose(f) - reads right-to-left
both computes same thing.

# Sequential streams,collections and iterators
Stream is a sequence of objects supporting internal iterations.
<code>List<String> list = Arrays.asList("Adam", "Bob", "Charlie");
      		for (String s : list)
      			System.out.println(s);</code>

 <code>Iterator<String> iterator = Arrays.asList("Adam", "Bob", "Charlie").listIterator();
      		while (iterator.hasNext())
      			System.out.println(iterator.next());</code>
      
 <code>Stream<String> stream = Arrays.asList("Adam", "Bob", "Charlie").stream();
 stream.forEach(System.out::println);</code>
 
##Operations
1. Build ops - create a stream from a data source
2. Intermediate ops - convert one stream to another
3. Terminal ops - convert stream into something else (or nothing)

##Types of Stream
1. Can be ordered and unordered streams and operations can be performed accordingly.
2. can be sequential and parallel streams

## Creating a stream
1. A static sequence of objects.
    e.g Stream.of("1","2"...)
2. A Collections
    eg. Arrays.stream()
    Streams from arrays ordered and sequential
    Streams from lists are ordered.
    Streams from sets are unordered.
3. A computations (on demand)
    1. Each one separately (via Supplier)
    e.g. Random rand = new Random();
     Stream<Integer> randoms = Stream.generate(rand::nextInt);
    2. each one from the previous one (via unaryOperator)
    e.g. Stream<String> as = Stream.iterate ("a",s->s+"a");
    
 - Computed streams are potentially infinite.
 
 ## Lazy Evaluation vs Eager Evaluation
 Build and intermediates are processed only when terminal ops is executed.
 
 ##Stream operations
 
### Filtering Operations
Based on 
1. Content -  filter, takeWhile, dropWhile
2. Amount - limit
3. Uniqueness - distinct

takeWhile - take elements as long as a Predicate is true.
dropWhile - discards elements as long as a Predicate is true.

On Unordered Streams- No Guarantee as to what elements will be taken/dropped.
