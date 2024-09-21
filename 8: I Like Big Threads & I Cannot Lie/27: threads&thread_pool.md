# Programs, Processes, and Threads: Explained with Code

## 1. Program

A program is a set of instructions stored on disk. Here's a simple Java program:

```java
public class SimpleProgram {
    public static void main(String[] args) {
        System.out.println("This is a simple program.");
    }
}
```

This program becomes a process when it's executed.

## 2. Process

A process is a running instance of a program. Each process has its own memory space and resources. Here's an example of creating a new process in Java:

```java
import java.io.IOException;

public class ProcessExample {
    public static void main(String[] args) {
        try {
            // Start a new process (opens Notepad on Windows)
            Process process = Runtime.getRuntime().exec("notepad.exe");
            
            System.out.println("Notepad process started.");
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Notepad process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

In this example, we're creating a new process (Notepad) from within our Java program.

## 3. Thread

A thread is the smallest unit of execution within a process. Here's an example demonstrating multiple threads within a single process:

```java
public class ThreadExample {
    public static void main(String[] args) {
        // Main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Creating and starting a new thread
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: " + Thread.currentThread().getName());
        });
        thread1.start();

        // Creating and starting another thread
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: " + Thread.currentThread().getName());
        });
        thread2.start();
    }
}
```

This example shows three threads (main, thread1, and thread2) running within the same process.

## Key Differences Illustrated

### 1. Resource Allocation

Processes have separate memory spaces, while threads share memory:

```java
public class ResourceAllocationExample {
    private static int sharedVariable = 0;

    public static void main(String[] args) throws InterruptedException {
        // Two threads modifying the same variable
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedVariable++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sharedVariable++;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Shared Variable: " + sharedVariable);
        // Output will be less than 2000 due to race condition
    }
}
```

### 2. Creation and Management

Creating a process is more resource-intensive than creating a thread:

```java
public class CreationComparisonExample {
    public static void main(String[] args) {
        long startTime, endTime;

        // Measuring time to create a process
        startTime = System.nanoTime();
        try {
            Process process = Runtime.getRuntime().exec("notepad.exe");
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("Time to create and destroy a process: " + (endTime - startTime) + " ns");

        // Measuring time to create a thread
        startTime = System.nanoTime();
        Thread thread = new Thread(() -> {});
        thread.start();
        endTime = System.nanoTime();
        System.out.println("Time to create and start a thread: " + (endTime - startTime) + " ns");
    }
}
```

### 3. Communication

Inter-process communication is more complex than inter-thread communication:

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CommunicationExample {
    public static void main(String[] args) {
        // Inter-thread communication using a shared queue
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<>();

        Thread producer = new Thread(() -> {
            try {
                sharedQueue.put("Hello from producer thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                String message = sharedQueue.take();
                System.out.println("Consumer received: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

These examples illustrate the key concepts and differences between programs, processes, and threads. They show how threads within a process share resources and can communicate easily, while processes are more isolated and resource-intensive to create and manage.

## 1. Basic Thread Creation

### Using Thread Class

```java
public class BasicThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in a separate thread");
            }
        });
        thread.start();
    }
}
```

### Using Runnable Interface (Lambda Expression)

```java
public class RunnableLambdaExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Running with lambda"));
        thread.start();
    }
}
```

## 2. Multiple Threads

```java
public class MultipleThreadsExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int threadNumber = i;
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + threadNumber + " is running");
            });
            thread.start();
        }
    }
}
```

## 3. Thread States and Lifecycle

```java
public class ThreadLifecycleExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State after creation: " + thread.getState());
        thread.start();
        System.out.println("State after starting: " + thread.getState());
        Thread.sleep(1000);
        System.out.println("State while sleeping: " + thread.getState());
        thread.join();
        System.out.println("State after completion: " + thread.getState());
    }
}
```

## 4. Synchronization

### Synchronized Method

```java
public class SynchronizedMethodExample {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedMethodExample example = new SynchronizedMethodExample();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) example.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) example.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + example.count);
    }
}
```

### Synchronized Block

```java
public class SynchronizedBlockExample {
    private int count = 0;
    private Object lock = new Object();

    public void increment() {
        synchronized(lock) {
            count++;
        }
    }

    // Main method similar to SynchronizedMethodExample
}
```

## 5. Wait and Notify

```java
public class ProducerConsumerExample {
    private static Object lock = new Object();
    private static int[] buffer;
    private static int count;

    static class Producer {
        void produce() {
            synchronized (lock) {
                if (isFull(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }

    static class Consumer {
        void consume() {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) producer.produce();
        };
        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) consumer.consume();
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Buffer count: " + count);
    }
}
```

## 6. Thread Pools

### Fixed Thread Pool

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

### Cached Thread Pool

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

### Scheduled Thread Pool

```java
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Repeated task executed at " + System.currentTimeMillis());
        }, 0, 2, TimeUnit.SECONDS);
        
        executor.schedule(() -> {
            System.out.println("One-time task executed after delay");
            executor.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
```

## 7. Callable and Future

```java
import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return ThreadLocalRandom.current().nextInt(100);
        };

        Future<Integer> future1 = executor.submit(task);
        Future<Integer> future2 = executor.submit(task);

        System.out.println("Future 1 result: " + future1.get());
        System.out.println("Future 2 result: " + future2.get());

        executor.shutdown();
    }
}
```

## 8. CompletableFuture

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);

        combinedFuture.thenAccept(System.out::println);

        // Keep the main thread alive
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

These examples cover a wide range of threading concepts in Java, from basic thread creation to advanced concepts like thread pools, synchronization, and asynchronous programming with CompletableFuture. Each example demonstrates a different aspect of multithreading and concurrent programming in Java.