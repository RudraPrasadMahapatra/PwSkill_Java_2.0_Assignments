
### Q1: Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

**Example 1:**  
**Input:**
```plaintext
matrix = [
  ["1", "0", "1", "0", "0"],
  ["1", "0", "1", "1", "1"],
  ["1", "1", "1", "1", "1"],
  ["1", "0", "0", "1", "0"]
]
```
**Output:** `6`  
**Explanation:** The maximal rectangle is shown in the above picture.

**Example 2:**  
**Input:**
```plaintext
matrix = [
  ["0"]
]
```
**Output:** `0`

**Example 3:**  
**Input:**
```plaintext
matrix = [
  ["0", "1"],
  ["1", "0"]
]
```
**Output:** `1`

**Program:**
```java
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Output 1: " + solution.maximalRectangle(matrix1)); // Output 1: 6

        char[][] matrix2 = {
            {'0'}
        };
        System.out.println("Output 2: " + solution.maximalRectangle(matrix2)); // Output 2: 0

        char[][] matrix3 = {
            {'0', '1'},
            {'1', '0'}
        };
        System.out.println("Output 3: " + solution.maximalRectangle(matrix3)); // Output 3: 1
    }
}
```

### Q2: Given an encoded string, return its decoded string.

**Example 1:**  
**Input:** `s = "3[a]2[bc]"`  
**Output:** `"aaabcbc"`

**Example 2:**  
**Input:** `s = "3[a2[c]]"`  
**Output:** `"accaccacc"`

**Example 3:**  
**Input:** `s = "2[abc]3[cd]ef"`  
**Output:** `"abcabccdcdcdef"`

**Program:**
```java
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println("Output 1: " + solution.decodeString("3[a]2[bc]")); // Output 1: aaabcbc
        System.out.println("Output 2: " + solution.decodeString("3[a2[c]]")); // Output 2: accaccacc
        System.out.println("Output 3: " + solution.decodeString("2[abc]3[cd]ef")); // Output 3: abcabccdcdcdef
    }
}

### Q3: You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record. You are given a list of strings operations, where `operations[i]` is the ith operation you must apply to the record and is one of the following:
- An integer x: Record a new score of x.
- "+": Record a new score that is the sum of the previous two scores.
- "D": Record a new score that is the double of the previous score.
- "C": Invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record after applying all the operations.

**Example 1:**  
**Input:** `ops = ["5", "2", "C", "D", "+"]`  
**Output:** `30`  
**Explanation:**  
"5" - Add 5 to the record, record is now `[5]`.  
"2" - Add 2 to the record, record is now `[5, 2]`.  
"C" - Invalidate and remove the previous score, record is now `[5]`.  
"D" - Add 2 * 5 = 10 to the record, record is now `[5, 10]`.  
"+" - Add 5 + 10 = 15 to the record, record is now `[5, 10, 15]`.  
The total sum is `5 + 10 + 15 = 30`.

**Example 2:**  
**Input:** `ops = ["5", "-2", "4", "C", "D", "9", "+", "+"]`  
**Output:** `27`  
**Explanation:**  
"5" - Add 5 to the record, record is now `[5]`.  
"-2" - Add -2 to the record, record is now `[5, -2]`.  
"4" - Add 4 to the record, record is now `[5, -2, 4]`.  
"C" - Invalidate and remove the previous score, record is now `[5, -2]`.  
"D" - Add 2 * -2 = -4 to the record, record is now `[5, -2, -4]`.  
"9" - Add 9 to the record, record is now `[5, -2, -4, 9]`.  
"+" - Add -4 + 9 = 5 to the record, record is now `[5, -2, -4, 9, 5]`.  
"+" - Add 9 + 5 = 14 to the record, record is now `[5, -2, -4, 9, 5, 14]`.  
The total sum is `5 + (-2) + (-4) + 9 + 5 + 14 = 27`.

**Example 3:**  
**Input:** `ops = ["1", "C"]`  
**Output:** `0`  
**Explanation:**  
"1" - Add 1 to the record, record is now `[1]`.  
"C" - Invalidate and remove the previous score, record is now `[]`.  
Since the record is empty, the total sum is `0`.

**Program:**
```java
import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println("Output 1: " + solution.calPoints(ops1)); // Output 1: 30

        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("Output 2: " + solution.calPoints(ops2)); // Output 2: 27

        String[] ops3 = {"1", "C"};
        System.out.println("Output 3: " + solution.calPoints(ops3)); // Output 3: 0
    }
}
```