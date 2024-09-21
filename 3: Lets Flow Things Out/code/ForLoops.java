public class ForLoops {
    public static void main(String[] args) {
        // Basic for loop: Counts from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }

        System.out.println("\n--- Next Example ---\n");

        // Reverse for loop: Counts backwards from 5 to 1
        for (int i = 5; i > 0; i--) {
            System.out.println("Reverse count: " + i);
        }

        System.out.println("\n--- Next Example ---\n");

        // Iterating over an array
        int[] numbers = {2, 4, 6, 8, 10};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        System.out.println("\n--- Next Example ---\n");

        // Nested for loops: Creates a triangle pattern
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n--- Next Example ---\n");

        // Infinite for loop with sleep: Counts for 3 seconds, then sleeps
        long startTime = System.currentTimeMillis();
        long count = 0;
        for (;;) { // Infinite loop
            count++;
            if (System.currentTimeMillis() - startTime >= 300) {
                System.out.println("Count reached: " + count);
                break;
            }
        }

        System.out.println("\n--- Next Example ---\n");

        // Multiple counters in for loop
        for (int i = 1, j = 10; i <= 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
    }
}
