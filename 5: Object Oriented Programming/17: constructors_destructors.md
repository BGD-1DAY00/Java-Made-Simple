# Constructors and Destructors: Code Examples

## Basic Constructor

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("I'm " + name + ", " + age + " years old.");
    }
}

// Usage
Person person = new Person("Alice", 30);
person.introduce();
```

## Default Constructor

```java
public class Car {
    private String make;
    private String model;

    // Default constructor
    public Car() {
        make = "Unknown";
        model = "Unknown";
    }

    public void displayInfo() {
        System.out.println("Car: " + make + " " + model);
    }
}

// Usage
Car car = new Car();
car.displayInfo();
```

## Overloaded Constructors

```java
public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this(1, 1); // Calls the two-argument constructor
    }

    public Rectangle(double size) {
        this(size, size); // Square
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

// Usage
Rectangle r1 = new Rectangle();
Rectangle r2 = new Rectangle(5);
Rectangle r3 = new Rectangle(3, 4);

System.out.println("Areas: " + r1.getArea() + ", " + r2.getArea() + ", " + r3.getArea());
```

## Copy Constructor

```java
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Usage
Point p1 = new Point(10, 20);
Point p2 = new Point(p1);
System.out.println("p1: " + p1 + ", p2: " + p2);
```

## Constructor Chaining

```java
public class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name) {
        this(name, "Unassigned");
    }

    public Employee(String name, String department) {
        this(name, department, 0);
    }

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + department + " - $" + salary;
    }
}

// Usage
Employee e1 = new Employee("John");
Employee e2 = new Employee("Alice", "HR");
Employee e3 = new Employee("Bob", "IT", 50000);

System.out.println(e1);
System.out.println(e2);
System.out.println(e3);
```

## Destructor (Finalizer in Java)

```java
public class ResourceHandler {
    private String resource;

    public ResourceHandler(String resource) {
        this.resource = resource;
        System.out.println("Resource acquired: " + resource);
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Cleaning up resource: " + resource);
            // Cleanup code here
        } finally {
            super.finalize();
        }
    }
}

// Usage
new ResourceHandler("Database Connection");
System.gc(); // Suggest garbage collection (finalize may or may not be called immediately)
```

## Static Initializer Block

```java
public class DatabaseConfig {
    public static String url;
    public static String username;
    public static String password;

    static {
        System.out.println("Loading database configuration...");
        // Simulating loading from a config file
        url = "jdbc:mysql://localhost:3306/mydb";
        username = "user";
        password = "password";
    }
}

// Usage
System.out.println("DB URL: " + DatabaseConfig.url);
```