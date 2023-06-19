//3.   Use a private keyword for a variable and use setter and getter methods to initialize and print the values .
package com.company;

public class MyClass2 {
    private int myVariable;

    public void setMyVariable(int value) {
        this.myVariable = value;
    }

    public int getMyVariable() {
        return myVariable;
    }

    public static void main(String[] args) {
        MyClass2 obj = new MyClass2();
        obj.setMyVariable(10);
        System.out.println("My Variable: " + obj.getMyVariable());
    }
}
