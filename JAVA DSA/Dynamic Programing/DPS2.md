### Q1: Unique Paths with Obstacles

**Problem:** You are given an `m x n` array. There is a robot initially located at the top-left corner (i.e., `grid[0][0]`). The robot tries to move to the bottom-right corner (i.e., `grid[m-1][n-1]`). The robot can only move either down or right at any point in time. An obstacle and space are marked as 1 or 0 respectively in the grid. A path that the robot takes cannot include any square that is an obstacle. Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

**Example 1:**
- **Input:** `[[0,0,0],[0,1,0],[0,0,0]]`
- **Output:** `2`

**Example 2:**
- **Input:** `[[0,1],[0,0]]`
- **Output:** `1`

**Solution:**
```java
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        if (obstacleGrid[0][0] == 1) return 0;
        
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles upwo = new UniquePathsWithObstacles();
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(upwo.uniquePathsWithObstacles(obstacleGrid1)); // Output: 2

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(upwo.uniquePathsWithObstacles(obstacleGrid2)); // Output: 1
    }
}
```

### Q2: House Robber II

**Problem:** You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last house. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night. Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

**Example 1:**
- **Input:** `nums = [2, 3, 2]`
- **Output:** `3`

**Example 2:**
- **Input:** `nums = [1, 2, 3, 1]`
- **Output:** `4`

**Example 3:**
- **Input:** `nums = [1, 2, 3]`
- **Output:** `3`

**Solution:**
```java
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII hr = new HouseRobberII();
        int[] nums1 = {2, 3, 2};
        System.out.println(hr.rob(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(hr.rob(nums2)); // Output: 4

        int[] nums3 = {1, 2, 3};
        System.out.println(hr.rob(nums3)); // Output: 3
    }
}
```

### Q3: Minimum Path Sum

**Problem:** Given an `m x n` grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. You can only move either down or right at any point in time.

**Example 1:**
- **Input:** `grid = [[1,3,1],[1,5,1],[4,2,1]]`
- **Output:** `7`

**Example 2:**
- **Input:** `grid = [[1,2,3],[4,5,6]]`
- **Output:** `12`

**Solution:**
```java
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mps.minPathSum(grid1)); // Output: 7

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(mps.minPathSum(grid2)); // Output: 12
    }
}
```

### Q4: Partition Equal Subset Sum

**Problem:** Given an integer array `nums`, return `true` if you can partition the array into two subsets such that the sum of the elements in both subsets is equal, or `false` otherwise.

**Example 1:**
- **Input:** `nums = [1, 5, 11, 5]`
- **Output:** `true`

**Example 2:**
- **Input:** `nums = [1, 2, 3, 5]`
- **Output:** `false`

**Solution:**
```java
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int subsetSum = totalSum / 2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum pess = new PartitionEqualSubsetSum();
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(pess.canPartition(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(pess.canPartition(nums2)); // Output: false
    }
}
```
