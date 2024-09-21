# Java Virtual Threads: Explained

## What are Virtual Threads?

Virtual threads are lightweight threads that are managed by the Java runtime rather than the operating system.

```java
Thread virtualThread = Thread.ofVirtual().start(() -> {
    System.out.println("Running in a virtual thread");
});
```

## Why are they lightweight?

1. **Memory Efficiency**:
    - Platform threads require a large, fixed stack (often 1MB).
    - Virtual threads use a much smaller stack (typically a few KB).

2. **Scheduling**:
    - Platform threads are scheduled by the OS.
    - Virtual threads are scheduled by the JVM, reducing context-switching overhead.

## Where are they stored?

- Virtual threads are stored in the Java heap, not in OS resources.
- Their stacks can grow and shrink dynamically.

```java
// This creates millions of virtual threads without exhausting system resources
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 1_000_000; i++) {
        executor.submit(() -> {
            Thread.sleep(Duration.ofSeconds(1));
            return i;
        });
    }
}
```

## Why is it possible?

1. **JVM-managed scheduling**:
    - The JVM can efficiently multiplex many virtual threads onto a smaller number of OS threads.

2. **Continuation-based**:
    - Virtual threads use continuations, allowing them to pause and resume execution efficiently.

3. **Heap allocation**:
    - By storing thread state in the heap, Java can manage millions of threads within the memory limits of the JVM.

## Key Advantages

1. **Scalability**: Handle millions of concurrent operations.
2. **Simplicity**: Write straightforward sequential code that runs concurrently.
3. **Performance**: Efficient for I/O-bound tasks.

```java
// Example: Handling many concurrent HTTP requests
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (String url : urls) {
        executor.submit(() -> fetchUrl(url));
    }
}
```

## Limitations

- Not suitable for CPU-bound tasks (use platform threads for these).
- Requires Java 21+ for full support (preview in Java 19 and 20).

Virtual threads make it possible to write highly concurrent applications using a familiar thread-per-task model, without the limitations of traditional threading models.

# Java Virtual Threads Example

This example demonstrates the use of virtual threads and compares them with platform threads:

```java
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsExample {

    // Simulates a task that involves some computation and I/O
    private static void task(String taskType) {
        System.out.println(taskType + " task started by " + Thread.currentThread());
        try {
            // Simulate some work
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        int taskCount = 10_000;

        // Using platform threads
        long startTimePlatform = System.currentTimeMillis();
        try (var executor = Executors.newFixedThreadPool(200)) {
            IntStream.range(0, taskCount).forEach(i -> 
                executor.submit(() -> task("Platform"))
            );
        }
        long endTimePlatform = System.currentTimeMillis();
        System.out.println("Platform threads took: " + (endTimePlatform - startTimePlatform) + "ms");

        // Using virtual threads
        long startTimeVirtual = System.currentTimeMillis();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, taskCount).forEach(i -> 
                executor.submit(() -> task("Virtual"))
            );
        }
        long endTimeVirtual = System.currentTimeMillis();
        System.out.println("Virtual threads took: " + (endTimeVirtual - startTimeVirtual) + "ms");
    }
}
```

What's happening here:

1. We define a `task` method that simulates some work (computation and I/O).
2. We create two scenarios: one using platform threads and another using virtual threads.
3. For platform threads, we use a fixed thread pool with 200 threads.
4. For virtual threads, we use `Executors.newVirtualThreadPerTaskExecutor()`.
5. We submit 10,000 tasks to each executor and measure the time taken.

Why this is useful:
- Virtual threads are lightweight and can be created in large numbers (millions).
- They're especially beneficial for I/O-bound tasks where threads spend a lot of time waiting.
- Virtual threads allow writing concurrent code in a familiar thread-per-task style while scaling to a large number of concurrent operations.

Key points:
- Virtual threads are managed by the JVM, not the OS, reducing overhead.
- They're best for I/O-bound tasks; for CPU-bound tasks, platform threads might still be preferable.
- The API for using virtual threads is very similar to platform threads, making adoption easier.

Note: To run this code, you need Java 21 or later. If using Java 19 or 20, you need to enable preview features.