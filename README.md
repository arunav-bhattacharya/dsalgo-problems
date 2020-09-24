# Data Structure & Algorithm Patterns & Problems

> - **Resources**:
>   - https://leetcode.com/problemset/all/
>   - https://www.educative.io/courses/grokking-the-coding-interview
>   - https://algo.monster/problems/stats
>   - https://emre.me/
>
> - **Patterns**: (154)
>   1. Sliding Window (11)
>   2. Two Pointers (11)
>   3. Fast & Slow pointers (7)
>   4. Merge Intervals (7)
>   5. Cyclic Sort (8)
>   6. In-place Reversal of a LinkedList (5)
>   7. Tree Breadth First Search (9)
>   8. Tree Depth First Search (7)
>   9. Two Heaps (4)
>   10. Subsets (9)
>   11. Modified Binary Search (10)
>   12. Bitwise XOR (4)
>   13. Top 'K' Elements (14)
>   14. K-way merge (5)
>   15. 0/1 Knapsack (DP) (6)
>   16. Unbounded Knapsack (DP) (5)
>   17. Fibonacci Numbers (DP) (6)
>   18. Palindromic Subsequence (DP) (5)
>   19. Longest Common Substring (DP) (13)
>   20. Topological Sort (Graph) (7)
>   21. Connected components (Graph) (1)
>
> - **Additional Patterns**:
>   - Trie
>   - Substring search
>   - Union Find
>   - Greedy
>   - Divide & Conquer
>   - Combinatorial DFS 

    
## I. Sliding Window 

### Types of problems 

- Fixed Length window
    - Max Sum/Avg Subarray of Size K (643)
- Dynamic Length window
    - Smallest subarray of sum >= to some value S (209)
    - Fruits into basket (904)
    - Maximum Consecutive Ones (1004)
- Dynamic Length window with Additional Data structure
    - Longest Substring length with no more than K distinct characters (340)
    - Longest Substring Without Repeating Characters (3)
    - Longest repeating Character Replacement (424)
- String permutation
    - Find All Anagrams in a String (438)
    - Find if a string contains any Permutation of a pattern (567)
    - Smallest Window substring (76)
    - Word concatenation (30)
    
### How to identify them ?

- Things we iterate over sequentially
    - Contiguous sequence of elements
    - Strings, arrays, linked lists
- Looking for some sub-range like Min, Max, Longest, Shortest, Contained
    - Maybe we need to calculate something
    
### Some common problems        
    
#### 1. [LC-Easy: 643. Maximum _Average_ Subarray](https://leetcode.com/problems/maximum-average-subarray-i/)

If you observe closely, you will realize that to calculate the sum of a contiguous subarray we can utilize the sum of the previous subarray. For this, consider each subarray as a Sliding Window of size `‘k’`. To calculate the sum of the next subarray, we need to slide the window ahead by one element. So to slide the window forward and calculate the sum of the new position of the sliding window, we need to do two things:

- Subtract the element going out of the sliding window i.e., subtract the first element of the window.
- Add the new element getting included in the sliding window i.e., the element coming right after the end of the window.

#### 2. [LC-Medium: 209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

- First, we will add-up elements from the beginning of the array until their sum becomes greater than or equal to `‘S’`.
- These elements will constitute our sliding window. We are asked to find the smallest such window having a sum greater than or equal to `‘S’`. We will remember the length of this window as the smallest window so far.
- After this, we will keep adding one element in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
- In each step, we will also try to shrink the window from the beginning. We will shrink the window until the window’s sum is smaller than `‘S’` again. This is needed as we intend to find the smallest window. This shrinking will also happen in multiple steps; in each step we will do two things:
    - Check if the current window length is the smallest so far, and if so, remember its length.
    - Subtract the first element of the window from the running sum to shrink the sliding window.

#### 3. [LC-Medium: 904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

Similar to the previous problem

#### 4. [LC-Hard: 340. Longest Substring with _At Most K Distinct Characters_](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

- Insert characters from the beginning of the string until we have `‘K’` distinct characters in a HashMap.
- These characters will constitute our sliding window. We are asked to find the longest such window having no more than `‘K’` distinct characters. We will remember the length of this window as the longest window so far.
- After this, we will keep adding one character in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
- In each step, we will try to shrink the window from the beginning if the count of distinct characters in the HashMap is larger than `‘K’`. We will shrink the window until we have no more than `‘K’` distinct characters in the HashMap. This is needed as we intend to find the longest window.
- While shrinking, we’ll decrement the frequency of the character going out of the window and remove it from the HashMap if its frequency becomes zero.
- At the end of each step, we’ll check if the current window length is the longest so far, and if so, remember its length.

#### 5. [LC-Medium: 3. Longest Substring _Without Repeating Characters_](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

- Trick is finding the starting Index in the Window. When a repeating character is found then - "the next character after the repeating character becomes the starting index, if that character is in the window, or else starting Window doesn't change because the character found is not part of the current window".

#### 6. [LC-Medium: 424. Longest repeating Substring after _replacing k characters_](https://leetcode.com/problems/longest-repeating-character-replacement/)

- Find a window that has the maximum number of repeating characters and no other characters in it.
- At any point of time if the number of repeating characters in the window is less than the max no. of replacable characters, then we need to move the starting index of the window.

[Leetcode Solution](https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation)

#### 7. [LC-Medium: 1004. Maximum Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones-iii/)

We’ll iterate through the array to add one number at a time in the window. We’ll also keep track of the maximum number of repeating 1s in the current window (`maxOnesCount`). So at any time, we know that we can have a window which has 1s repeating `maxOnesCount` time, so we should try to replace the remaining 0s. If we have more than `‘k’` remaining 0s, we should shrink the window as we are not allowed to replace more than `‘k’` 0s.

#### 8. [LC-Medium: 567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)

For a string to be a permutation of another string it must satisfy the following 3 conditions -

- The **length** of the original string and the permuted string should be the same.
- The **number of the unique characters** in the original and the permuted string should be the same.
- The **frequency of each of the unique characters** in the original string and the permuted string should be the same.

Based on these properties and using Sliding Window technique, we can solve this problem.

[Leetcode Solution](https://leetcode.com/problems/permutation-in-string/discuss/859923/Simple-Java-O(N)-solution-using-Hashmap-with-explanation)

#### 9. [LC-Medium: 438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

Similar to the previous problem.

#### 10. [LC-Hard: 76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

- First search for the window that satisfies the substring in the main string by increasing the end pointer.
- Once the search string is found, minimize the window by moving the start pointer until the window does not satisfy the substring.
- Do this until end of string, and calculate and hold the minimum string on the way.

[Video Explanation](https://www.youtube.com/watch?v=eS6PZLjoaq8)

[Leetcode Solution](https://leetcode.com/problems/minimum-window-substring/discuss/861236/Simple-Java-O(N)-hashmap-%2B-sliding-window-solution-with-explanation-11ms)

#### 11. [LC-Hard: 30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

- Search for each word in given string in every substring window of length = sum of length of concatenated words from words[].
- Whenever all the words are found in the substring window, then we store the starting index of that substring window.

[Leetcode Solution](https://leetcode.com/problems/substring-with-concatenation-of-all-words/discuss/862010/Simple-Java-Solution-with-explanation-using-2-HashMaps-O(m*N)-(m-no.-of-words-in-words))

<br/>

### Practice Problems:

1. [LC-Medium: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)
2. [LC-Medium: 395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
3. [LC-Hard: 239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
4. [LC-Hard: 480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/)
5. [LC-Hard: 727. Minimum Window Subsequence](https://leetcode.com/problems/minimum-window-subsequence/)
6. [LC-Hard: 1074. Number of Submatrices That Sum to Target](https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/)

<br/>

## II. Two Pointers

## III. Fast & Slow Pointers

## IV. Merge Intervals

## V. Cyclic Sort

## VI. Linked List

## VII. Breadth First Search

## VIII. Depth First Search

## IX. Two Heaps

## X. Subsets

## XI. Binary Search

## XII. Bitwise XOR

## XIII. Top `K` elements

## XIV. `K` way merge

## XV. Dynamic Programming - 0/1 Knapsack

## XVI. Dynamic Programming - Unbounded Knapsack

## XVII. Dynamic Programming - Fibonacci Numbers

## XVIII. Dynamic Programming - Palindromic Subsequence

## XIX. Dynamic Programming - Longest Common Substring 

## XX. Topological Sort (Graph)
 

