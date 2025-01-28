1. **Program to display the current date and time in Java**
   ```java
   import java.time.*;

   public class DateTime {
       public static void main(String[] args) {
           LocalDate date = LocalDate.now();
           System.out.println(date);
           LocalTime time = LocalTime.now();
           System.out.println(time);
       }
   }
   ```
   **Output:**
   ```
   javac DateTime.java
   java DateTime
   2023-03-30
   ```

2. **Write a program to convert a date to a string in the format "MM/dd/yyyy"**
   ```java
   import java.time.LocalDate;
   import java.time.format.DateTimeFormatter;

   public class DateToString {
       public static void main(String[] args) {
           LocalDate date = LocalDate.of(2023, 4, 4);
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
           String formattedDate = date.format(formatter);
           System.out.println("Formatted Date: " + formattedDate);
       }
   }
   ```
   **Output:**
   ```
   javac DateToString.java
   java DateToString
   Formatted Date: 04/04/2023
   ```

3. **What is the difference between collections and streams? Explain with an example**

   **Streams:**
   - They don't store data; instead, they operate on the source data structure (e.g., a collection).
   - Streams use functional interfaces like lambda expressions, making them a good fit for functional programming.
   - Streams are consumable, meaning once traversed, they need to be recreated for further use.
   - They support both sequential and parallel processing.
   - Streams are iterated internally by simply mentioning the operations to be performed.

   **Collections:**
   - Collections hold all the data that the data structure currently has (e.g., Set, List, Map).
   - They do not use functional interfaces by default.
   - Collections are non-consumable, meaning they can be traversed multiple times without recreating.
   - They support parallel processing and can be highly performant.
   - Collections are iterated externally using loops.

   **Example of Collections:**
   ```java
   import java.util.*;

   class Main {
       public static void main(String[] args) {
           List<String> companyList = new ArrayList<>();
           companyList.add("Google");
           companyList.add("Apple");
           companyList.add("Microsoft");

           Comparator<String> com = (String o1, String o2) -> o1.compareTo(o2);
           Collections.sort(companyList, com);

           for (String name : companyList) {
               System.out.println(name);
           }
       }
   }
   ```
   **Output:**
   ```
   Apple
   Google
   Microsoft
   ```

   **Example of Streams:**
   ```java
   import java.util.*;

   class Demo {
       public static void main(String[] args) {
           List<String> companyList = new ArrayList<>();
           companyList.add("Google");
           companyList.add("Apple");
           companyList.add("Microsoft");

           companyList.stream().sorted().forEach(System.out::println);
       }
   }
   ```
   **Output:**
   ```
   Apple
   Google
   Microsoft
   ```

4. **What is enums in Java? Explain with an example**

   **Ans:** Enums in Java are used to define a group of named constants. They represent a collection of related constants that have a common purpose. Each constant in an enum is an instance of the enum type and is typically defined as a public static final field.

   ```java
   public class EnumDemo {
       public enum DayOfWeek {
           MONDAY,
           TUESDAY,
           WEDNESDAY,
           THURSDAY,
           FRIDAY,
           SATURDAY,
           SUNDAY
       }

       public static void main(String[] args) {
           for (DayOfWeek day : DayOfWeek.values()) {
               System.out.println(day);
           }
       }
   }
   ```
   **Output:**
   ```
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY
   ```

5. **What are built-in annotations in Java?**
   
   **Ans:** Some of the built-in annotations in Java include:
   - `@Override`
   - `@Deprecated`
   - `@SuppressWarnings`
   - `@FunctionalInterface`
   - `@Retention`
   - `@Target`
   - `@Documented`
   - `@Inherited`

   These annotations provide additional information to the Java compiler and other tools, improving code readability, maintainability, and safety by enforcing specific rules and behaviors in Java code.