### Q1: Find the minimum sum of products of two arrays of the same size, given that `k` modifications are allowed on the first array. In each modification, one array element of the first array can either be increased or decreased by 2.

**Example 1:**

**Input:** `a = [1, 2, -3], k = 5`  
**Output:** `-31`  
**Explanation:**  
Here, `n = 3` and `k = 5`. So, we modified `a[2]`, which is `-3` and increased it by `10` (as 5 modifications are allowed).  
Final sum will be `1 * -5 + 2 * 8 + -3 * 9` which is `-31`.

**Example 2:**

**Input:** `a = [23, 4, 5, 4], k = 3`  
**Output:** `25`  
**Explanation:**  
Here, `n = 4` and `k = 3`. So, modify `a[1]`, which is `4` and decreased it by `6` (as 3 modifications are allowed).  
Final sum will be `23 * 1 + 4 * 8 + 5 * 5 + 4 * 8` which is `25`.

**Program:**
```java
import java.util.Arrays;

public class MinSumProduct {
    public static void main(String[] args) {
        int[] a1 = {1, 2, -3};
        int k1 = 5;
        int[] b1 = {1, 2, 3};
        System.out.println("Output 1: " + minSumProduct(a1, b1, k1)); // Output 1: -31

        int[] a2 = {23, 4, 5, 4};
        int k2 = 3;
        int[] b2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + minSumProduct(a2, b2, k2)); // Output 2: 25
    }

    public static int minSumProduct(int[] a, int[] b, int k) {
        int n = a.length;
        int[] diff = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(a[i] * b[i]);
            sum += a[i] * b[i];
        }
        for (int i = 0; i < k; i++) {
            int maxIndex = 0;
            for (int j = 1; j < n; j++) {
                if (diff[j] > diff[maxIndex]) {
                    maxIndex = j;
                }
            }
            diff[maxIndex] -= Math.abs(b[maxIndex] * 2);
            sum += (a[maxIndex] > 0 ? -2 * b[maxIndex] : 2 * b[maxIndex]);
        }
        return sum;
    }
}
```

### Q2: You are given `n` activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

**Example 1:**

**Input:** `start = {10, 12, 20}, finish = {20, 25, 30}`  
**Output:** `[0, 2]`  
**Explanation:**  
A person can perform at most two activities. The maximum set of activities that can be executed is `{0, 2}`. These are indexes in `start` and `finish` arrays.

**Example 2:**

**Input:** `start = {1, 3, 0, 5, 8, 5}, finish = {2, 4, 6, 7, 9, 9}`  
**Output:** `[0, 1, 3, 4]`  
**Explanation:**  
A person can perform at most four activities. The maximum set of activities that can be executed is `{0, 1, 3, 4}`. These are indexes in `start` and `finish` arrays.

**Program:**
```java
import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start1 = {10, 12, 20};
        int[] finish1 = {20, 25, 30};
        List<Integer> result1 = maxActivities(start1, finish1);
        System.out.println("Output 1: " + result1); // Output 1: [0, 2]

        int[] start2 = {1, 3, 0, 5, 8, 5};
        int[] finish2 = {2, 4, 6, 7, 9, 9};
        List<Integer> result2 = maxActivities(start2, finish2);
        System.out.println("Output 2: " + result2); // Output 2: [0, 1, 3, 4]
    }

    public static List<Integer> maxActivities(int[] start, int[] finish) {
        int n = start.length;
        List<Integer> selectedActivities = new ArrayList<>();

        selectedActivities.add(0);
        int lastFinishedActivity = 0;

        for (int i = 1; i < n; i++) {
            if (start[i] >= finish[lastFinishedActivity]) {
                selectedActivities.add(i);
                lastFinishedActivity = i;
            }
        }
        return selectedActivities;
    }
}
```

### Q3: There are n gas stations along a circular route, where the amount of gas at the ith station is `gas[i]`. You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations. Given two integer arrays `gas` and `cost`, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

**Example 1:**

**Input:** `gas = [1, 2, 3, 4, 5]`, `cost = [3, 4, 5, 1, 2]`  
**Output:** `3`  
**Explanation:**  
Start at station 3 (index 3) and fill up with 4 units of gas.  
- Travel to station 4. Your tank = 4 - 1 + 5 = 8.  
- Travel to station 0. Your tank = 8 - 2 + 1 = 7.  
- Travel to station 1. Your tank = 7 - 3 + 2 = 6.  
- Travel to station 2. Your tank = 6 - 4 + 3 = 5.  
- Travel to station 3. The cost is 5, your gas is just enough to travel back to station 3.  
Therefore, return 3 as the starting index.

**Example 2:**

**Input:** `gas = [2, 3, 4]`, `cost = [3, 4, 3]`  
**Output:** `-1`  
**Explanation:**  
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.  
Let's start at station 2 and fill up with 4 units of gas. Your tank = 0 + 4 = 4.  
- Travel to station 0. Your tank = 4 - 3 + 2 = 3.  
- Travel to station 1. Your tank = 3 - 3 + 3 = 3.  
You cannot travel back to station 2, as it requires 4 units of gas but you only have 3.  
Therefore, you can't travel around the circuit once no matter where you start.

**Program:**
```java
public class GasStation {
    public static void main(String[] args) {
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Output 1: " + canCompleteCircuit(gas1, cost1)); // Output 1: 3

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Output 2: " + canCompleteCircuit(gas2, cost2)); // Output 2: -1
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, startIndex = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? startIndex : -1;
    }
}
```

### Q4: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots. Given an integer array `flowerbed` containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer `n`, return if `n` new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

**Example 1:**

**Input:** `flowerbed = [1, 0, 0, 0, 1]`, `n = 1`  
**Output:** `true`

**Example 2:**

**Input:** `flowerbed = [1, 0, 0, 0, 1]`, `n = 2`  
**Output:** `false`

**Program:**
```java
public class Flowerbed {
    public static void main(String[] args) {
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Output 1: " + canPlaceFlowers(flowerbed1, n1)); // Output 1: true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Output 2: " + canPlaceFlowers(flowerbed2, n2)); // Output 2: false
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}
```

### Q5: Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

**Example 1:**

**Input:** `intervals = [[1, 2], [2, 3], [3, 4], [1, 3]]`  
**Output:** `1`  
**Explanation:** `[1, 3]` can be removed and the rest of the intervals are non-overlapping.

**Example 2:**

**Input:** `intervals = [[1, 2], [1, 2], [1, 2]]`  
**Output:** `2`  
**Explanation:** You need to remove two `[1, 2]` to make the rest of the intervals non-overlapping.

**Example 3:**

**Input:** `intervals = [[1, 2], [2, 3]]`  
**Output:** `0`  
**Explanation:** You don't need to remove any of the intervals since they're already non-overlapping.

**Program:**
```java
import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Output 1: " + eraseOverlapIntervals(intervals1)); // Output 1: 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Output 2: " + eraseOverlapIntervals(intervals2)); // Output 2: 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Output 3: " + eraseOverlapIntervals(intervals3)); // Output 3: 0
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
```
