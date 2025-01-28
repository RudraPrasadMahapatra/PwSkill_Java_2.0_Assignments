### Q1: Number of Ways to Climb Stairs

**Problem:** There are `n` stairs. A person at the bottom wants to reach the top. The person can climb either 1 to `m` stairs at a time where `m` is a user-given integer. Count the number of ways the person can reach the top.

**Example 1:**
- **Input:** `n = 5`, `m = 3`
- **Output:** `7`

**Solution:**
```java
public class ClimbStairs {
    public int countWays(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int n1 = 5;
        int m1 = 3;
        System.out.println(cs.countWays(n1, m1)); // Output: 7
    }
}
```

### Q2: Nth Tribonacci Number

**Problem:** The Tribonacci sequence `Tn` is defined as follows: `T0 = 0`, `T1 = 1`, `T2 = 1`, and `Tn+3 = Tn + Tn+1 + Tn+2` for `n >= 0`. Given `n`, return the value of the `n`-th Tribonacci number.

**Example 1:**
- **Input:** `n = 4`
- **Output:** `4`

**Example 2:**
- **Input:** `n = 25`
- **Output:** `1389537`

**Solution:**
```java
public class Tribonacci {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        int n1 = 4;
        System.out.println(tribonacci.tribonacci(n1)); // Output: 4

        int n2 = 25;
        System.out.println(tribonacci.tribonacci(n2)); // Output: 1389537
    }
}
```

### Q3: House Robber

**Problem:** You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. The only constraint is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night. Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

**Example 1:**
- **Input:** `nums = [1, 2, 3, 1]`
- **Output:** `4`

**Example 2:**
- **Input:** `nums = [2, 7, 9, 3, 1]`
- **Output:** `12`

**Solution:**
```java
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(hr.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(hr.rob(nums2)); // Output: 12
    }
}
```

### Q4: Unique Paths

**Problem:** A robot is located at the top-left corner of an `m x n` grid. The robot tries to move to the bottom-right corner of the grid. The robot can only move either down or right at any point in time. Given the two integers `m` and `n`, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

**Example 1:**
- **Input:** `m = 3`, `n = 7`
- **Output:** `28`

**Example 2:**
- **Input:** `m = 3`, `n = 2`
- **Output:** `3`

**Solution:**
```java
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int m1 = 3;
        int n1 = 7;
        System.out.println(up.uniquePaths(m1, n1)); // Output: 28

        int m2 = 3;
        int n2 = 2;
        System.out.println(up.uniquePaths(m2, n2)); // Output: 3
    }
}
```

### Q5: Minimum Path Sum in Triangle

**Problem:** Given a triangle array, return the minimum path sum from top to bottom. At each step, you may move to an adjacent number of the row below.

**Example 1:**
- **Input:** `triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]`
- **Output:** `11`

**Example 2:**
- **Input:** `triangle = [[-10]]`
- **Output:** `-10`

**Solution:**
```java
import java.util.List;

public class MinimumPathSumTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        MinimumPathSumTriangle mpst = new MinimumPathSumTriangle();
        List<List<Integer>> triangle1 = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        System.out.println(mpst.minimumTotal(triangle1)); // Output: 11

        List<List<Integer>> triangle2 = List.of(
            List.of(-10)
        );
        System.out.println(mpst.minimumTotal(triangle2)); // Output: -10
    }
}
```