
### Q1: Rearrange Characters of String

**Problem:** Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same. Return any possible rearrangement or return an empty string if not possible.

**Example 1:**
- **Input:** `s = "aab"`
- **Output:** `"aba"`

**Example 2:**
- **Input:** `s = "aaab"`
- **Output:** `""`

**Solution:**
```python
import heapq
from collections import Counter

def reorganize_string(s: str) -> str:
    count = Counter(s)
    max_heap = [(-freq, char) for char, freq in count.items()]
    heapq.heapify(max_heap)
    
    prev_char = None
    prev_freq = 0
    result = []
    
    while max_heap:
        freq, char = heapq.heappop(max_heap)
        result.append(char)
        
        if prev_char is not None:
            heapq.heappush(max_heap, (prev_freq, prev_char))
        
        freq += 1
        if freq < 0:
            prev_char = char
            prev_freq = freq
        else:
            prev_char = None
    
    return ''.join(result) if len(result) == len(s) else ""

# Example usage:
s = "aab"
print(reorganize_string(s))  # Output: "aba"
```

### Q2: K Pairs with Smallest Sums

**Problem:** You are given two integer arrays `nums1` and `nums2` sorted in ascending order and an integer `k`. Return the `k` pairs `(u1, v1), (u2, v2), ..., (uk, vk)` with the smallest sums.

**Example 1:**
- **Input:** `nums1 = [1,7,11]`, `nums2 = [2,4,6]`, `k = 3`
- **Output:** `[(1,2),(1,4),(1,6)]`

**Example 2:**
- **Input:** `nums1 = [1,1,2]`, `nums2 = [1,2,3]`, `k = 2`
- **Output:** `[(1,1),(1,1)]`

**Example 3:**
- **Input:** `nums1 = [1,2]`, `nums2 = [3]`, `k = 3`
- **Output:** `[(1,3),(2,3)]`

**Solution:**
```python
import heapq

def k_smallest_pairs(nums1, nums2, k):
    if not nums1 or not nums2 or k == 0:
        return []
    
    min_heap = []
    for i in range(min(k, len(nums1))):
        heapq.heappush(min_heap, (nums1[i] + nums2[0], i, 0))
    
    result = []
    while k > 0 and min_heap:
        sum, i, j = heapq.heappop(min_heap)
        result.append((nums1[i], nums2[j]))
        if j + 1 < len(nums2):
            heapq.heappush(min_heap, (nums1[i] + nums2[j + 1], i, j + 1))
        k -= 1
    
    return result

# Example usage:
nums1 = [1, 7, 11]
nums2 = [2, 4, 6]
k = 3
print(k_smallest_pairs(nums1, nums2, k))  # Output: [(1, 2), (1, 4), (1, 6)]
```

### Q3: Maximum Score from Piles

**Problem:** You are given three integers `a`, `b`, and `c` representing three piles of stones. Each turn you choose two different non-empty piles, take one stone from each, and add 1 point to your score. Return the maximum score you can get.

**Example 1:**
- **Input:** `a = 2`, `b = 4`, `c = 6`
- **Output:** `6`

**Example 2:**
- **Input:** `a = 4`, `b = 4`, `c = 6`
- **Output:** `7`

**Solution:**
```python
def maximum_score(a, b, c):
    if a < b:
        a, b = b, a
    if a < c:
        a, c = c, a
    if b < c:
        b, c = c, b
    
    if a >= b + c:
        return b + c
    return (a + b + c) // 2

# Example usage:
a = 2
b = 4
c = 6
print(maximum_score(a, b, c))  # Output: 6
```

### Q4: Kth Smallest Sum in Matrix

**Problem:** You are given an `m x n` matrix `mat` that has its rows sorted in non-decreasing order and an integer `k`. You are allowed to choose exactly one element from each row to form an array. Return the `k`-th smallest array sum.

**Example 1:**
- **Input:** `mat = [[1,3,11],[2,4,6],[5,6,7]]`, `k = 5`
- **Output:** `7`

**Example 2:**
- **Input:** `mat = [[1,3,11],[2,4,6],[5,6,7]]`, `k = 9`
- **Output:** `17`

**Example 3:**
- **Input:** `mat = [[1,10,10],[1,4,5],[2,3,6]]`, `k = 7`
- **Output:** `9`

**Solution:**
```python
import heapq

def kth_smallest_sum(mat, k):
    m, n = len(mat), len(mat[0])
    min_heap = [(sum(row[0] for row in mat), [0] * m)]
    visited = set()
    visited.add(tuple([0] * m))

    for _ in range(k):
        current_sum, indices = heapq.heappop(min_heap)
        for i in range(m):
            new_indices = indices[:]
            new_indices[i] += 1
            if new_indices[i] < n and tuple(new_indices) not in visited:
                heapq.heappush(min_heap, (current_sum - mat[i][indices[i]] + mat[i][new_indices[i]], new_indices))
                visited.add(tuple(new_indices))
    
    return current_sum

# Example usage:
mat = [[1, 3, 11], [2, 4, 6], [5, 6, 7]]
k = 5
print(kth_smallest_sum(mat, k))  # Output: 7
```

### Q5: Median of Data Stream

**Problem:** Given that integers are read from a data stream, find the median of all elements read so far efficiently.

**Example:**
- After reading 1st element of stream `5` → median = `5`
- After reading 2nd element of stream `5, 15` → median = `10`
- After reading 3rd element of stream `5, 15, 1` → median = `5`
- After reading 4th element of stream `5, 15, 1, 3` → median = `4`

**Solution:**
```python
import heapq

class MedianFinder:
    def __init__(self):
        self.small = []  # Max heap
        self.large = []  # Min heap

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -num)
        if self.small and self.large and (-self.small[0] > self.large[0]):
            heapq.heappush(self.large, -heapq.heappop(self.small))
        
        if len(self.small) > len(self.large) + 1:
            heapq.heappush(self.large, -heapq.heappop(self.small))
        if len(self.large) > len(self.small):
            heapq.heappush(self.small, -heapq.heappop(self.large))

    def findMedian(self) -> float:
        if len(self.small) > len(self.large):
            return -self.small[0]
        return (-self.small[0] + self.large[0]) / 2

# Example usage:
finder = MedianFinder()
finder.addNum(5)
finder.addNum(15)
print(finder.findMedian())  # Output: 10
finder.addNum(1)
print(finder.findMedian())  # Output: 5
finder.addNum(3)
print(finder.findMedian())  # Output: 4
```
