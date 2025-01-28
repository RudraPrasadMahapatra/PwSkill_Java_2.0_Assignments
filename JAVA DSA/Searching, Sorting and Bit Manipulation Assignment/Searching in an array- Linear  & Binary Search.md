
### Q1: Given an array, find the number X in the array. If the element is present, return the index of the element, else print "Element not found in array". Input the size of the array, array from the user, and the element X from the user. Use Linear Search to find the element.

**Example 1:**
```plaintext
Enter the number of elements you want to add: 6
Enter the elements of the array: 1 2 3 4 5 6
Enter the element to be searched in array: 2
```
**Output 1:**
```plaintext
Element found at index 1
```

**Example 2:**
```plaintext
Enter the number of elements you want to add: 6
Enter the elements of the array: 1 2 3 4 5 6
Enter the element to be searched in array: 10
```
**Output 2:**
```plaintext
Element not found in array
```

**Program:**
```java
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to add: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to be searched in array: ");
        int x = sc.nextInt();

        int index = linearSearch(arr, x);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in array");
        }
    }

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
```

### Q2: Given an array and an integer "target", return the last occurrence of "target" in the array. If the target is not present return -1.

**Input 1:** `arr = [1, 2, 3, 4, 4, 5, 6, 6]`, target: `4`
**Output 1:** `4`

**Input 2:** `arr = [2, 4, 2, 6, 15, 8, 29, 30, 30, 30]`, target: `15`
**Output 2:** `4`

**Program:**
```java
import java.util.Scanner;

public class LastOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to add: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target to be searched in array: ");
        int target = sc.nextInt();

        int index = lastOccurrence(arr, target);
        System.out.println("Last occurrence of target is at index " + index);
    }

    public static int lastOccurrence(int[] arr, int target) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

### Q3: Given a sorted binary array, efficiently count the total number of 1's in it.

**Input 1:** `arr = [0, 0, 0, 0, 1, 1, 1]`
**Output 1:** `3`

**Input 2:** `arr = [0, 0, 0, 1, 1, 1, 1]`
**Output 2:** `4`

**Program:**
```java
import java.util.Scanner;

public class CountOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to add: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = countOnes(arr);
        System.out.println("Total number of 1's: " + count);
    }

    public static int countOnes(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr.length - left;
    }
}
```

### Q4: Given a sorted integer array containing duplicates, count occurrences of a given number. If the element is not found in the array, report that as well.

**Input 1:** `nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]`, target: `5`
**Output 1:** `Target 5 occurs 3 times`

**Input 2:** `nums = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]`, target: `6`
**Output 2:** `Target 6 occurs 2 times`

**Program:**
```java
import java.util.Scanner;

public class CountOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements you want to add: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target to be searched in array: ");
        int target = sc.nextInt();

        int count = countOccurrences(nums, target);
        if (count > 0) {
            System.out.println("Target " + target + " occurs " + count + " times");
        } else {
            System.out.println("Target " + target + " not found in array");
        }
    }

    public static int countOccurrences(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
```

### Q5: Given a positive integer num, return true if num is a perfect square or false otherwise.

**Example 1:**
**Input:** `num = 16`
**Output:** `true`
**Explanation:** We return true because 4 * 4 = 16 and 4 is an integer.

**Example 2:**
**Input:** `num = 14`
**Output:** `false`
**Explanation:** We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

**Program:**
```java
import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        boolean result = isPerfectSquare(num);
        System.out.println(result);
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }

        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
```