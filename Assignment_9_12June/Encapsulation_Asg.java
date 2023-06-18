/*
  1. What is Encapsulation in Java ? Why is it called Data hiding ?
    Binding of data and corresponding methods into a single unit is called Encapsulation . It is called data hiding because encapsulation allows the data mambers of an object to be hidden from other classes, preventing direct access to them. Instead, access to the data is provided through methods, which are known as getters and setters method.
*/

/*
  2. What are importance features of Encapsulation ?
    Importance features of Encapsulation is Data hiding and abstraction .
*/

/*
  3. What are gatter and setter method in Java Explain with an example ?
    // */
    //   Getter and setter methods, also known as accessor and mutator methods. These are used to       access and modify the private data members  of a class, respectively.
    // ex:
    //   A setter method allows us to modify the value of private mambers of class by accepting a new value as a parameter .
        public class Student {
        private String name;

        public void setName(String newName) {
            name = newName;
        }
    }

    //   A getter method returns the value of private mamber of a class .

        public class Student {
            private String name;

            public String getName() {
                return name;
            }
        }



//   4. What is the use of this keyword Explain with an example ?
//         This 'this' keyword is used to reference to the current object within a class .it is commonly used for avoid shawoding problem.
  Ex:
    public class Student {
    private String name;

    public Person(String name) {
      //here  class member and local variables name is same , so local variable have more preference ,Therefore we use this keyword.
        this.name = name; 
    }

    public void printName() {
        System.out.println("Name: " + this.name);
    }
}


/*
   5. What is advantages of Encapsulation ?
   a. it gives more data security.
   b. enhancement becomes easy.
   c. it hides data from other class.
  
*/


// 6. How to achieve encapsulation in java ? Give an example.

//     to achieve encapsulation in java we simply follow these steps :
//     step-1 : Declare the instance variables of class as private. Which is restricts direct access to the variable from outside the class.
        public class Student {
        private String name;
        private int age;
    }
//   step-2 :Provide public setter and getter method to access and modify the private variables.
      public class Student {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String newName) {
            name = newName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int newAge) {
            age = newAge;
        }
    }
//   step-3 : Use gatter and setter method to access and modify the private variables instead of directly accessing them.
        public class Main {
        public static void main(String[] args) {
            Student s1 = new Student();
            s1.setName("John");
            s1.setAge(25);

            System.out.println("Name: " + s1.getName());
            System.out.println("Age: " + s1.getAge());
        }
    }
    //By encapsulating the variables and providing public methods to access them, the internal implementation details of the Student class are hidden from the outside world,and  promoting data hiding and ensuring data integrity. Other classes can interact with the Student class through its public interface, making the code more maintainable, reusable, and flexible.



