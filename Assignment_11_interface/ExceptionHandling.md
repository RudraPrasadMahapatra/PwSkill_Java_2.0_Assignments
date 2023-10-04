### 1. Explain different types of Errors in java ?
    - In Java, errors are abnormal conditions that occur at runtime and are typically beyond the control of the programmer.
    The main types of errors in Java are:
    Compile-Time Errors: These errors occur during the compilation of your code. Examples include syntax errors, type mismatches, and missing class definitions.
    Runtime Errors (Exceptions): These are errors that occur during the execution of a Java program. They can be further categorized into checked exceptions and unchecked 
     exceptions.
### 2. What is an Exception in java ?
    -An unwanted that disturbs the normal flow of execution of program is called "Exception".
    
### 3. How can you handle exceptions in java ? explain with an example
    -In java we can handle the exceptions using try , catch and optionally using finally blocks.
   
   ```
 Example :-
  try {
       int result = 10 / 0; //risky code
   } catch (ArithmeticException e) {
       System.out.println("An arithmetic exception occurred: " + e.getMessage());
   } finally {
       System.out.println("Finally block executed.");
   }
   ```
    
### 4. Why do we need exception handling in Java?
    -Handle unexpected errors gracefully.
    -Provide a better user experience.
    -Make code more robust and maintainable.
    
### 5. What is the difference between exception and error in Java?
     Exceptions: Most of the cases exceptions are caused by our program and these are recoverable.
     Error: Most of the case errors are not caused by our program and these are due to a lack of system resources and are not recoverable .
    
### 6. Name the different types of exceptions in Java ?
   There are two main categories of exceptions in Java:
   - **Checked Exceptions:** These are exceptions that must be either caught using a `try-catch` block or declared in the method's signature using the `throws` keyword. Examples include `IOException` and `SQLException`.
   - **Unchecked Exceptions (RuntimeExceptions):** These are exceptions that are not checked at compile-time, and you are not required to catch or declare them. Examples include `NullPointerException` and `ArrayIndexOutOfBoundsException`.

### 7. Can we just try instead of finally and catch blocks?
    - If we write only try block instead of finally and catch blocks then we will get CompileTimeError called try without catch or finally.
