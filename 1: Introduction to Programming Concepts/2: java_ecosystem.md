# Introduction to Java and its ecosystem

Java is a popular, versatile, object-oriented programming language known for its "write once, run anywhere" capability.

### Key features of Java:
1. **Platform Independence**: Java code can run on any device with a Java Virtual Machine (JVM).
2. **Object-Oriented**: It's based on the concept of "objects" that contain data and code.
3. **Rich Standard Library**: Java comes with a comprehensive set of standard libraries.
4. **Security**: Java has built-in security features and is designed to be safe for network/internet use.


### Java Ecosystem:

1. **Java Development Kit (JDK)**:
    - What does a development kit mean?
        - It's an assortment of different software tools and libraries bundled together to enable Java development functionality.
    - The core component for developing Java applications.
    - Includes the Java compiler (`javac`), Java Runtime Environment (JRE), and other tools (additional libraries and development utilities).

   **Example of using JDK**:
   Let's create and compile a simple Java program using JDK tools:

    ```
    // 1. Create a file named HelloJDK.java
    public class HelloJDK {
        public static void main(String[] args) {
            System.out.println("Hello from JDK!");
        }
    }

    // 2. Open a terminal and navigate to the directory containing HelloJDK.java

    // 3. Compile the program using javac (part of JDK)
    javac HelloJDK.java

    // 4. This creates a HelloJDK.class file

    // 5. Run the compiled program
    java HelloJDK

    // Output: Hello from JDK!
    ```

   In this example, we use `javac` (the Java compiler included in JDK) to compile our source code and `java` to run the compiled bytecode.

2. **Java Runtime Environment (JRE)**:
    - Needed to run Java applications.
    - Includes the Java Virtual Machine (JVM) and core libraries.
    - It's a subset of JDK, containing everything necessary to run compiled Java programs.

   **Example of using JRE**:
   Let's run a pre-compiled Java program using only the JRE:

    ```
    // Assume we have a compiled HelloJRE.class file

    // 1. Open a terminal and navigate to the directory containing HelloJRE.class

    // 2. Run the compiled program using the 'java' command (part of JRE)
    java HelloJRE

    // Output: Hello from JRE!
    ```

   In this example, we only need the JRE to run the pre-compiled `.class` file. We don't need the compiler or other development tools included in the JDK.

   Key difference: With JRE alone, you can run Java programs, but you can't compile Java source code (`.java` files) into bytecode (`.class` files). For that, you need the JDK.


3. **Integrated Development Environments (IDEs)**:
    - Popular Java IDEs include Eclipse, IntelliJ IDEA, and NetBeans.
    - They provide tools for easier Java development, debugging, and testing.

   **Why use IntelliJ, NetBeans, or Eclipse over other IDEs?**

   These IDEs are specifically tailored for Java development and offer several advantages:

   a) **Intelligent Code Assistance**:
    - Advanced code completion
    - Real-time error detection and quick fixes
    - Automated refactoring tools

   b) **Integrated Build and Run Tools**:
    - Compile and run Java programs with a single click
    - Seamless integration with build tools like Maven and Gradle

   c) **Powerful Debugging**:
    - Set breakpoints, step through code, and inspect variables easily
    - Visual debugging tools for multi-threaded applications

   d) **Project Management**:
    - Organize large codebases into projects and modules
    - Manage dependencies efficiently

   e) **Ecosystem Integration**:
    - Built-in support for version control systems (e.g., Git)
    - Integration with popular frameworks and libraries

   f) **Customization and Plugins**:
    - Extensive plugin ecosystems to extend functionality
    - Customizable to fit individual or team preferences

   While you can write Java code in any text editor, these specialized IDEs significantly enhance productivity and code quality for Java developers.

4. **Build Tools**:
    - Maven and Gradle are popular for managing dependencies and building projects.

   **What is a build tool and what is its purpose?**

   A build tool is a program that automates the process of creating executable applications from source code. It's an essential part of modern software development, especially for large or complex projects.

   **Purpose of build tools:**

   a) **Dependency Management**:
    - Automatically download and manage external libraries
    - Ensure consistent versions across development environments

   b) **Build Automation**:
    - Compile source code
    - Run tests
    - Package applications (e.g., creating JAR files)

   c) **Project Structure**:
    - Define and maintain a standard project structure
    - Make it easier for developers to understand and navigate projects

   d) **Task Automation**:
    - Run custom tasks (e.g., generating documentation, deploying to servers)

   e) **Multi-module Projects**:
    - Manage complex projects with multiple sub-components

   **Example: Maven vs. Gradle**

    1. Maven:
        - Uses XML for configuration (pom.xml)
        - Follows a rigid, opinionated structure
        - Example pom.xml snippet:
          ```xml
          <project>
            <modelVersion>4.0.0</modelVersion>
            <groupId>com.example</groupId>
            <artifactId>my-app</artifactId>
            <version>1.0-SNAPSHOT</version>
            <dependencies>
              <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
              </dependency>
            </dependencies>
          </project>
          ```

    2. Gradle:
        - Uses a Groovy or Kotlin DSL for configuration
        - More flexible and concise than Maven
        - Example build.gradle snippet:
          ```groovy
          plugins {
              id 'java'
          }
          
          group 'com.example'
          version '1.0-SNAPSHOT'
          
          repositories {
              mavenCentral()
          }
          
          dependencies {
              testImplementation 'junit:junit:4.12'
          }
          ```

   Both tools serve the same primary purposes but differ in their approach and syntax. The choice between them often comes down to project requirements and team preferences.


### Example: Using Java ecosystem components

1. Write a Java program:
   ```java
   // HelloJava.java
   public class HelloJava {
       public static void main(String[] args) {
           System.out.println("Hello, Java Ecosystem!");
       }
   }
   ```

2. Compile using JDK:
   ```
   javac HelloJava.java
   ```

3. Run using JRE:
   ```
   java HelloJava
   ```

# Your First Java Project: Requirements and Learning Objectives

## Project Requirements

- Set up a Java development environment on your computer
  - Download intellij community edition: https://www.jetbrains.com/idea/download/?section=mac
  - Create a new Java project using an IDE of your choice
  - Write a Java program that does the following:
     - Takes user input from the console
     - Performs at least one calculation or data manipulation
     - Outputs the result to the console

## What You Should Learn

- How to research and install necessary software for Java development
- The process of setting up a Java project from scratch
- Basic Java syntax and programming concepts - use previous examples
- Understanding and implementing user input/output in Java
- The concept of libraries and how to integrate them into your project
- Problem-solving skills and how to find answers to coding questions online
- How to define and evaluate "DONE" for yourself 


