### 1. What is Inheritance in Java?
      -Inheritance is a mechanism by which one class can access the properties (methods and fields) of another class. 
      -It is one of the pillar of Object Orientation.
      -It always speaks about reusability.
      -In java inheritance is achieved through "extends" keyword.
### 2. What is superclass and subclass ?
      -The class that inherits the properties is known as the subclass, and the class whose properties are inherited is known as the superclass 
### 3. How is Inheritance implemented/achieved in Java?
      -In java inheritance is achieved through "extends" keyword.
### 4. What is polymorphism ?
      -If one thing exists in more than one form then it is known as polymorphism.
      -It is two types. 
      1. CompileTime Polymorphism
      2. RunTime Polymorphism
### 5. Differentiate between method overloading and overriding.
       -Two or more methods is said to be Overloaded if both methods have same name but change in the argument type.
      -It is known as compile time polymorphism.

      -If SuperClass method implementation then SubClass is allow to redefine that SuperClass method in SubClass in its own way this process is called as method Overriding.
      -It is known as run time polymorphism.
      
### 6. What is an abstraction explained with an Example ?
      -Abstraction is a process of hiding implementation details and showing only functionality to the user.
      -It is one of the four fundamental OOP concepts.
      -Example :
                        abstract class AeroPlane
            {
                //abstract int age;
                
               abstract public void takeOff();
            
                abstract public void fly();
            
                public void landing()
                {
                    System.out.println("Aeroplane is landing");
                }
            }
            
            
            class CargoPlane extends AeroPlane
            {
                public void takeOff()
                {
                    System.out.println("CargoPlane requires longer runway");
                }
               public void fly()
               {
                System.out.println("Cargoplane flies at lower height");
               } 
               public void alert()
               {
                System.out.println("Alert..");
               } 
            }
            
            class PassengerPlane extends AeroPlane
            {
                public void takeOff()
                {
                    System.out.println("PassengerPlane requires medium size runway");
                }
                public void fly()
                {
                System.out.println("PassengerPlane flies at medium height");
                }
            }
            public class LaunchAbs 
            {
                public static void main(String[] args) 
                {
                        AeroPlane ref1=new CargoPlane();
                        ref1.takeOff();
                        ref1.fly();
                        ref1.landing();
                        ((CargoPlane) ref1).alert();
            
                        AeroPlane ref3=new PassengerPlane();
                        ref3.takeOff();
                        ref3.fly();
                        ref3.landing();
            
                       // AeroPlane3 ref=new AeroPlane3(); 
                    
                }
                
            }
      

### 7. What is the difference between an abstract method and final method in Java? Explain with an example.
      Abstract Method:

      -An abstract method is a method declared in an abstract class or interface but does not contain any implementation.
      -Example:
                        abstract class Shape {
                      abstract void draw(); // Abstract method
                  }
                  
                  class Circle extends Shape {
                      void draw() {
                          System.out.println("Drawing a circle");
                      }
                  }
                  
                  class Rectangle extends Shape {
                      void draw() {
                          System.out.println("Drawing a rectangle");
                      }
                  }
                  
                  public class Main {
                      public static void main(String[] args) {
                          Shape circle = new Circle();
                          circle.draw(); 
                  
                          Shape rectangle = new Rectangle();
                          rectangle.draw(); 
                      }
                  }
            Final Method:

            -A final method is a method that cannot be overridden by any subclass.
            -It is used to prevent the subclasses from changing the behavior of the method.
            -example:
                  class Parent {
                final void display() {
                    System.out.println("This is the Parent class");
                }
            }
            
            class Child extends Parent {
               
                      void display() {
                     System.out.println("This is the Child class"); // Attempting to override the final method will result in a compilation error
                 }
            }

            public class Main {
                public static void main(String[] args) {
                    Parent parent = new Parent();
                    parent.display();
            
                    Child child = new Child();
                    child.display(); 
                }
            }

            
### 8. What is the final class in Java?
      -If a class is marked as final, then it can not be participate in inheritance.
      -examples : String ,Integer , Short ,Float.......etc.

### 9. Difference between abstraction and encapsulation .
      -Abstraction is a process of hiding implementation details and showing only functionality to the user.
      -Binding of data member and method to a single unit is known as encapsulation.

### 10. Difference between Runtime and compile time polymorphism explain with an example.
      -Two or more methods is said to be Overloaded if both methods have same name but change in the argument type.
      -It is known as compile time polymorphism.

      -If SuperClass method implementation then SubClass is allow to redefine that SuperClass method in SubClass in its own way this process is called as method Overriding.
      -It is known as run time polymorphism.
