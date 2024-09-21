# Java Arrays and Collections: Detailed Examples

## Arrays

### 1. Basic Array Operations

```java
// Initializing arrays
int[] numbers = {1, 2, 3, 4, 5};
String[] fruits = new String[3];
fruits[0] = "Apple";
fruits[1] = "Banana";
fruits[2] = "Cherry";

// Accessing elements
System.out.println("Third number: " + numbers[2]);
System.out.println("Second fruit: " + fruits[1]);

// Array length
System.out.println("Number of fruits: " + fruits.length);

// Iterating over an array
for (int i = 0; i < numbers.length; i++) {
    System.out.print(numbers[i] + " ");
}
System.out.println();

// Enhanced for loop
for (String fruit : fruits) {
    System.out.print(fruit + " ");
}
System.out.println();
```

### 2. Multidimensional Arrays

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Accessing elements
System.out.println("Element at matrix[1][2]: " + matrix[1][2]);

// Iterating over 2D array
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

### 3. Array Utility Methods

```java
import java.util.Arrays;

int[] numbers = {5, 2, 8, 1, 9};

// Sorting
Arrays.sort(numbers);
System.out.println("Sorted array: " + Arrays.toString(numbers));

// Binary search
int index = Arrays.binarySearch(numbers, 8);
System.out.println("Index of 8: " + index);

// Fill
int[] filledArray = new int[5];
Arrays.fill(filledArray, 10);
System.out.println("Filled array: " + Arrays.toString(filledArray));

// Copy
int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
System.out.println("Copied array: " + Arrays.toString(copiedArray));

// Compare
boolean isEqual = Arrays.equals(numbers, copiedArray);
System.out.println("Arrays are equal: " + isEqual);
```

## Collections

### 1. ArrayList

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> list = new ArrayList<>();

// Adding elements
list.add("Apple");
list.add("Banana");
list.add("Cherry");
System.out.println("List: " + list);

// Accessing elements
System.out.println("Second element: " + list.get(1));

// Modifying elements
list.set(1, "Blueberry");
System.out.println("Modified list: " + list);

// Removing elements
list.remove("Cherry");
System.out.println("After removal: " + list);

// Size
System.out.println("Size of list: " + list.size());

// Checking if empty
System.out.println("Is list empty? " + list.isEmpty());

// Sorting
Collections.sort(list);
System.out.println("Sorted list: " + list);

// Clearing the list
list.clear();
System.out.println("Cleared list: " + list);
```

### 2. LinkedList

```java
import java.util.LinkedList;

LinkedList<Integer> linkedList = new LinkedList<>();

// Adding elements
linkedList.add(3);
linkedList.addFirst(1);
linkedList.addLast(5);
linkedList.add(1, 2);
System.out.println("LinkedList: " + linkedList);

// Accessing elements
System.out.println("First element: " + linkedList.getFirst());
System.out.println("Last element: " + linkedList.getLast());

// Removing elements
linkedList.removeFirst();
linkedList.removeLast();
System.out.println("After removal: " + linkedList);

// Using as a Queue
linkedList.offer(4);  // Add to the tail
System.out.println("After offer: " + linkedList);
System.out.println("Polled element: " + linkedList.poll());  // Remove and return the head
System.out.println("After poll: " + linkedList);
```

### 3. HashSet

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();

// Adding elements
set.add("Apple");
set.add("Banana");
set.add("Cherry");
set.add("Apple");  // Duplicate, won't be added
System.out.println("HashSet: " + set);

// Checking for an element
System.out.println("Contains Banana? " + set.contains("Banana"));

// Removing an element
set.remove("Cherry");
System.out.println("After removal: " + set);

// Size
System.out.println("Size of set: " + set.size());

// Iterating over a set
for (String fruit : set) {
    System.out.println(fruit);
}
```

### 4. HashMap

```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();

// Adding key-value pairs
map.put("Apple", 40);
map.put("Banana", 30);
map.put("Cherry", 50);
System.out.println("HashMap: " + map);

// Accessing values
System.out.println("Price of Banana: " + map.get("Banana"));

// Checking if a key exists
System.out.println("Contains Apple? " + map.containsKey("Apple"));

// Updating a value
map.put("Apple", 45);
System.out.println("Updated price of Apple: " + map.get("Apple"));

// Removing a key-value pair
map.remove("Cherry");
System.out.println("After removal: " + map);

// Iterating over a map
for (String key : map.keySet()) {
    System.out.println(key + " costs " + map.get(key));
}
```

### 5. TreeSet (Sorted Set)

```java
import java.util.TreeSet;

TreeSet<Integer> treeSet = new TreeSet<>();

// Adding elements
treeSet.add(5);
treeSet.add(2);
treeSet.add(8);
treeSet.add(1);
System.out.println("TreeSet: " + treeSet);  // Automatically sorted

// First and last elements
System.out.println("First element: " + treeSet.first());
System.out.println("Last element: " + treeSet.last());

// Removing elements
treeSet.remove(2);
System.out.println("After removal: " + treeSet);

// Subset operations
System.out.println("Subset [1, 5]: " + treeSet.subSet(1, 6));
System.out.println("Headset < 5: " + treeSet.headSet(5));
System.out.println("Tailset >= 5: " + treeSet.tailSet(5));
```

These examples demonstrate various operations on arrays and different types of collections in Java. They cover initialization, adding/removing elements, accessing elements, sorting, searching, and other collection-specific operations. Each example is designed to showcase the unique features and use cases of the respective data structure.