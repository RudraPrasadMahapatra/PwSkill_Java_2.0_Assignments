### Q1: Given an integer array `arr` and an integer `k`, return true if it is possible to divide the vector into `k` non-empty subsets with equal sum.
**Input:** `arr = [1, 2, 3, 4], k = 2`  
**Output:** `true`  
**Explanation:** `1 + 4` and `2 + 3` are two subsets with equal sum.

**Program:**
```java
public class SubsetEqualSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        System.out.println(canPartitionKSubsets(arr, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum / k);
    }

    private static boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currSum, int currNum, int target) {
        if (k == 1) {
            return true;
        }
        if (currSum == target && currNum > 0) {
            return canPartition(nums, visited, 0, k - 1, 0, 0, target);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, visited, i + 1, k, currSum + nums[i], currNum++, target)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
```

### Q2: Given an integer array `arr`, print all the possible permutations of the given array. Note: The array will only contain non-repeating elements.
**Input:** `arr = [1, 2, 3]`  
**Output:** `[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]`

**Program:**
```java
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = permute(arr);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
```

### Q3: Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations in any order.
**Example 1:**  
**Input:** `nums = [1, 1, 2]`  
**Output:** `[[1, 1, 2], [1, 2, 1], [2, 1, 1]]`

**Example 2:**  
**Input:** `nums = [1, 2, 3]`  
**Output:** `[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]`

**Program:**
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = permuteUnique(nums1);
        for (List<Integer> permutation : result1) {
            System.out.println(permutation);
        }

        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result2 = permuteUnique(nums2);
        for (List<Integer> permutation : result2) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
```

### Q4: Check if the product of some subset of an array is equal to the target value.
**Input:** `n = 5, target = 16, Array = [2, 3, 2, 5, 4]`  
**Output:** `YES`  
**Explanation:** The target will be equal to `2 * 2 * 4 = 16`

**Program:**
```java
public class SubsetProduct {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 5, 4};
        int target = 16;
        System.out.println(isSubsetProduct(arr, target));
    }

    public static boolean isSubsetProduct(int[] arr, int target) {
        return isSubsetProduct(arr, target, 1, 0);
    }

    private static boolean isSubsetProduct(int[] arr, int target, int product, int index) {
        if (index == arr.length) {
            return product == target;
        }
        if (isSubsetProduct(arr, target, product * arr[index], index + 1)) {
            return true;
        }
        return isSubsetProduct(arr, target, product, index + 1);
    }
}
```

### Q5: The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other. Given an integer `n`, return the number of distinct solutions to the n-queens puzzle.
**Input 1:** `n = 4`  
**Output 1:** `2`  
**Explanation:** There are two distinct solutions to the 4-queens puzzle.

**Input 2:** `n = 1`  
**Output 2:** `1`

**Program:**
```java
public class NQueens {
    public static void main(String[] args) {
        System.out.println("Output 1: " + totalNQueens(4)); // Output 1: 2
        System.out.println("Output 2: " + totalNQueens(1)); // Output 2: 1
    }

    public static int totalNQueens(int n) {
        int[] res = new int[1];
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        backtrack(0, res, cols, d1, d2, n);
        return res[0];
    }

    private static void backtrack(int row, int[] res, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            res[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtrack(row + 1, res, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
```