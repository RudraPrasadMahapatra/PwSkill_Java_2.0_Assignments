
//1. Create a class that keeps track of the number of instances created . Implement of static variable and method to accomplish this .
package com.company;

public class DemoClass {
    private int myVariable;

    static {
        System.out.println("Static block executed.");
    }

    public DemoClass() {
        myVariable = 0;
    }

    public DemoClass(int value) {
        myVariable = value;
    }

    public int getMyVariable() {
        return myVariable;
    }

    public static void main(String[] args) {
        DemoClass obj1 = new DemoClass();
        DemoClass obj2 = new DemoClass(10);

        System.out.println("My Variable (obj1): " + obj1.getMyVariable());
        System.out.println("My Variable (obj2): " + obj2.getMyVariable());
    }
}
