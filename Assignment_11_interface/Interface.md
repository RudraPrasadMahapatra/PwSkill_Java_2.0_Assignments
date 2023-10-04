### 1. What is an interface in Java?
    -Any service requirement is called an interface.
    -It's a class blueprint containing static constants and abstract methods.
    -An interface can be considered as a contract between the class and the outside world. It specifies what a class must do but not how it does it. 

### 2. Which modifiers are allowed for methods in an interface? explain with an example
    In Java, methods declared within an interface have a few allowed modifiers:
    public: All interface methods are implicitly public, and we can explicitly declare also.
    abstract: Interface methods are inherently abstract, so there's no need to use the abstract modifier, but it's allowed.
    default: We can provide a default implementation for a method in an interface using the default keyword.
    static: We can declare static methods within an interface.

### 3. What is the use of the interface in Java? Or, why do we use an interface in java ?
    -We use an interface in Java to achieve abstraction and multiple inheritance.

### 4. What is the difference between abstract class and interface in Java ?
    -Abstract class:- It is preferred when we speak only about partial implementation.
    -Interface:- It is preferred when we speak only about specification.
