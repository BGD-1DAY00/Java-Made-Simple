# Inheritance and Interfaces: Code Examples

## Basic Inheritance

```java
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println(name + " is barking.");
    }
}

// Usage
Dog myDog = new Dog("Buddy");
myDog.eat();   // Inherited method
myDog.bark();  // Dog-specific method
```

## Method Overriding

```java
class Shape {
    public double getArea() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Usage
Shape shape = new Circle(5);
System.out.println("Area: " + shape.getArea());
```

## Multiple Inheritance (Using Interfaces)

```java
interface Swimmer {
    void swim();
}

interface Flyer {
    void fly();
}

class Duck implements Swimmer, Flyer {
    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }
}

// Usage
Duck duck = new Duck();
duck.swim();
duck.fly();
```

## Abstract Classes

```java
abstract class Vehicle {
    protected String type;

    public Vehicle(String type) {
        this.type = type;
    }

    abstract void start();

    public void stop() {
        System.out.println(type + " is stopping.");
    }
}

class Car extends Vehicle {
    public Car() {
        super("Car");
    }

    @Override
    void start() {
        System.out.println("Car is starting the engine.");
    }
}

// Usage
Car myCar = new Car();
myCar.start();
myCar.stop();
```

## Interface Default Methods

```java
interface Logger {
    void log(String message);

    default void logInfo(String info) {
        log("INFO: " + info);
    }

    default void logError(String error) {
        log("ERROR: " + error);
    }
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

// Usage
Logger logger = new ConsoleLogger();
logger.logInfo("Operation successful");
logger.logError("An error occurred");
```

## Interface Static Methods

```java
interface MathOperations {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

// Usage
System.out.println("5 + 3 = " + MathOperations.add(5, 3));
System.out.println("5 - 3 = " + MathOperations.subtract(5, 3));
```

## Functional Interfaces

```java
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

// Usage with lambda expression
Greeting casualGreeting = name -> System.out.println("Hey, " + name + "!");
casualGreeting.greet("Alice");

// Usage with method reference
Greeting formalGreeting = System.out::println;
formalGreeting.greet("Hello, Bob!");
```

## Inheritance and Interfaces Combined

```java
interface Drawable {
    void draw();
}

abstract class GeometricShape {
    protected String color;

    public GeometricShape(String color) {
        this.color = color;
    }

    abstract double getArea();
}

class Square extends GeometricShape implements Drawable {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " square.");
    }

    @Override
    double getArea() {
        return side * side;
    }
}

// Usage
Square square = new Square("red", 5);
square.draw();
System.out.println("Area: " + square.getArea());
```