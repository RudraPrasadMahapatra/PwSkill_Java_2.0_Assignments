**Q1: Given an integer array, find the k-th largest element using the Quickselect algorithm.**

**Example 1:**
**Input:** `arr = [3, 2, 1, 5, 6, 4]`, `k = 2`  
**Output:** `5`

**Example 2:**
**Input:** `arr = [3, 2, 3, 1, 2, 4, 5, 5, 6]`, `k = 4`  
**Output:** `4`

**Program:**
```java
public class QuickSelect {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Output 1: " + findKthLargest(arr1, k1)); // Output 1: 5

        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Output 2: " + findKthLargest(arr2, k2)); // Output 2: 4
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        swap(nums, pIndex, right);
        return pIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

In this program, the `findKthLargest` function utilizes the Quickselect algorithm to find the k-th largest element in the given array. The `quickSelect` function recursively partitions the array and narrows down the search space to find the desired element. The `partition` function rearranges the array such that elements smaller than the pivot are on the left and elements larger than the pivot are on the right.
