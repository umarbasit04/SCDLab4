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

**Guided walkthrough:**
- `CollectionManager` (package `CollectionsLab`) — as given in the manual: safely
  removes subjects starting with "6." using an `Iterator`, and exposes an
  unmodifiable view via `getReadOnlySubjects()`.

**Lab Tasks (4):**
1. `StringPerformance` — `buildString(int n)` (immutable `String` concatenation) vs
   `buildStringBuilder(int n)` (`StringBuilder.append`), with execution time measured
   and printed for n = 10000 to observe the O(n²) cost of repeated String copying.
2. `CourseManager` — `removeCourse6Buggy()` demonstrates `ConcurrentModificationException`
   when removing from a `List` during a for-each loop; `removeCourse6Fixed()` fixes it
   with `Iterator.remove()`, leaving only `["8.03", "14.03"]`.
3. `TreasureMap` — a `HashMap<String, Double>` of treasures; `updatePalmValue()` updates
   `"palm"` to its current value plus the map's size; `getTotalValue()` sums all values
   via a for-each loop over `treasures.values()`.
4. `Zoo` — wraps a mutable animal list with `Collections.unmodifiableList()`; attempting
   `add("flamingo")` on the returned list throws `UnsupportedOperationException`.

**Homework (2):**
1. `StudentDirectory` — a `Map<Integer, String>` of student IDs to names;
   `getAllIDs()` returns the key set wrapped with `Collections.unmodifiableSet()` so
   callers cannot add/remove IDs through it.
2. `Point` — a fully immutable class (see reflection below).

## Reflection: Why Immutable `Point` Is Safer and Easier to Understand
`Point` is declared `final` (so no subclass can override its behavior and add
mutation), its `x` and `y` fields are `final` and set only once in the constructor,
and there are no setter methods. This makes it safer from bugs because once a `Point`
is created, its state can never change — no other part of the program can accidentally
(or intentionally) alter its coordinates out from under code that's holding a reference
to it, which eliminates a whole class of bugs caused by shared mutable state / pointer
aliasing (e.g., two variables referring to the same object where one method's change
silently affects another). It's easier to understand because a reader never has to
trace through the codebase looking for places that might modify a `Point` — its value
is fixed at construction, so reasoning about it is local: you only need to look at the
constructor call to know everything about that object for its whole lifetime.

## How to Run the Code
- **In NetBeans:** open the project (File > Open Project, select the folder containing
  `pom.xml`), then right-click the project → **Run**.
- **From the command line:** `mvn compile`

## How to Run the Tests
- **In NetBeans:** right-click the project → **Test**, or right-click an individual
  test class → **Test File**.
- **From the command line:** `mvn test`

## Testing
JUnit 5 (Jupiter) was used for all test classes, covering normal cases, boundary/edge
cases, and exceptional cases (`assertThrows` for `ConcurrentModificationException` and
`UnsupportedOperationException`). `StringPerformanceTest` also prints timing output for
n = 10000 to the console for manual observation, since exact timings are
machine-dependent and aren't asserted as pass/fail.

## Author
[Student Name] – [Registration Number]

## Course
Software Construction and Development, 5th Semester Software Engineering,
UET Abbottabad Campus. Instructor: Engr. Rizwan Shah.
