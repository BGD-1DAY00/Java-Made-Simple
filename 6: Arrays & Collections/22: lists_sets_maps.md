# Java Collections: Lists, Sets, and Maps with Examples

## Lists

Lists are ordered collections that allow duplicate elements. The main implementations are ArrayList and LinkedList.

### ArrayList Examples

```java
import java.util.*;

public class ArrayListExamples {
    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Fruits: " + fruits);

        // Adding at a specific index
        fruits.add(1, "Blueberry");
        System.out.println("After adding Blueberry: " + fruits);

        // Accessing elements
        String secondFruit = fruits.get(1);
        System.out.println("Second fruit: " + secondFruit);

        // Updating an element
        fruits.set(0, "Apricot");
        System.out.println("After updating: " + fruits);

        // Removing an element
        fruits.remove("Cherry");
        System.out.println("After removing Cherry: " + fruits);

        // Checking if an element exists
        boolean containsBanana = fruits.contains("Banana");
        System.out.println("Contains Banana? " + containsBanana);

        // Getting the size
        int size = fruits.size();
        System.out.println("Size of the list: " + size);

        // Iterating over the list
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // Sorting the list
        Collections.sort(fruits);
        System.out.println("Sorted fruits: " + fruits);

        // Clearing the list
        fruits.clear();
        System.out.println("After clearing: " + fruits);
    }
}
```

### LinkedList Examples

```java
import java.util.*;

public class LinkedListExamples {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("Numbers: " + numbers);

        // Adding at the beginning and end
        numbers.addFirst(5);
        numbers.addLast(40);
        System.out.println("After adding to start and end: " + numbers);

        // Removing from the beginning and end
        int first = numbers.removeFirst();
        int last = numbers.removeLast();
        System.out.println("Removed first: " + first + ", last: " + last);
        System.out.println("After removal: " + numbers);

        // Using as a queue
        numbers.offer(50);  // Add to the tail
        System.out.println("After offer: " + numbers);
        int head = numbers.poll();  // Remove and return the head
        System.out.println("Polled: " + head);
        System.out.println("After poll: " + numbers);

        // Peeking at elements
        System.out.println("First element: " + numbers.peekFirst());
        System.out.println("Last element: " + numbers.peekLast());
    }
}
```

## Sets

Sets are collections that cannot contain duplicate elements. The main implementations are HashSet, LinkedHashSet, and TreeSet.

### HashSet Examples

```java
import java.util.*;

public class HashSetExamples {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();

        // Adding elements
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red");  // This won't be added as it's a duplicate
        System.out.println("Colors: " + colors);

        // Checking if an element exists
        boolean hasYellow = colors.contains("Yellow");
        System.out.println("Contains Yellow? " + hasYellow);

        // Removing an element
        colors.remove("Green");
        System.out.println("After removing Green: " + colors);

        // Size of the set
        System.out.println("Size of the set: " + colors.size());

        // Iterating over the set
        for (String color : colors) {
            System.out.println("Color: " + color);
        }

        // Clearing the set
        colors.clear();
        System.out.println("Is set empty? " + colors.isEmpty());
    }
}
```

### TreeSet Examples

```java
import java.util.*;

public class TreeSetExamples {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        // Adding elements
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        System.out.println("Numbers: " + numbers);  // Note: automatically sorted

        // First and last elements
        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());

        // Lower and higher
        System.out.println("Lower than 3: " + numbers.lower(3));
        System.out.println("Higher than 3: " + numbers.higher(3));

        // Subset operations
        System.out.println("Subset [2, 8]: " + numbers.subSet(2, 9));
        System.out.println("Headset < 5: " + numbers.headSet(5));
        System.out.println("Tailset >= 5: " + numbers.tailSet(5));

        // Removing elements
        numbers.remove(2);
        System.out.println("After removing 2: " + numbers);

        // Polling first and last
        System.out.println("Poll first: " + numbers.pollFirst());
        System.out.println("Poll last: " + numbers.pollLast());
        System.out.println("After polling: " + numbers);
    }
}
```

## Maps

Maps are objects that map keys to values. The main implementations are HashMap, LinkedHashMap, and TreeMap.

### HashMap Examples

```java
import java.util.*;

public class HashMapExamples {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        // Adding key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);
        System.out.println("Ages: " + ages);

        // Accessing a value
        int bobAge = ages.get("Bob");
        System.out.println("Bob's age: " + bobAge);

        // Checking if a key exists
        boolean hasAlice = ages.containsKey("Alice");
        System.out.println("Has Alice? " + hasAlice);

        // Checking if a value exists
        boolean hasAge30 = ages.containsValue(30);
        System.out.println("Has age 30? " + hasAge30);

        // Updating a value
        ages.put("Alice", 26);
        System.out.println("After updating Alice's age: " + ages);

        // Removing a key-value pair
        ages.remove("Charlie");
        System.out.println("After removing Charlie: " + ages);

        // Iterating over the map
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue() + " years old");
        }

        // Getting all keys
        Set<String> names = ages.keySet();
        System.out.println("Names: " + names);

        // Getting all values
        Collection<Integer> ageValues = ages.values();
        System.out.println("Age values: " + ageValues);

        // Clearing the map
        ages.clear();
        System.out.println("Is map empty? " + ages.isEmpty());
    }
}
```

### TreeMap Examples

```java
import java.util.*;

public class TreeMapExamples {
    public static void main(String[] args) {
        TreeMap<String, Double> grades = new TreeMap<>();

        // Adding key-value pairs
        grades.put("Alice", 3.8);
        grades.put("Bob", 3.5);
        grades.put("Charlie", 3.9);
        grades.put("David", 3.7);
        System.out.println("Grades: " + grades);  // Note: keys are automatically sorted

        // First and last entries
        System.out.println("First entry: " + grades.firstEntry());
        System.out.println("Last entry: " + grades.lastEntry());

        // Lower and higher entries
        System.out.println("Lower entry than Bob: " + grades.lowerEntry("Bob"));
        System.out.println("Higher entry than Bob: " + grades.higherEntry("Bob"));

        // Subset operations
        System.out.println("Subset [Bob, David): " + grades.subMap("Bob", "David"));
        System.out.println("Headmap until Charlie: " + grades.headMap("Charlie"));
        System.out.println("Tailmap from Charlie: " + grades.tailMap("Charlie"));

        // Removing entries
        grades.remove("David");
        System.out.println("After removing David: " + grades);

        // Polling first and last entries
        Map.Entry<String, Double> firstEntry = grades.pollFirstEntry();
        Map.Entry<String, Double> lastEntry = grades.pollLastEntry();
        System.out.println("Polled first: " + firstEntry + ", last: " + lastEntry);
        System.out.println("After polling: " + grades);
    }
}
```

These examples demonstrate a wide range of operations for Lists (ArrayList and LinkedList), Sets (HashSet and TreeSet), and Maps (HashMap and TreeMap). They cover creation, adding elements, removing elements, accessing elements, checking for existence, iterating, and various collection-specific operations.