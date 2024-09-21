# Introduction to Programming Concepts in Java

## What is a program?

A program is a set of instructions that tells a computer how to perform a specific task. It's like a recipe for a computer, 
detailing step-by-step what needs to be done to achieve a desired outcome.

### Key characteristics of a program:
1. **Sequential**: Instructions are typically executed in order, from top to bottom.
2. **Precise**: Each instruction must be unambiguous and clearly defined.
3. **Finite**: A program has a beginning and an end.

### Example:
Here's a simple Java program that prints "Hello, World!" to the console:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

This program consists of:
- A class definition (`HelloWorld`)
- A main method (the entry point of the program)
- An instruction to print a message

## Program vs Process

While a program and a process are related, they are distinct concepts in computing.

### Program:
- A program is a passive entity: a set of instructions stored on disk.
- It's static and doesn't do anything until it's executed.
- Multiple processes can be created from the same program.

### Process:
- A process is an active entity: a program in execution.
- It's dynamic and represents the program actually running in memory.
- Each process has its own memory space, CPU time, and system resources.

### Example:
Consider a Java program saved as `Calculator.java`:

```java
public class Calculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println("Sum: " + (a + b));
    }
}
```

- The file `Calculator.java` is the program.
- When you compile and run this program, a process is created:
  ```
  javac Calculator.java
  java Calculator
  ```
- Each time you run `java Calculator`, a new process is created, even though it's the same program.

