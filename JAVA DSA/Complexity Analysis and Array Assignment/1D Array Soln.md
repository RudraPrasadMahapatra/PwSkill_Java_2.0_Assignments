### Q1: Write a program to print the sum of all the elements present on even indices in the given array.
**Input 1:** `arr[] = {3, 20, 4, 6, 9}`
**Output 1:** `16`

**Input 2:** `arr[] = {1, 10, 3}`
**Output 2:** `11`

**Program:**
```java
public class SumEvenIndices {
    public static void main(String[] args) {
        int[] arr1 = {3, 20, 4, 6, 9};
        int[] arr2 = {1, 10, 3};

        System.out.println("Output 1: " + sumEvenIndices(arr1)); // Output 1: 16
        System.out.println("Output 2: " + sumEvenIndices(arr2)); // Output 2: 11
    }

    public static int sumEvenIndices(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }
}
```

### Q2: Write a program to traverse over the elements of the array using for each loop and print all even elements.
**Input 1:** `arr[] = {12, 34, 45, 54, 21}`
**Output 1:** `34 54`

**Input 2:** `arr[] = {3, 4, 5, 6}`
**Output 2:** `4 6`

**Program:**
```java
public class PrintEvenElements {
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 45, 54, 21};
        int[] arr2 = {3, 4, 5, 6};

        System.out.print("Output 1: ");
        printEvenElements(arr1); // Output 1: 34 54

        System.out.print("Output 2: ");
        printEvenElements(arr2); // Output 2: 4 6
    }

    public static void printEvenElements(int[] arr) {
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
```

### Q3: Write a program to calculate the maximum element in the array.
**Input 1:** `arr[] = {12, 34, 54, 65, 21}`
**Output 1:** `65`

**Input 2:** `arr[] = {3, 4, 7, 1}`
**Output 2:** `7`

**Program:**
```java
public class MaxElement {
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 54, 65, 21};
        int[] arr2 = {3, 4, 7, 1};

        System.out.println("Output 1: " + findMax(arr1)); // Output 1: 65
        System.out.println("Output 2: " + findMax(arr2)); // Output 2: 7
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
```

### Q4: Write a program to find out the second largest element in a given array.
**Input 1:** `arr[] = {12, 34, 54, 65, 21}`
**Output 1:** `54`

**Input 2:** `arr[] = {3, 4, 7, 6}`
**Output 2:** `6`

**Program:**
```java
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 54, 65, 21};
        int[] arr2 = {3, 4, 7, 6};

        System.out.println("Output 1: " + findSecondLargest(arr1)); // Output 1: 54
        System.out.println("Output 2: " + findSecondLargest(arr2)); // Output 2: 6
    }

    public static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }
}
```

### Q5: Given an array, find the first peak element in the array. A peak element is an element that is greater than its just left and just right neighbor.
**Input 1:** `arr[] = {1, 3, 2, 6, 5}`
**Output 1:** `6`

**Input 2:** `arr[] = {1, 2, 3, 7, 5}`
**Output 2:** `7`

**Program:**
```java
public class PeakElement {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 6, 5};
        int[] arr2 = {1, 2, 3, 7, 5};

        System.out.println("Output 1: " + findPeakElement(arr1)); // Output 1: 6
        System.out.println("Output 2: " + findPeakElement(arr2)); // Output 2: 7
    }

    public static int findPeakElement(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return -1; // If no peak element found
    }
}
```

