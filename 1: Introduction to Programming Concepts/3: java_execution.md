# Java Program Execution: From Source Code to Runtime

## 1. Writing Java Source Code

Let's start with a simple program that demonstrates object creation, method calls, and different data types:

```java
// File: MainProgram.java
public class MainProgram {
    public static void main(String[] args) {
        // Create objects
        Calculator calc = new Calculator();
        StringManipulator strMan = new StringManipulator();

        // Perform calculations
        int sum = calc.add(5, 3);
        double product = calc.multiply(4.2, 2.5);

        // Manipulate strings
        String result = strMan.concatenate("Hello", "World");
        String uppercase = strMan.toUpperCase(result);

        // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Concatenated: " + result);
        System.out.println("Uppercase: " + uppercase);
    }
}

// File: Calculator.java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }
}

// File: StringManipulator.java
public class StringManipulator {
    public String concatenate(String str1, String str2) {
        return str1 + " " + str2;
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
```

## 2. Compilation Process

When we compile the program using `javac MainProgram.java`, the Java compiler:

1. Parses the source code and checks for syntax errors.
2. Generates separate `.class` files for each class: `MainProgram.class`, `Calculator.class`, and `StringManipulator.class`.

Each `.class` file contains bytecode, a low-level representation of the program that the JVM can understand. For example, the bytecode for the `add` method in `Calculator` might look like:

```
public int add(int, int);
  Code:
     0: iload_1         // Load the first parameter onto the stack
     1: iload_2         // Load the second parameter onto the stack
     2: iadd            // Add the top two integers on the stack
     3: ireturn         // Return the result
```

## 3. Class Loading

The JVM dynamically loads, links, and initializes classes and interfaces. The class loading process involves:

### 3.1 Loading Phase

- Takes the binary representation (.class file) and creates a class or interface in memory.
- Java source code (.java files) is compiled into bytecode, stored in .class files.
- The JVM creates its own internal representation of the class or interface in memory, including:
    * The class's name and package
    * Its superclass
    * Implemented interfaces
    * Fields and methods
    * Constant pool - Where you're constants wil live 🖖

### 3.2 Class Loader Hierarchy

Java uses a hierarchical structure of class loaders:

1. **Bootstrap Class Loader**
    - Root of the class loader hierarchy
    - Written in native code (usually C++)
    - Loads core Java classes from `rt.jar` and other core libraries

2. **Extension Class Loader**
    - Child of the Bootstrap Class Loader
    - Loads classes from the ext (extension) directory

3. **Application Class Loader**
    - Child of the Extension Class Loader
    - Loads classes from the application's classpath

## 4. Linking

After loading, each class goes through the linking phase:

1. **Verification**: The bytecode is checked for correctness.
2. **Preparation**: Static fields are created and initialized to default values.
3. **Resolution**: Symbolic references are replaced with direct references (optional, can be done during execution).

## 5. Initialization

- Static initializers and static fields are executed/initialized.
- This is done by running a special method called `<clinit>` that the compiler creates.

## 6. Method Area and Heap Preparation

- The method area stores class structures, method code, and constant pool.
- The heap is prepared for object allocation.

## 7. Main Method Execution

The JVM starts executing the `main` method of `MainProgram`. This involves:

- Creating stack frames for method calls
- Allocating memory on the heap for objects
- Executing bytecode instructions

## 8. Garbage Collection

Throughout execution, the JVM's garbage collector:

- Marks objects that are no longer reachable
- Reclaims the memory of unmarked objects

## 9. JIT Compilation

As the program runs, the JVM's Just-In-Time (JIT) compiler may:

- Compile frequently executed bytecode to native machine code
- Store compiled native code in a code cache in the method area

## 10. Program Termination

When the `main` method completes:

1. The `main` method's stack frame is popped off.
2. The JVM initiates shutdown procedures:
    - Runs any registered shutdown hooks
    - Releases all loaded classes and their objects
    - Terminates the JVM process

## 11. Memory Management Throughout Execution

The JVM actively manages several memory areas:

- **Stack**: Stores method frames, local variables, and partial results
- **Heap**: Stores all objects, subject to garbage collection
- **Method Area**: Stores class structures, method code, and constant pool
- **PC Register**: Stores the address of the current instruction for each thread
- **Native Method Stack**: Used for native method invocations