# Java Exception Handling: Try-Catch Blocks and Exception Propagation

## Basic Try-Catch Structure

```java
try {
    // Code that may throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

## Multiple Catch Blocks

```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]); // ArrayIndexOutOfBoundsException
            int result = 10 / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index problem: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic problem: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic exception: " + e.getMessage());
        }
    }
}
```

## Catching Multiple Exceptions in One Block (Java 7+)

```java
public class MultiCatchExample {
    public static void main(String[] args) {
        try {
            // Code that may throw different exceptions
        } catch (IOException | SQLException e) {
            System.out.println("An I/O or SQL error occurred: " + e.getMessage());
        }
    }
}
```

## Try-With-Resources (Java 7+)

```java
public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

## Exception Propagation

Exception propagation occurs when an exception is thrown in a method and not caught, causing it to be passed up the call stack.

```java
public class ExceptionPropagationExample {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }

    public static void method1() throws Exception {
        method2();
    }

    public static void method2() throws Exception {
        method3();
    }

    public static void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
}
```

In this example, the exception is thrown in `method3`, propagates through `method2` and `method1`, and is finally caught in `main`.

## Custom Exception and Propagation

```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionPropagation {
    public static void main(String[] args) {
        try {
            processFile("myfile.txt");
        } catch (CustomException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        }
    }

    public static void processFile(String filename) throws CustomException {
        try {
            readFile(filename);
        } catch (IOException e) {
            throw new CustomException("Error processing file: " + e.getMessage());
        }
    }

    public static void readFile(String filename) throws IOException {
        throw new IOException("File not found: " + filename);
    }
}
```

This example shows how a checked `IOException` is caught and wrapped in a custom exception, which is then propagated up the call stack.

## Rethrowing Exceptions

```java
public class RethrowExample {
    public static void main(String[] args) {
        try {
            processData();
        } catch (Exception e) {
            System.out.println("Final handler: " + e.getMessage());
        }
    }

    public static void processData() throws Exception {
        try {
            riskyOperation();
        } catch (Exception e) {
            System.out.println("Logging error: " + e.getMessage());
            throw e; // Rethrowing the exception
        }
    }

    public static void riskyOperation() throws Exception {
        throw new Exception("Something went wrong");
    }
}
```

Here, the exception is caught, logged, and then rethrown to be handled further up the call stack.

## Finally Block

```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            riskyOperation();
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("This will always execute");
        }
    }

    public static void riskyOperation() throws Exception {
        throw new Exception("Risky operation failed");
    }
}
```

The `finally` block always executes, whether an exception is thrown or not.

These examples demonstrate various aspects of exception handling in Java, including:
1. Basic try-catch structure
2. Multiple catch blocks
3. Multi-catch syntax
4. Try-with-resources for automatic resource management
5. Exception propagation through multiple method calls
6. Custom exceptions and how they can be used in exception propagation
7. Rethrowing exceptions
8. The use of finally blocks

Exception handling allows for more robust and error-resistant code by providing mechanisms to deal with unexpected situations and errors in a controlled manner.