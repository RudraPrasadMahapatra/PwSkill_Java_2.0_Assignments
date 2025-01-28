### Q1: Given an array where all its elements are sorted in increasing order except two swapped elements, sort it in linear time. Assume there are no duplicates in the array.
**Input:** `arr = [3, 8, 6, 7, 5, 9, 10]`  
**Output:** `arr = [3, 5, 6, 7, 8, 9, 10]`

**Program:**
```java
public class FixSwappedElements {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 5, 9, 10};
        fixSwappedElements(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void fixSwappedElements(int[] arr) {
        int n = arr.length;
        int first = -1, second = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (first == -1) {
                    first = i;
                }
                second = i + 1;
            }
        }
        if (first != -1) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }
}
```

### Q2: Given an array of positive and negative integers, segregate them in linear time and constant space. The output should print all negative numbers, followed by all positive numbers.
**Input:** `arr = {19, -20, 7, -4, -13, 11, -5, 3}`  
**Output:** `arr = {-20, -4, -13, -5, 19, 11, 3, 7}`

**Program:**
```java
public class SegregatePosNeg {
    public static void main(String[] args) {
        int[] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        segregatePosNeg(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void segregatePosNeg(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[right] >= 0) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
```

### Q3: Given an array of positive and negative integers, segregate them in linear time and constant space. The output should print all negative numbers, followed by all positive numbers. The relative order of elements must remain the same.
**Input:** `arr = {19, -20, 7, -4, -13, 11, -5, 3}`  
**Output:** `arr = {-20, -4, -13, -5, 19, 7, 11, 3}`

**Program:**
```java
import java.util.*;

public class MaintainOrderSegregatePosNeg {
    public static void main(String[] args) {
        int[] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        int[] result = segregatePosNegWithOrder(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] segregatePosNegWithOrder(int[] arr) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();

        for (int num : arr) {
            if (num < 0) {
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }

        int index = 0;
        for (int num : negatives) {
            arr[index++] = num;
        }
        for (int num : positives) {
            arr[index++] = num;
        }

        return arr;
    }
}
```

### Q4: Given two arrays of equal size `n` and an integer `k`. The task is to permute both arrays such that the sum of their corresponding elements is greater than or equal to `k`. Print "Yes" if any such permutation exists, otherwise print "No".
**Input:** `a = {2, 1, 3}`, `b = {7, 8, 9}`, `k = 10`  
**Output:** `Yes`

**Input:** `a = {1, 2, 2, 1}`, `b = {3, 3, 3, 4}`, `k = 5`  
**Output:** `No`

**Program:**
```java
import java.util.Arrays;

public class PermuteArrays {
    public static void main(String[] args) {
        int[] a1 = {2, 1, 3};
        int[] b1 = {7, 8, 9};
        int k1 = 10;
        System.out.println("Output 1: " + canPermuteToSatisfy(a1, b1, k1)); // Output 1: Yes

        int[] a2 = {1, 2, 2, 1};
        int[] b2 = {3, 3, 3, 4};
        int k2 = 5;
        System.out.println("Output 2: " + canPermuteToSatisfy(a2, b2, k2)); // Output 2: No
    }

    public static String canPermuteToSatisfy(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] + b[n - 1 - i] < k) {
                return "No";
            }
        }
        return "Yes";
    }
}
```

### Q5: An interval is represented as a combination of start time and end time. Given a set of intervals, check if any two intervals intersect.
**Input:** `intervals = {{0, 3}, {5, 7}, {2, 4}, {6, 8}}`  
**Output:** `Yes`  
**Explanation:** The intervals {0, 3} and {2, 4} overlap.

**Input:** `intervals = {{0, 3}, {7, 9}, {4, 6}, {10, 13}}`  
**Output:** `No`

**Program:**
```java
import java.util.Arrays;

public class CheckIntervalsOverlap {
    public static void main(String[] args) {
        int[][] intervals1 = {{0, 3}, {5, 7}, {2, 4}, {6, 8}};
        System.out.println("Output 1: " + intervalsOverlap(intervals1)); // Output 1: Yes

        int[][] intervals2 = {{0, 3}, {7, 9}, {4, 6}, {10, 13}};
        System.out.println("Output 2: " + intervalsOverlap(intervals2)); // Output 2: No
    }

    public static String intervalsOverlap(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return "Yes";
            }
        }
        return "No";
    }
}
```