# Conditional Statements in Java

## Table of Contents
1. [Introduction](#introduction)
2. [if Statement](#if-statement)
3. [if-else Statement](#if-else-statement)
4. [if-else-if Ladder](#if-else-if-ladder)
5. [Nested if Statements](#nested-if-statements)
6. [switch Statement](#switch-statement)
7. [Best Practices](#best-practices)

## Introduction

Conditional statements in Java allow you to execute different blocks of code based on specified conditions. They are fundamental to controlling the flow of your program.

## if Statement

The `if` statement is the most basic form of conditional statement.

Syntax:
```java
if (condition) {
    // code to be executed if condition is true
}
```

Example:
```java
int age = 20;
if (age >= 18) {
    System.out.println("You are an adult.");
}
```

## if-else Statement

The `if-else` statement provides an alternative execution path when the condition is false.

Syntax:
```java
if (condition) {
    // code to be executed if condition is true
} else {
    // code to be executed if condition is false
}
```

Example:
```java
int age = 15;
if (age >= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are a minor.");
}
```

## if-else-if Ladder

The `if-else-if` ladder allows you to check multiple conditions.

Syntax:
```java
if (condition1) {
    // code to be executed if condition1 is true
} else if (condition2) {
    // code to be executed if condition2 is true
} else if (condition3) {
    // code to be executed if condition3 is true
} else {
    // code to be executed if all conditions are false
}
```

Example:
```java
int score = 75;
if (score >= 90) {
    System.out.println("A grade");
} else if (score >= 80) {
    System.out.println("B grade");
} else if (score >= 70) {
    System.out.println("C grade");
} else {
    System.out.println("Failed");
}
```

## Nested if Statements

You can place an `if` statement inside another `if` statement to create nested conditions.

Example:
```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("You can drive.");
    } else {
        System.out.println("You need a license to drive.");
    }
} else {
    System.out.println("You are too young to drive.");
}
```

## switch Statement

The `switch` statement allows you to select one of many code blocks to be executed.

Syntax:
```java
switch (expression) {
    case value1:
        // code
        break;
    case value2:
        // code
        break;
    ...
    default:
        // code
}
```

Example:
```java
int day = 4;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    case 6:
        System.out.println("Saturday");
        break;
    case 7:
        System.out.println("Sunday");
        break;
    default:
        System.out.println("Invalid day");
}
```

## Best Practices

1. Keep conditions simple and readable.
2. Use curly braces `{}` even for single-line blocks to improve readability and prevent errors.
3. Consider using `switch` statements when you have multiple conditions based on a single variable.
4. Avoid deep nesting of conditional statements as it reduces code readability.
5. Use meaningful variable names in your conditions to make the code self-explanatory.
6. Consider using the ternary operator (`?:`) for simple if-else statements.

Conditional statements are crucial for creating dynamic and responsive programs. They allow your code to make decisions and execute different paths based on various conditions.