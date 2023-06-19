//4. Write a java program to call an method without creation an object of a class.

package com.company;

public class DirectCall {
   static void myMethod() {
        System.out.println("Hello, Rudra!");
    }

    public static void main(String[] args) {
        DirectCall.myMethod();
    }
}
