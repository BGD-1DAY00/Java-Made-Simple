# Java Functional Interfaces: Comprehensive Guide

## What are Functional Interfaces?

A functional interface in Java is an interface that contains exactly one abstract method. They are the foundation for lambda expressions in Java 8 and later versions. Functional interfaces can have any number of default or static methods, but must have only one abstract method.

Key points:
1. Single Abstract Method (SAM) interfaces
2. Can be annotated with @FunctionalInterface (optional but recommended)
3. Used as the basis for lambda expressions and method references

## Purpose of Interfaces

Interfaces in Java serve several purposes:
1. Define a contract for classes to implement
2. Achieve abstraction
3. Support multiple inheritance of type
4. Enable loose coupling between components

## Functional Interfaces vs Regular Interfaces

Regular interfaces can have multiple abstract methods, while functional interfaces must have exactly one.

```java
// Regular interface
interface Vehicle {
    void start();
    void stop();
}

// Functional interface
@FunctionalInterface
interface Runnable {
    void run();
}
```

## Common Functional Interfaces in Java

Java provides several built-in functional interfaces in the `java.util.function` package:

1. **Function<T,R>**
    - Represents a function that takes an argument of type T and returns a result of type R
   ```java
   Function<String, Integer> length = s -> s.length();
   System.out.println(length.apply("Hello")); // Outputs: 5
   ```

2. **Predicate<T>**
    - Represents a boolean-valued function of one argument
   ```java
   Predicate<String> isEmpty = s -> s.isEmpty();
   System.out.println(isEmpty.test("")); // Outputs: true
   ```

3. **Consumer<T>**
    - Represents an operation that accepts a single input argument and returns no result
   ```java
   Consumer<String> printer = s -> System.out.println(s);
   printer.accept("Hello, World!"); // Outputs: Hello, World!
   ```

4. **Supplier<T>**
    - Represents a supplier of results
   ```java
   Supplier<Double> randomSupplier = () -> Math.random();
   System.out.println(randomSupplier.get()); // Outputs a random double
   ```

5. **UnaryOperator<T>**
    - Represents an operation on a single operand that produces a result of the same type as its operand
   ```java
   UnaryOperator<Integer> square = x -> x * x;
   System.out.println(square.apply(5)); // Outputs: 25
   ```

6. **BinaryOperator<T>**
    - Represents an operation upon two operands of the same type, producing a result of the same type
   ```java
   BinaryOperator<Integer> add = (a, b) -> a + b;
   System.out.println(add.apply(5, 3)); // Outputs: 8
   ```

## Creating Custom Functional Interfaces

You can create your own functional interfaces:

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Calculator {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println("10 + 5 = " + addition.operate(10, 5));
        System.out.println("10 - 5 = " + subtraction.operate(10, 5));
    }
}
```

## Functional Interfaces and Lambda Expressions

Functional interfaces are the basis for lambda expressions:

```java
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

public class GreetingExample {
    public static void main(String[] args) {
        Greeting casualGreeting = name -> System.out.println("Hey, " + name + "!");
        Greeting formalGreeting = name -> System.out.println("Good day, " + name + ".");

        casualGreeting.greet("Alice"); // Outputs: Hey, Alice!
        formalGreeting.greet("Mr. Smith"); // Outputs: Good day, Mr. Smith.
    }
}
```

## Interfaces vs Abstract Classes

While both interfaces and abstract classes are used for abstraction, they have some key differences:

1. **Multiple Inheritance**
    - Interfaces support multiple inheritance, a class can implement multiple interfaces
    - A class can extend only one abstract class

2. **State**
    - Interfaces cannot have state (instance variables), except for static final variables
    - Abstract classes can have state (instance variables)

3. **Constructor**
    - Interfaces cannot have constructors
    - Abstract classes can have constructors

4. **Method Implementation**
    - All methods in an interface are implicitly public and abstract (except default and static methods in Java 8+)
    - Abstract classes can have abstract and non-abstract methods

5. **Purpose**
    - Interfaces are used to define a contract or capability
    - Abstract classes are used to define a base class with some common functionality

Example comparing interface and abstract class:

```java
interface Flyable {
    void fly();
}

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}

public class AnimalExample {
    public static void main(String[] args) {
        Bird sparrow = new Bird("Sparrow");
        sparrow.makeSound(); // From abstract class
        sparrow.eat(); // From abstract class
        sparrow.fly(); // From interface
    }
}
```

## Conclusion

Functional interfaces are a key feature in Java's support for functional programming. They provide a way to use lambda expressions and method references, making the code more concise and expressive. While similar to regular interfaces, their single abstract method constraint makes them ideal for use with lambda expressions.

Understanding the difference between interfaces (including functional interfaces) and abstract classes is crucial for designing flexible and maintainable Java applications. Each has its own use cases, and the choice between them depends on the specific requirements of your design.