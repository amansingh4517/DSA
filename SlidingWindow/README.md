# Sliding Window Algorithm

The **Sliding Window** technique is used to solve problems involving arrays, lists, or strings where we need to find a contiguous subarray or substring in $O(N)$ complexity.

### Key Points:
* **Fixed Sliding Window**: Fixed window $\rightarrow$ Minimize/Maximize condition
* **Variable Sliding Window**: Fixed condition $\rightarrow$ Minimize/Maximize window

---

## Types of Sliding Window

### FIX SIZE SLIDING WINDOW
In this, the size of the window is given (fixed) and we are asked to minimize or maximize the condition for that $k$-size sliding window.

| Problem | Solution |
| :--- | :--- |
| [Maximum Sum Subarray of Size K](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1) | [Java](./MaximumSumSubarrayOfSizeK.java) |
| [First Negative Integer in Every Window of Size K](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1) | [Java](./FirstNegativeInEveryWindowOfSizeK.java) |

---

### VARIABLE SIZE SLIDING WINDOW
In this, the condition is fixed and we are asked to satisfy that condition by minimizing or maximizing the window size.

| Problem | Solution |
| :--- | :--- |
| [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | `-` |
| [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | `-` |
| [Longest Substring with K Distinct Characters](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1) | `-` |
