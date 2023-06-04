//1. Write a program to demonstrate method overloading with 3 different parameters .
public class MethodOverloading{
    
    public void printData(int num) {
        System.out.println("Printing integer: " + num);
    }
    
    public void printData(double num) {
        System.out.println("Printing double: " + num);
    }
    
    public void printData(String text) {
        System.out.println("Printing string: " + text);
    }
    
    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();
        
        obj.printData(10);
        obj.printData(3.14);
        obj.printData("Rudra Prasad !");
    }
}
//2.Write a program to create an object of an class which contain a method and call that class method in main method .
public class MyClass {
    
    public void myMethod() {
        System.out.println("Hello from RudraPrasad!");
    }
    
    public static void main(String[] args) {
        MyClass Obj = new MyClass(); 
        
        Obj.myMethod(); 
    }
}

//3.Write a java program to calculate the sum of all element in an integer array ?
public class ArraySum {
    
   static int calcSum(int[] arr) {
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        int sum = calcSum(numbers);
        
        System.out.println("The sum of the array elements is: " + sum);
    }
}

//4.Write a java program to find the index of a specific element  in an integer array ?
public class ArrayIndex {
    
     
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 3;
        
        int index = findIndex(numbers, target);
        
        if (index != -1) {
            System.out.println("The element " + target + " is found at index " + index);
          }  else {
            System.out.println("The element " + target + " is not found in the array.");
               }   
    }
        static int findIndex(int[] arr, int target) {
              for (int i = 0; i < arr.length; i++) {
                  if (arr[i] == target) {
                      return i; 
                  }
              }
               return -1; 
    }
}
//Write a java program to print an entire array ?

public class Rudra {   
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("The array elements are :");
        printArray(nums);
    }
  static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(); 
}



