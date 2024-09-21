# Classes and Objects: Code Examples

## Basic Class Structure

```java
public class Car {
    // Fields
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Methods
    public void startEngine() {
        System.out.println("The " + make + " " + model + " engine is starting.");
    }

    public void drive() {
        System.out.println("Driving the " + year + " " + make + " " + model);
    }
}

// Usage
Car myCar = new Car("Toyota", "Corolla", 2022);
myCar.startEngine();
myCar.drive();
```

## Inheritance

```java
public class Vehicle {
    protected String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public void move() {
        System.out.println("The " + type + " is moving.");
    }
}

public class Bicycle extends Vehicle {
    public Bicycle() {
        super("Bicycle");
    }

    public void pedal() {
        System.out.println("Pedaling the bicycle.");
    }
}

// Usage
Bicycle myBike = new Bicycle();
myBike.move();
myBike.pedal();
```

## Encapsulation

```java
public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Usage
BankAccount account = new BankAccount();
account.deposit(1000);
account.withdraw(500);
System.out.println("Balance: $" + account.getBalance());
```

## Polymorphism

```java
public interface Shape {
    double getArea();
}

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
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

// Usage
Shape circle = new Circle(5);
Shape rectangle = new Rectangle(4, 6);

System.out.println("Circle area: " + circle.getArea());
System.out.println("Rectangle area: " + rectangle.getArea());
```

## Static Members

```java
public class MathUtils {
    public static final double PI = 3.14159;

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}

// Usage
System.out.println("PI: " + MathUtils.PI);
System.out.println("5 + 3 = " + MathUtils.add(5, 3));
System.out.println("4 * 7 = " + MathUtils.multiply(4, 7));
```

## Abstract Classes

```java
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// Usage
Dog myDog = new Dog("Buddy");
myDog.makeSound();
myDog.sleep();
```