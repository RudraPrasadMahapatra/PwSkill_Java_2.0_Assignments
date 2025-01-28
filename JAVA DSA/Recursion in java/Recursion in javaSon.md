### Q1: Given an integer, find out the sum of its digits using recursion.
**Input:** `n = 1234`
**Output:** `10`
**Explanation:** `1 + 2 + 3 + 4 = 10`

**Program:**
```java
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int sum = sumOfDigits(n);
        System.out.println("Sum of digits: " + sum);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
}
```

### Q2: Given a number n. Find the sum of natural numbers till n but with alternate signs.
**Input 1:** `n = 10`
**Output 1:** `-5`
**Explanation:** `1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5`

**Input 2:** `n = 5`
**Output 2:** `3`
**Explanation:** `1 - 2 + 3 - 4 + 5 = 3`

**Program:**
```java
import java.util.Scanner;

public class AlternateSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int sum = alternateSum(n);
        System.out.println("Alternate sum: " + sum);
    }

    public static int alternateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }
}
```

### Q3: Print the max value of the array `[13, 1, -3, 22, 5]`.
**Input:** `[13, 1, -3, 22, 5]`
**Output:** `22`

**Program:**
```java
public class MaxValue {
    public static void main(String[] args) {
        int[] arr = {13, 1, -3, 22, 5};
        int max = findMax(arr);
        System.out.println("Max value: " + max);
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

### Q4: Find the sum of the values of the array `[92, 23, 15, -20, 10]`.
**Input:** `[92, 23, 15, -20, 10]`
**Output:** `120`

**Program:**
```java
public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {92, 23, 15, -20, 10};
        int sum = findSum(arr);
        System.out.println("Sum of array values: " + sum);
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
```

### Q5: Given a number n. Print if it is an Armstrong number or not. An Armstrong number is a number if the sum of every digit in that number raised to the power of total digits in that number is equal to the number.
**Input 1:** `153`
**Output 1:** `Yes`
**Explanation:** `153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153`

**Input 2:** `134`
**Output 2:** `No`

**Program:**
```java
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean isArmstrong = isArmstrong(n);
        if (isArmstrong) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();

        while (n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }
}
```