// 1. What is a Constructor ?
//     A constructor is a special member method in a class having same name in this particular class ,that is used to initialize the object of that class. It is called automatically when an object is created .
    
// 2. What is Constructor Chaining ?
//    Constructor chaining refers to the process in which a constructor is called from another constructor in the same class or superclass. this process is known as constructor chaining. 
   
// 3. Can we call a subclass constructor from a superclass constructor ?
//     No, we cannot directly call a subclass constructor from a superclass constructor. 
    
// 4. What happened if you keep a return type for a constructor ?
//     Constructors don't have return types . If we specify a return type for a constructor, it becomes a regular method instead of a constructor. It would not be invoked automatically when creating an object, and you would need to call it explicitly like any other method.
    
// 5. What is no-arg constructor ?
//     A no-arg constructor is a constructor that doesn't take any arguments. It is a constructor that can be called without passing any values, and it is provided by default if no other constructors are explicitly defined in the class.
    
// 6. How is a No-argument constructor different from the default Constructor ?
//   A no-argument constructor and a default constructor are the same . Both refer to a constructor that doesn't take any arguments and is provided by default if no other constructors are defined in the class. They are automatically invoked when creating an object without passing any values.
  
// 7. When do we need Constructor Overloading ?
//   It is used when we want to create multiple constructors in a class, each with a different set of parameters. It allows objects to be initialized with different values based on the arguments provided. Constructor overloading provides flexibility in creating objects with different initialization options without having to create separate methods.
  
// 8. What is Default constructor Explain with an example ?
//     A default constructor is a no-arg constructor that is automatically provided by the compiler if no other constructors are explicitly defined in a class. It initializes the object with it's default values for the data members.
// ex:
        public class PwSkill {
          private int javaBatch;
          private String Name;

          // Default constructor
          public PwSkill() {
              javaBatch = 0;//Default value
              Name = "";//Default value
          }
      }
