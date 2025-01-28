### Problem 1: Given a number, print its binary representation. [Easy]
**Input 1:** `number = 5`
**Output 1:** `101`

**Input 2:** `number = 10`
**Output 2:** `1010`

**Program:**
```java
import java.util.Scanner;

public class BinaryRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        String binaryString = Integer.toBinaryString(number);
        System.out.println("Binary representation: " + binaryString);
    }
}
```

### Problem 2: Given a number predict whether it is a power of two or not. [Medium]
**Input 1:** `n = 15`
**Output 1:** `False`

**Input 2:** `n = 32`
**Output 2:** `True`

**Program:**
```java
import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean isPowerOfTwo = (n > 0) && ((n & (n - 1)) == 0);
        System.out.println("Is power of two: " + isPowerOfTwo);
    }
}
```

### Problem 3: Given a number. Using bit manipulation, check whether it is odd or even.
**Input 1:** `8`
**Output 1:** `Even`

**Input 2:** `3`
**Output 2:** `Odd`

**Program:**
```java
import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if ((number & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
```

### Problem 4: Given a number, count the number of set bits in that number without using extra space.
**Note:** A bit '1' is also known as a set bit.

**Program:**
```java
import java.util.Scanner;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0;
        while (number > 0) {
            count += (number & 1);
            number >>= 1;
        }
        System.out.println("Number of set bits: " + count);
    }
}
```

### Problem 5: Given an integer array, duplicates are present in it in a way that all duplicates appear an even number of times except one which appears an odd number of times. Find that odd appearing element in linear time and without using any extra memory.

**Input:** `arr = [4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3]`
**Output:** `The odd occurring element is 4`

**Program:**
```java
import java.util.Scanner;

public class OddOccurringElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findOddOccurrence(arr);
        System.out.println("The odd occurring element is " + result);
    }

    public static int findOddOccurrence(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
