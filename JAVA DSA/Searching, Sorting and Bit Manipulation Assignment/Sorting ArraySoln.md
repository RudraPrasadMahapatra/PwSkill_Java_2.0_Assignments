### Q1: Write a program to sort an array in descending order using bubble sort.
**Input Array:** `{3, 5, 1, 6, 0}`
**Output Array:** `{6, 5, 3, 1, 0}`

**Program:**
```java
import java.util.Arrays;

public class BubbleSortDescending {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 0};
        bubbleSortDescending(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

### Q2: Write a program to sort an array in descending order using selection sort.
**Input Array:** `{3, 5, 1, 6, 0}`
**Output Array:** `{6, 5, 3, 1, 0}`

**Program:**
```java
import java.util.Arrays;

public class SelectionSortDescending {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 0};
        selectionSortDescending(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap arr[i] and arr[maxIdx]
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}
```

### Q3: Write a program to sort an array in decreasing order using insertion sort.
**Input Array:** `{3, 5, 1, 6, 0}`
**Output Array:** `{6, 5, 3, 1, 0}`

**Program:**
```java
import java.util.Arrays;

public class InsertionSortDescending {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 0};
        insertionSortDescending(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void insertionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
```

### Q4: Find out how many passes would be required to sort the following array in decreasing order using bubble sort.
**Input Array:** `{3, 5, 1, 6, 0}`
**Output:** `4 passes`

### Q5: Find out the number of iterations to sort the array in descending order using selection sort.
**Input Array:** `{3, 5, 1, 6, 0}`
**Output:** `5 iterations`

In bubble sort, the number of passes required is generally `n-1` for an array of length `n`. Therefore, for the input `{3, 5, 1, 6, 0}`, 4 passes are required.

In selection sort, the number of iterations is equal to the length of the array because we select the maximum element in the remaining unsorted portion of the array in each iteration. Hence, for the input `{3, 5, 1, 6, 0}`, 5 iterations are needed.
