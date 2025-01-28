### Q1: Implement a Map in Java which takes the input and print the list in sorted order based on key.
**Input:** `5=Rahul, 7=Lakshman, 1=Ram, 4=Krrish, 2=Lakshay`  
**Output:** `{1=Ram, 2=Lakshay, 4=Krrish, 5=Rahul, 7=Lakshman}`

**Program:**
```java
import java.util.Map;
import java.util.TreeMap;

public class SortMapByKey {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(5, "Rahul");
        map.put(7, "Lakshman");
        map.put(1, "Ram");
        map.put(4, "Krrish");
        map.put(2, "Lakshay");

        System.out.println("Sorted Map based on keys: " + map);
    }
}
```

### Q2: Implement a Map in Java which takes the input and print the list in sorted order based on value.
**Input:** `5=Rahul, 7=Lakshman, 1=Ram, 4=Krrish, 2=Lakshay`  
**Output:** `{Krrish=4, Lakshay=2, Lakshman=7, Rahul=5, Ram=1}`

**Program:**
```java
import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(5, "Rahul");
        map.put(7, "Lakshman");
        map.put(1, "Ram");
        map.put(4, "Krrish");
        map.put(2, "Lakshay");

        List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Sorted Map based on values: " + sortedMap);
    }
}
```

### Q3: Detect if an Array contains a duplicate element. At most one duplicate would be there.
**Input 1:** `[1, 2, 3, 4, 5]`  
**Output 1:** `No`

**Input 2:** `[1, 2, 3, 4, 4]`  
**Output 2:** `Yes`

**Program:**
```java
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Output 1: " + containsDuplicate(arr1));

        int[] arr2 = {1, 2, 3, 4, 4};
        System.out.println("Output 2: " + containsDuplicate(arr2));
    }

    public static String containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return "Yes";
            }
        }
        return "No";
    }
}
```

### Q4: Given an array nums of size n, return the majority element.
**Input:** `[3, 2, 3]`  
**Output:** `3`

**Input:** `[2, 2, 1, 1, 1, 2, 2]`  
**Output:** `2`

**Program:**
```java
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 3};
        System.out.println("Output 1: " + majorityElement(arr1));

        int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Output 2: " + majorityElement(arr2));
    }

    public static int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
```

### Q5: Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.
**Input 1:** `ransomNote = "a"`, `magazine = "b"`  
**Output 1:** `false`

**Input 2:** `ransomNote = "aa"`, `magazine = "ab"`  
**Output 2:** `false`

**Input 3:** `ransomNote = "aa"`, `magazine = "aab"`  
**Output 3:** `true`

**Program:**
```java
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println("Output 1: " + canConstruct("a", "b")); // Output 1: false
        System.out.println("Output 2: " + canConstruct("aa", "ab")); // Output 2: false
        System.out.println("Output 3: " + canConstruct("aa", "aab")); // Output 3: true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false;
            }
            magazineMap.put(c, magazineMap.get(c) - 1);
        }
        return true;
    }
}
```
