/*
Question.Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
Solution:
To solve the problem of returning numbers from 1 to n in lexicographical order in O(n) time and O(1) extra space, you need a few key prerequisites:

⸻

📚 Prerequisites :

1. Understanding Lexicographical Order
	•	It’s the order used in dictionaries.
	•	For numbers, this means: 1, 10, 100, 101, ..., 109, 11, ..., 19, 2, 20, ...
	•	Not based on numerical size, but on string comparison:

1 < 10 < 100 < 101 < 11 < 2 < 3 < ...



⸻

2. Depth-First Traversal (DFS) Pattern
	•	The idea is to treat this as a DFS traversal of a tree where:
	•	The root nodes are digits 1 through 9.
	•	Each node curr has 10 children: curr*10 to curr*10 + 9 (if ≤ n).
	•	DFS traversal of this tree gives the lexicographical order.

⸻

3. Basic Looping and Recursion
	•	You can solve it iteratively using a while loop instead of recursion to stay within O(1) space (no recursive stack).

⸻

✅ Core Concepts to Implement:

✅ Iterative Lexical Traversal Logic
	•	Start at curr = 1
	•	If curr * 10 <= n, go deeper: curr *= 10
	•	Else if curr + 1 <= n and curr % 10 != 9, go to next sibling: curr++
	•	Else, backtrack to find the next available number.

⸻

🔧 Example Algorithm Flow for n = 13
	1.	Start with curr = 1
	2.	Go deeper: 1 → 10 → 11 → 12 → 13
	3.	Can’t go deeper than 13; backtrack and go to 2, 3, …, 9.

Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

⸻
*/
Code:
class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    int curr = 1;
    for (int i = 0; i < n; i++) {
      result.add(curr);
      if (curr * 10 < n ) {
        curr *= 10;
    } else {
        while (curr % 10 == 9 || curr + 1 > n) {//Edge cases
          curr /= 10;
    }
        curr++;
  }
    
}
      return result;
    }
}
