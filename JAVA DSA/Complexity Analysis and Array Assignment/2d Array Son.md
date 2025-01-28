### Q1: Take `m` and `n` input from the user and `m * n` integer inputs from the user. Print the following:
- Number of positive numbers
- Number of negative numbers
- Number of odd numbers
- Number of even numbers
- Number of zeros

**Input 1:**  
```plaintext
Enter the number of rows (m): 3
Enter the number of columns (n): 4
Enter the elements:
1  -2  0  4
3  -5  6  0
7  8  -9  -10
```

**Output:**  
```plaintext
Number of positive numbers: 7
Number of negative numbers: 6
Number of odd numbers: 7
Number of even numbers: 9
Number of zeros: 2
```

**Program:**
```java
import java.util.Scanner;

public class ArrayAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];
        int positiveCount = 0, negativeCount = 0, oddCount = 0, evenCount = 0, zeroCount = 0;

        System.out.println("Enter the elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > 0) positiveCount++;
                if (arr[i][j] < 0) negativeCount++;
                if (arr[i][j] == 0) zeroCount++;
                if (arr[i][j] % 2 == 0) evenCount++;
                if (arr[i][j] % 2 != 0) oddCount++;
            }
        }

        System.out.println("Number of positive numbers: " + positiveCount);
        System.out.println("Number of negative numbers: " + negativeCount);
        System.out.println("Number of odd numbers: " + oddCount);
        System.out.println("Number of even numbers: " + evenCount);
        System.out.println("Number of zeros: " + zeroCount);
    }
}
```

### Q2: Write a program to print the elements above the secondary diagonal in a user-inputted square matrix.
**Input 1:**
```plaintext
4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
```

**Output:**
```plaintext
Elements above the secondary diagonal: 2 4 6
```

**Program:**
```java
import java.util.Scanner;

public class AboveSecondaryDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Elements above the secondary diagonal: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n - 1) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }
}
```

### Q3: Write a program to print the elements of both diagonals in a user-inputted square matrix in any order.
**Input 1:**
```plaintext
4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
```

**Output:**
```plaintext
1 6 11 16 4 7 10 13
```

**Program:**
```java
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Primary diagonal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.print("\nSecondary diagonal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][n - i - 1] + " ");
        }
    }
}
```

### Q4: Write a program to find the largest element of a given 2D array of integers.
**Input 1:**
```plaintext
3 4
1 2 4 -1
2 5 2 6
4 7 6 9
```

**Output:**  
```plaintext
Largest element: 9
```

**Program:**
```java
import java.util.Scanner;

public class LargestElement2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];
        int max = Integer.MIN_VALUE;

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        System.out.println("Largest element: " + max);
    }
}
```

### Q5: Write a function which accepts a 2D array of integers and its size as arguments and displays the elements of the middle row and the elements of the middle column.
**Input 1:**
```plaintext
3
1 2 3
4 5 6
7 8 9
```

**Output:**
```plaintext
Middle row: 4 5 6
Middle column: 2 5 8
```

**Program:**
```java
import java.util.Scanner;

public class MiddleRowColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        printMiddleRowColumn(matrix, n);
    }

    public static void printMiddleRowColumn(int[][] matrix, int n) {
        int mid = n / 2;

        System.out.print("Middle row: ");
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[mid][j] + " ");
        }

        System.out.print("\nMiddle column: ");
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][mid] + " ");
        }
    }
}
```