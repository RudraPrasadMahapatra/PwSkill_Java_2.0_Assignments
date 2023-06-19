//1.  Create a class that keeps track of the number of instances created . Implement of static variable and method to accomplish this .
package com.company;

public class InstanceCounter {
    private static int numInstances = 0;

    public InstanceCounter() {
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public static void main(String[] args) {
        InstanceCounter obj1 = new InstanceCounter();
        System.out.println("Number of instances created: " + InstanceCounter.getNumInstances());

        InstanceCounter obj2 = new InstanceCounter();
        System.out.println("Number of instances created: " + InstanceCounter.getNumInstances());
    }
}
