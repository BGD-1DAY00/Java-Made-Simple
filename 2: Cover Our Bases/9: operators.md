# Comprehensive Guide to Operators in Java

## Table of Contents
1. [Introduction to Operators](#introduction-to-operators)
2. [Arithmetic Operators](#arithmetic-operators)
3. [Relational Operators](#relational-operators)
4. [Logical Operators](#logical-operators)
5. [Bitwise Operators](#bitwise-operators)
6. [Assignment Operators](#assignment-operators)
7. [Unary Operators](#unary-operators)
8. [Ternary Operator](#ternary-operator)
9. [Operator Precedence](#operator-precedence)
10. [Special Considerations](#special-considerations)

## Introduction to Operators

Operators in Java are special symbols that perform specific operations on one, two, or three operands, and then return a result. They are essential for performing operations on variables and values.

## Arithmetic Operators

Arithmetic operators are used to perform common mathematical operations.

| Operator | Description    | Example     |
|----------|----------------|-------------|
| +        | Addition       | a + b       |
| -        | Subtraction    | a - b       |
| *        | Multiplication | a * b       |
| /        | Division       | a / b       |
| %        | Modulus        | a % b       |

Example:
```java
int a = 10, b = 3;
System.out.println(a + b);  // 13
System.out.println(a - b);  // 7
System.out.println(a * b);  // 30
System.out.println(a / b);  // 3 (integer division)
System.out.println(a % b);  // 1
```

## Relational Operators

Relational operators are used to compare two values.

| Operator | Description              | Example |
|----------|--------------------------|---------|
| ==       | Equal to                 | a == b  |
| !=       | Not equal to             | a != b  |
| >        | Greater than             | a > b   |
| <        | Less than                | a < b   |
| >=       | Greater than or equal to | a >= b  |
| <=       | Less than or equal to    | a <= b  |

Example:
```java
int a = 10, b = 20;
System.out.println(a == b);  // false
System.out.println(a != b);  // true
System.out.println(a > b);   // false
System.out.println(a < b);   // true
```

## Logical Operators

Logical operators are used to determine the logic between variables or values.

| Operator | Description | Example  |
|----------|-------------|----------|
| &&       | Logical AND | a && b   |
| \|\|     | Logical OR  | a \|\| b |
| !        | Logical NOT | !a       |

Example:
```java
boolean a = true, b = false;
System.out.println(a && b);  // false
System.out.println(a || b);  // true
System.out.println(!a);      // false
```

## Bitwise Operators

Bitwise operators are used to perform operations on individual bits.

| Operator | Description          | Example |
|----------|----------------------|---------|
| &        | Bitwise AND          | a & b   |
| \|       | Bitwise OR           | a \| b  |
| ^        | Bitwise XOR          | a ^ b   |
| ~        | Bitwise Complement   | ~a      |
| <<       | Left Shift           | a << 1  |
| >>       | Right Shift          | a >> 1  |
| >>>      | Unsigned Right Shift | a >>> 1 |

Example:
```java
int a = 5, b = 3;
System.out.println(a & b);   // 1
System.out.println(a | b);   // 7
System.out.println(a ^ b);   // 6
System.out.println(~a);      // -6
System.out.println(a << 1);  // 10
System.out.println(a >> 1);  // 2
```

## Assignment Operators

Assignment operators are used to assign values to variables.

| Operator | Description                | Example |
|----------|----------------------------|---------|
| =        | Simple assignment          | a = 5   |
| +=       | Add and assign             | a += 5  |
| -=       | Subtract and assign        | a -= 5  |
| *=       | Multiply and assign        | a *= 5  |
| /=       | Divide and assign          | a /= 5  |
| %=       | Modulus and assign         | a %= 5  |
| &=       | Bitwise AND and assign     | a &= 5  |
| \|=      | Bitwise OR and assign      | a \|= 5 |
| ^=       | Bitwise XOR and assign     | a ^= 5  |
| <<=      | Left shift and assign      | a <<= 2 |
| >>=      | Right shift and assign     | a >>= 2 |
| >>>=     | Unsigned right shift and assign | a >>>= 2 |

Example:
```java
int a = 10;
a += 5;  // equivalent to a = a + 5
System.out.println(a);  // 15
```

## Unary Operators

Unary operators require only one operand.

| Operator | Description          | Example |
|----------|----------------------|---------|
| +        | Unary plus           | +a      |
| -        | Unary minus          | -a      |
| ++       | Increment            | a++ or ++a |
| --       | Decrement            | a-- or --a |
| !        | Logical complement   | !a      |

Example:
```java
int a = 10;
System.out.println(+a);   // 10
System.out.println(-a);   // -10
System.out.println(a++);  // 10 (post-increment)
System.out.println(++a);  // 12 (pre-increment)
```

## Ternary Operator

The ternary operator is the only Java operator that takes three operands.

Syntax: `condition ? expression1 : expression2`

Example:
```java
int a = 10, b = 20;
int max = (a > b) ? a : b;
System.out.println(max);  // 20
```

## Operator Precedence

Operators have different precedence levels. Operators with higher precedence are evaluated first.

Here's a simplified precedence table (from highest to lowest):

1. Postfix operators (expr++, expr--)
2. Unary operators (++expr, --expr, +expr, -expr, ~, !)
3. Multiplicative (*, /, %)
4. Additive (+, -)
5. Shift (<<, >>, >>>)
6. Relational (<, >, <=, >=, instanceof)
7. Equality (==, !=)
8. Bitwise AND (&)
9. Bitwise XOR (^)
10. Bitwise OR (|)
11. Logical AND (&&)
12. Logical OR (||)
13. Ternary (?:)
14. Assignment (=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=)

## Special Considerations

1. **Integer Division**: When dividing two integers, the result is always an integer (fractional part is truncated).
   ```java
   System.out.println(5 / 2);  // 2, not 2.5
   ```

2. **Floating-Point Precision**: Be cautious when comparing floating-point numbers due to precision issues.
   ```java
   System.out.println(0.1 + 0.2 == 0.3);  // false, due to floating-point precision
   ```

3. **Short-Circuit Evaluation**: For `&&` and `||`, Java uses short-circuit evaluation. In `a && b`, if `a` is false, `b` is not evaluated.

4. **Increment/Decrement**: Be aware of the difference between prefix and postfix increment/decrement.
   ```java
   int a = 5;
   System.out.println(a++);  // Prints 5, then a becomes 6
   System.out.println(++a);  // a becomes 7, then prints 7
   ```

5. **Bitwise vs. Logical Operators**: `&` and `|` are bitwise operators and always evaluate both operands, while `&&` and `||` are logical operators and may short-circuit.

Understanding operators and their behavior is crucial for writing efficient and correct Java code. Always consider the types of your operands and be aware of potential pitfalls like integer division and floating-point precision issues.