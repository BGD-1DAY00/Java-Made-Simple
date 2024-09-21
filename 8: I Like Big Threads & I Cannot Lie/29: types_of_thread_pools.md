# Java Thread Pools: Types, Usage, and Comparison

Thread pools in Java provide a way to manage and reuse threads efficiently. They are part of the `java.util.concurrent` package and are created using the `Executors` factory methods.

## Types of Thread Pools

### 1. Fixed Thread Pool

**Definition**: A thread pool with a fixed number of threads.

**Usage**:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

**When to use**:
- When you have a bounded number of parallel tasks
- For CPU-intensive tasks where you want to limit the number of concurrent threads

### 2. Cached Thread Pool

**Definition**: A thread pool that creates new threads as needed and reuses idle threads.

**Usage**:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

**When to use**:
- For short-lived asynchronous tasks
- When you have a varying number of tasks with unpredictable execution times

### 3. Scheduled Thread Pool

**Definition**: A thread pool that can schedule tasks to run after a delay or periodically.

**Usage**:
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

**When to use**:
- For tasks that need to run periodically
- When you need to schedule tasks to run after a delay

### 4. Single Thread Executor

**Definition**: A thread pool with a single thread executing tasks sequentially.

**Usage**:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

**When to use**:
- When tasks need to be executed sequentially
- To replace the use of synchronized methods for thread safety

### 5. Work-Stealing Pool (Java 8+)

**Definition**: A thread pool that uses a work-stealing algorithm for load balancing.

**Usage**:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();
        
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
```

**When to use**:
- For computationally intensive tasks
- When you have a large number of tasks with varying execution times

## Comparison and Selection Criteria

1. **Fixed Thread Pool**
    - Pros: Controlled resource usage, good for CPU-bound tasks
    - Cons: May lead to thread starvation if all threads are busy

2. **Cached Thread Pool**
    - Pros: Flexible, good for I/O-bound tasks or short-lived tasks
    - Cons: Can lead to resource exhaustion if too many threads are created

3. **Scheduled Thread Pool**
    - Pros: Good for recurring tasks or delayed execution
    - Cons: Not suitable for long-running tasks as it can delay other scheduled tasks

4. **Single Thread Executor**
    - Pros: Ensures sequential execution, thread-safe
    - Cons: Limited parallelism, can become a bottleneck

5. **Work-Stealing Pool**
    - Pros: Efficient for recursive, divide-and-conquer tasks
    - Cons: Overhead in managing work-stealing queues

## Selection Guidelines

- Use **Fixed Thread Pool** when you know the optimal number of threads needed.
- Use **Cached Thread Pool** for a large number of short-lived tasks.
- Use **Scheduled Thread Pool** for recurring tasks or tasks that need to start after a delay.
- Use **Single Thread Executor** when tasks must be executed sequentially.
- Use **Work-Stealing Pool** for computationally intensive tasks that can be broken down into smaller subtasks.

Remember, the choice of thread pool depends on your specific use case, the nature of your tasks, and your system's resources. Always monitor and tune your thread pools based on actual performance metrics.