### Q1: Given a linked list and a key 'X', the task is to check if X is present in the linked list or not.

**Examples:**

**Input 1:** `X = 14`  
**Output 1:** `Yes`  
**Explanation 1:** `14 is present in the linked list.`

**Input 2:** `X = 13`  
**Output 2:** `No`  
**Explanation 2:** `13 is not present in the linked list.`

**Program:**
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(14);
        list.insert(20);

        int x = 14;
        if (list.search(x)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        x = 13;
        if (list.search(x)) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
```

### Q2: Insert a node at the given position in a linked list. We are given a pointer to a node, and the new node is inserted after the given node.

**Input:** `LL = 3 -> 2 -> 4 -> 5 -> 6`, `pointer = 2`, `value = 3`  
**Output:** `3 -> 2 -> 3 -> 4 -> 5 -> 6`

**Program:**
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " -> ");
            tnode = tnode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.insert(3);

        list.printList();

        list.insertAfter(list.head.next, 3);

        list.printList();
    }
}
```

### Q3: Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

**Example 1:**  
**Input:** `head = [1, 1, 2]`  
**Output:** `[1, 2]`

**Example 2:**  
**Input:** `head = [1, 1, 2, 3, 3]`  
**Output:** `[1, 2, 3]`

**Program:**
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " -> ");
            tnode = tnode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(1);

        list.printList();

        list.removeDuplicates();

        list.printList();
    }
}
```

### Q4: Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

**Example 1:**  
**Input:** `head = [1, 2, 2, 1]`  
**Output:** `true`

**Example 2:**  
**Input:** `head = [1, 2]`  
**Output:** `false`

**Program:**
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean isPalindrome() {
        Node slow = head, fast = head, prev = null, next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.data != prev.data) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(1);

        if (list.isPalindrome()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

### Q5: Given two numbers represented by two lists, write a function that returns the sum list. The sum list is a list representation of the addition of two input numbers.

**Example 1:**  
**Input:**  
List1: `5 -> 6 -> 3` (represents number 563)  
List2: `8 -> 4 -> 2` (represents number 842)  
**Output:**  
Resultant list: `1 -> 4 -> 0 -> 5` (represents number 1405)  
**Explanation:** `563 + 842 = 1405`

**Example 2:**  
**Input:**  
List1: `7 -> 5 -> 9 -> 4 -> 6` (represents number 75946)  
List2: `8 -> 4` (represents number 84)  
**Output:**  
Resultant list: `7 -> 6 -> 0 -> 3 -> 0` (represents number 76030)  
**Explanation:** `75946 + 84 = 76030`

**Program:**
```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node p = l1, q = l2, current = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return dummy.next;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(3);
        list1.insert(6);
        list1.insert(5);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(8);

        Node result = list1.addTwoNumbers(list1.head, list2.head);
        list1.printList(result);

        LinkedList list3 = new LinkedList();
        list3.insert(4);
        list3.insert(9);
        list3.insert(5);
        list3.insert(7);
        list3.insert(6);

        LinkedList list4 = new LinkedList();
        list4.insert(4);
        list4.insert(8);

        Node result2 = list3.addTwoNumbers(list3.head, list4.head);
        list3.printList(result2);
    }
}
```

This program defines a `Node` class to represent a node in the linked list and a `LinkedList` class to handle the operations on the linked list. The `addTwoNumbers` method is used to add two numbers represented by two linked lists and return the sum as a linked list. The `printList` method is used to print the elements of the linked list.

