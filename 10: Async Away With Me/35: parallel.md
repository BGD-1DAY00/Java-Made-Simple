# Java Parallel Processing Example

This example demonstrates parallel processing using Java's Stream API:

```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelProcessingExample {

    // Simulate a time-consuming operation
    private static int expensiveOperation(int num) {
        try {
            Thread.sleep(10); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return num * 2;
    }

    public static void main(String[] args) {
        int[] numbers = IntStream.rangeClosed(1, 100).toArray();

        // Sequential processing
        long startSeq = System.currentTimeMillis();
        int[] resultSeq = Arrays.stream(numbers)
                                .map(ParallelProcessingExample::expensiveOperation)
                                .toArray();
        long endSeq = System.currentTimeMillis();
        System.out.println("Sequential Time: " + (endSeq - startSeq) + "ms");

        // Parallel processing
        long startParallel = System.currentTimeMillis();
        int[] resultParallel = Arrays.stream(numbers)
                                     .parallel()
                                     .map(ParallelProcessingExample::expensiveOperation)
                                     .toArray();
        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel Time: " + (endParallel - startParallel) + "ms");

        // Verify results are the same
        System.out.println("Results match: " + Arrays.equals(resultSeq, resultParallel));
    }
}
```

What's happening here:

1. We create an array of numbers from 1 to 100.
2. The `expensiveOperation` method simulates a time-consuming task.
3. We process the array sequentially using `Arrays.stream()`.
4. We then process the same array in parallel using `Arrays.stream().parallel()`.
5. We measure and compare the time taken for both approaches.

Why this is useful:
- Parallel processing can significantly speed up computations on multi-core processors.
- It's especially beneficial for CPU-intensive tasks on large datasets.
- The Stream API makes it easy to switch between sequential and parallel processing.

Note: The actual performance gain depends on the number of cores available and the nature of the task. Not all operations benefit from parallelization, especially if they are I/O bound or if the overhead of splitting and merging the work outweighs the benefits.