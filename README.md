# Lab Task 04 – Data Types, Mutability, and Collections

## Description
This repository contains the solution for **Lab Task 04: Data Types, Mutability, and
Collections** from the **Software Construction** course (5th Semester, Software
Engineering, UET Abbottabad). The lab covers static type checking, mutable vs.
immutable types, Java Collections (`List`, `Set`, `Map`), and safe iteration.

## Objective
Apply concepts of mutability, interface implementations (`List`, `Map`, `Set`), and
safe iterator traversal using Java Collections — and design a fully immutable class.

## Technologies Used
- Java 17
- Apache Maven
- NetBeans IDE (Maven project)
- JUnit 5 (Jupiter)

## Project Structure
```
DataTypesLab/
├── pom.xml
├── src/
│   ├── main/java/
│   │   ├── CollectionsLab/
│   │   │   └── CollectionManager.java   # Guided manual walkthrough (Iterator + unmodifiableList)
│   │   ├── labtasks/
│   │   │   ├── StringPerformance.java   # Lab Task 1 - String vs StringBuilder
│   │   │   ├── CourseManager.java       # Lab Task 2 - buggy vs fixed removal
│   │   │   ├── TreasureMap.java         # Lab Task 3 - HashMap manipulation
│   │   │   └── Zoo.java                 # Lab Task 4 - unmodifiable wrapper
│   │   └── homework/
│   │       ├── StudentDirectory.java    # Homework 1 - Map/Set tracking
│   │       └── Point.java               # Homework 2 - immutable class
│   └── test/java/            (mirrors the structure above)
└── README.md
```

## What Was Implemented

### **Lab Tasks**

**1. StringPerformance**

I implemented two methods to demonstrate the performance difference between String concatenation and StringBuilder:

buildString(int n) - uses immutable String concatenation in a loop, which creates a new String object each iteration. This has O(n²) time complexity due to repeated copying.
buildStringBuilder(int n) - uses StringBuilder.append() which mutates a single buffer, giving O(n) performance.
When running with n = 10000, you'll see the StringBuilder version is significantly faster. The execution time is printed for both methods so you can observe the quadratic cost of the naive String approach.

**2. CourseManager**

This class shows a common pitfall with Java Collections:

removeCourse6Buggy() - attempts to remove an element from a List while iterating with a for-each loop, which throws a ConcurrentModificationException.
removeCourse6Fixed() - demonstrates the correct approach using Iterator.remove(), which safely removes elements during iteration.
After running the fixed version, the list should contain only ["8.03", "14.03"].

**3. TreasureMap**

A simple treasure tracking system using HashMap<String, Double>:

updatePalmValue() - updates the value associated with the "palm" key by adding the current map size to its existing value.
getTotalValue() - calculates the sum of all treasure values by iterating over treasures.values().

**4. Zoo**

Demonstrates how to create an unmodifiable view of a collection:

The class wraps a mutable animal list with Collections.unmodifiableList().
When you try to call add("flamingo") on the returned list, it throws an UnsupportedOperationException, protecting the original list from unwanted modifications.

### **Homework Assignments**
**1. StudentDirectory**

A student ID to name mapping system that demonstrates defensive programming:

Uses Map<Integer, String> to store student records.
getAllIDs() returns the key set wrapped with Collections.unmodifiableSet(), preventing callers from adding or removing IDs through the returned reference while still allowing them to view the data.

**2. Point**

A fully immutable class implementation. The key characteristics include:

All fields are final
No setters or mutator methods
The class is marked final to prevent subclassing
Defensive copying in constructors and getters where applicable
Thread-safe by design

## How to Run the Code
- **In NetBeans:** open the project (File > Open Project, select the folder containing
  `pom.xml`), then right-click the project → **Run**.
- **From the command line:** 
```bash 
mvn compile
```

## How to Run the Tests
- **In NetBeans:** right-click the project → **Test**, or right-click an individual
  test class → **Test File**.
- **From the command line:** 
```bash
mvn test
```

## Testing
JUnit 5 (Jupiter) was used for all test classes, covering normal cases, boundary/edge
cases, and exceptional cases (`assertThrows` for `ConcurrentModificationException` and
`UnsupportedOperationException`). `StringPerformanceTest` also prints timing output for
n = 10000 to the console for manual observation, since exact timings are
machine-dependent and aren't asserted as pass/fail.

## Author
[Muhammad Umar Basit] – [24ABSWE0003]

## Course
Software Construction and Development, 5th Semester Software Engineering,
UET Abbottabad Campus. Instructor: Engr. Rizwan Shah.
