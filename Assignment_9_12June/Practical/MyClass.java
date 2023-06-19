//2. 2. Write a program and create a constructor with parameters and initialise the variable using a constructor .
package com.company;

public class MyClass {
    private int myVar;

    public MyClass(int value) {
        myVar = value;
    }


    public int getMyVariable() {
        int myVar = this.myVar;
        return myVar;
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(10);
        System.out.println(obj.getMyVariable());
    }
}

