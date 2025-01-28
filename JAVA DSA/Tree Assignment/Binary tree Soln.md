### Q1: Given the root of a binary tree, return the spiral level order traversal of its nodes' values. The solution should consider the binary tree nodes level by level in spiral order, i.e., all nodes present at level 1 should be processed first from left to right, followed by nodes of level 2 from right to left, followed by nodes of level 3 from left to right and so on. In other words, odd levels should be processed from left to right, and even levels should be processed from right to left.
**Input:**
```
        1
       / \
      2   3
     / \ / \
    4  5 6  7
      /
     8
```
**Output:** `[1, 3, 2, 4, 5, 6, 8, 7]`

**Program:**
```java
import java.util.*;

public class SpiralOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    TreeNode root;

    public List<Integer> spiralOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                result.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                result.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrderTraversal tree = new SpiralOrderTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.right.left = new TreeNode(8);

        List<Integer> result = tree.spiralOrderTraversal(tree.root);
        System.out.println("Output: " + result); // Output: [1, 3, 2, 4, 5, 6, 8, 7]
    }
}
```

### Q2: Given the root of a binary tree, check if it is a complete binary tree or not. A complete binary tree is a binary tree in which every level, except possibly the last, is filled, and all nodes are as far left as possible.
**Input:**
```
        1
       / \
      2   3
     / \ / 
    4  5 6  
```
**Output:** `Complete Binary Tree`

**Input:**
```
        1
       / \
      2   3
     / \   \
    4  5    6
```
**Output:** `Not a Complete Binary Tree`

**Program:**
```java
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    TreeNode root;

    public boolean isComplete(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if (end) return false;
                queue.add(node.left);
            } else {
                end = true;
            }

            if (node.right != null) {
                if (end) return false;
                queue.add(node.right);
            } else {
                end = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);

        System.out.println("Output: " + (tree.isComplete(tree.root) ? "Complete Binary Tree" : "Not a Complete Binary Tree"));

        tree.root.right.left = null;
        tree.root.right.right = new TreeNode(6);

        System.out.println("Output: " + (tree.isComplete(tree.root) ? "Complete Binary Tree" : "Not a Complete Binary Tree"));
    }
}
```

### Q3: Given the root of a binary tree, return the reverse level order traversal of its nodes' values. The solution should consider the binary tree nodes level by level in bottom-up order from left to right, i.e., process all nodes of the last level first, followed by all nodes of the second last level, and so on.
**Input:**
```
        1
       / \
      2   3
     / \ / \
    4  5 6  7
      /
     8
```
**Output:** `[7, 8, 4, 5, 6, 2, 3, 1]`

**Program:**
```java
import java.util.*;

public class ReverseLevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }

    TreeNode root;

    public List<Integer> reverseLevelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            stack.push(node);

            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop().val);
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.left.right.left = new TreeNode(8);

        List<Integer> result = tree.reverseLevelOrderTraversal(tree.root);
        System.out.println("Output: " + result); // Output: [7, 8, 4, 5, 6, 2, 3, 1]
    }
}
```
