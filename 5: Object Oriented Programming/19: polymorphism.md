# Polymorphism in Java: Concepts and Examples

## Introduction to Polymorphism

Polymorphism is a core concept in object-oriented programming that allows objects of different types to be treated as objects of a common super type. The word "polymorphism" means "many forms".

Key aspects of polymorphism in Java:
1. Compile-time (static) polymorphism: Method overloading
2. Runtime (dynamic) polymorphism: Method overriding
3. Allows for more flexible and reusable code
4. Enables implementing a single interface for multiple data types

Now, let's explore these concepts with code examples.

## 1. Method Overloading (Compile-time Polymorphism)

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));           // Outputs: 15
        System.out.println(calc.add(5.5, 10.5));       // Outputs: 16.0
        System.out.println(calc.add("Hello", "World")); // Outputs: HelloWorld
    }
}
```

## 2. Method Overriding (Runtime Polymorphism)

```java
class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows");
    }
}

public class AnimalSound {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound();  // Outputs: The dog barks
        animal2.makeSound();  // Outputs: The cat meows
    }
}
```

## 3. Interface-based Polymorphism

```java
interface Shape {
    double getArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class ShapeArea {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        printArea(circle);     // Outputs: Area: 78.53981633974483
        printArea(rectangle);  // Outputs: Area: 24.0
    }
}
```

## 4. Polymorphic Collections

```java
import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    @Override
    public String toString() {
        return name + " - Salary: $" + salary + ", Bonus: $" + calculateBonus();
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.2;
    }
}

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.1;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Manager("Alice", 80000));
        employees.add(new Developer("Bob", 70000));
        employees.add(new Manager("Charlie", 90000));
        employees.add(new Developer("David", 75000));

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
```

## 5. Polymorphism with Generics

```java
class Box<T> {
    private T content;

    public void put(T item) {
        this.content = item;
    }

    public T get() {
        return content;
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.put(10);
        System.out.println("Integer Value: " + intBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.put("Hello Polymorphism");
        System.out.println("String Value: " + stringBox.get());
    }
}
```

These examples demonstrate different aspects of polymorphism in Java:
1. Method overloading (compile-time polymorphism)
2. Method overriding (runtime polymorphism)
3. Interface-based polymorphism
4. Polymorphic collections
5. Polymorphism with generics

Polymorphism allows for more flexible, reusable, and extensible code by enabling objects of different types to be treated uniformly when they share a common supertype or interface.