# Java Stream API: Introduction and Comprehensive Examples

## Introduction to Streams

Streams were introduced in Java 8 (released in March 2014) as part of the project lambda. They provide a declarative approach to processing collections of objects.

Key points about streams:
- Allow functional-style operations on streams of elements
- Can be used with arrays or collections
- Support both sequential and parallel execution
- Are lazily evaluated
- Do not modify the original data source
- Designed for easier and more efficient data processing

Streams solve several problems:
1. Simplify bulk operations on collections
2. Enable functional programming paradigms in Java
3. Facilitate parallel processing of data
4. Improve code readability and reduce boilerplate code

Now, let's dive into examples demonstrating the power and versatility of the Stream API.

```java
import java.util.*;
import java.util.stream.*;

public class StreamAPIExamples {
    public static void main(String[] args) {
        // Sample data
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 28)
        );

        // Filtering
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Mapping
        List<String> upperCaseWords = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase words: " + upperCaseWords);

        // Flatmap
        List<List<Integer>> nestedNumbers = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedNumbers = nestedNumbers.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println("Flattened numbers: " + flattenedNumbers);

        // Sorting
        List<String> sortedWords = words.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted words: " + sortedWords);

        // Distinct
        List<Integer> distinctNumbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5)
            .stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        // Limit and Skip
        List<Integer> limitedNumbers = numbers.stream()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("Limited numbers: " + limitedNumbers);

        List<Integer> skippedNumbers = numbers.stream()
            .skip(5)
            .collect(Collectors.toList());
        System.out.println("Skipped numbers: " + skippedNumbers);

        // Reduce
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // Min and Max
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println("Min: " + min.orElse(0) + ", Max: " + max.orElse(0));

        // Count
        long count = words.stream()
            .filter(w -> w.length() > 5)
            .count();
        System.out.println("Words longer than 5 characters: " + count);

        // Any/All/None Match
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 5);
        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        boolean noneMatch = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Any > 5: " + anyMatch + ", All > 0: " + allMatch + ", None < 0: " + noneMatch);

        // ForEach
        numbers.stream().forEach(System.out::print);
        System.out.println();

        // Collect to Map
        Map<String, Integer> nameToAge = people.stream()
            .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("Name to Age Map: " + nameToAge);

        // GroupingBy
        Map<Integer, List<Person>> peopleByAge = people.stream()
            .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("People grouped by age: " + peopleByAge);

        // Partitioning
        Map<Boolean, List<Integer>> partitionedNumbers = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n > 5));
        System.out.println("Numbers partitioned by > 5: " + partitionedNumbers);

        // Joining
        String joinedWords = words.stream()
            .collect(Collectors.joining(", "));
        System.out.println("Joined words: " + joinedWords);

        // Parallel Streams
        long parallelSum = numbers.parallelStream()
            .reduce(0, Integer::sum);
        System.out.println("Parallel sum: " + parallelSum);

        // Custom Collector
        String customCollected = words.stream()
            .collect(StringBuilder::new,
                     (sb, str) -> sb.append(str.charAt(0)),
                     StringBuilder::append)
            .toString();
        System.out.println("Custom collected: " + customCollected);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
```

This comprehensive example demonstrates various Stream API operations, showcasing the power and flexibility of streams in Java.