### Q1: Kth Largest Element Using Priority Queue

**Problem:** Given an integer array, find the `k`-th largest element using a priority queue.

**Example 1:**
- **Input:** `arr = [3,2,1,5,6,4]`, `k = 2`
- **Output:** `5`

**Example 2:**
- **Input:** `arr = [3,2,3,1,2,4,5,5,6]`, `k = 4`
- **Output:** `4`

**Solution:**
```java
import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(kthLargest.findKthLargest(arr1, k1)); // Output: 5

        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(kthLargest.findKthLargest(arr2, k2)); // Output: 4
    }
}
```

### Q2: Minimum Cost to Connect Ropes

**Problem:** Given `n` ropes of different lengths, connect them into a single rope with minimum cost. Assume that the cost to connect two ropes is the same as the sum of their lengths.

**Example:**
- **Input:** `ropes = [5, 4, 2, 8]`
- **Output:** `The minimum cost is 36`

**Solution:**
```java
import java.util.PriorityQueue;

public class ConnectRopes {
    public int minCostToConnectRopes(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        ConnectRopes connectRopes = new ConnectRopes();
        int[] ropes = {5, 4, 2, 8};
        System.out.println(connectRopes.minCostToConnectRopes(ropes)); // Output: 36
    }
}
```

### Q3: K Most Frequent Strings

**Problem:** Given an array of strings `words` and an integer `k`, return the `k` most frequent strings. Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

**Example 1:**
- **Input:** `words = ["i", "love", "leetcode", "i", "love", "coding"]`, `k = 2`
- **Output:** `["i", "love"]`

**Example 2:**
- **Input:** `words = ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]`, `k = 4`
- **Output:** `["the", "is", "sunny", "day"]`

**Solution:**
```java
import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if (count.get(a).equals(count.get(b))) {
                return b.compareTo(a);
            }
            return count.get(a) - count.get(b);
        });

        for (String word : count.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(topKFrequentWords.topKFrequent(words1, k1)); // Output: ["i", "love"]

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(topKFrequentWords.topKFrequent(words2, k2)); // Output: ["the", "is", "sunny", "day"]
    }
}
```

### Q4: Last Stone Weight

**Problem:** You are given an array of integers `stones` where `stones[i]` is the weight of the `i`-th stone. On each turn, choose the heaviest two stones and smash them together. Return the weight of the last remaining stone. If there are no stones left, return `0`.

**Example 1:**
- **Input:** `stones = [2, 7, 4, 1, 8, 1]`
- **Output:** `1`

**Example 2:**
- **Input:** `stones = [1]`
- **Output:** `1`

**Solution:**
```java
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second) {
                maxHeap.add(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight.lastStoneWeight(stones1)); // Output: 1

        int[] stones2 = {1};
        System.out.println(lastStoneWeight.lastStoneWeight(stones2)); // Output: 1
    }
}
```
