# Java Asynchronous Programming and Concurrency: Annotated Code Examples

## Basic Thread Creation
Creating and starting a new thread:
```java
Thread thread = new Thread(() -> System.out.println("Hello from thread"));
thread.start();
```
Why: Allows executing code concurrently, improving performance for parallel tasks.

## Runnable and Callable
Two ways to define tasks for execution in threads:
```java
Runnable task = () -> System.out.println("I'm a Runnable");
new Thread(task).start();

Callable<String> call = () -> "I'm a Callable";
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(call);
System.out.println(future.get());
executor.shutdown();
```
Why: Runnable for tasks without return values, Callable for tasks that return results.

## CompletableFuture
Chaining asynchronous operations:
```java
CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Step 1")
    .thenApply(s -> s + " -> Step 2")
    .thenApply(s -> s + " -> Step 3");

System.out.println(cf.get());
```
Why: Enables composing asynchronous operations without blocking, improving responsiveness.

## ExecutorService
Managing a pool of threads for executing tasks:
```java
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Task 1"));
executor.submit(() -> System.out.println("Task 2"));
executor.shutdown();
```
Why: Reuses threads to reduce overhead of thread creation, manages concurrent task execution.

## Synchronization
Ensuring thread-safe access to shared resources:
```java
class Counter {
    private int count = 0;
    public synchronized void increment() { count++; }
    public synchronized int getCount() { return count; }
}
```
Why: Prevents race conditions when multiple threads access shared data.

## Lock
More flexible locking mechanism:
```java
class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```
Why: Provides more control over locking behavior than synchronized keyword.

## Atomic Variables
Thread-safe operations on single variables:
```java
AtomicInteger atomicInt = new AtomicInteger(0);
atomicInt.incrementAndGet();
```
Why: Enables lock-free, thread-safe operations on individual variables.

## BlockingQueue (Producer-Consumer)
Implementing producer-consumer pattern:
```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

// Producer
new Thread(() -> {
    for (int i = 0; i < 20; i++) {
        queue.put(i);
    }
}).start();

// Consumer
new Thread(() -> {
    while (true) {
        System.out.println(queue.take());
    }
}).start();
```
Why: Safely coordinates work between producer and consumer threads, handling synchronization automatically.

## CountDownLatch
Synchronizing multiple threads:
```java
CountDownLatch latch = new CountDownLatch(3);

for (int i = 0; i < 3; i++) {
    new Thread(() -> {
        System.out.println("Task executed");
        latch.countDown();
    }).start();
}

latch.await();
System.out.println("All tasks completed");
```
Why: Allows a thread to wait for completion of multiple other threads.

## CyclicBarrier
Synchronizing a set of threads at a common point:
```java
CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Barrier action"));

for (int i = 0; i < 3; i++) {
    new Thread(() -> {
        System.out.println("Thread waiting");
        barrier.await();
    }).start();
}
```
Why: Enables multiple threads to wait for each other to reach a common point before proceeding.

## ForkJoinPool
Efficiently executing recursive tasks:
```java
class SumTask extends RecursiveTask<Long> {
    private final long[] array;
    private final int start;
    private final int end;

    // Constructor...

    @Override
    protected Long compute() {
        if (end - start <= 1000) {
            long sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        }
        int mid = (start + end) / 2;
        SumTask left = new SumTask(array, start, mid);
        SumTask right = new SumTask(array, mid, end);
        left.fork();
        long rightResult = right.compute();
        long leftResult = left.join();
        return leftResult + rightResult;
    }
}

ForkJoinPool pool = new ForkJoinPool();
long[] numbers = new long[1000000];
SumTask task = new SumTask(numbers, 0, numbers.length);
Long sum = pool.invoke(task);
```
Why: Optimizes execution of divide-and-conquer algorithms, balancing work across available processors.

## CompletableFuture Composition
Combining results of multiple asynchronous computations:
```java
CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> s1 + " " + s2);

System.out.println(combined.get());
```
Why: Allows composition of independent asynchronous operations, improving efficiency and readability.