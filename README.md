# Data Structure & Algorithm Patterns & Problems

> Problems on Data Structure &amp; Algorithms

## 1. Sliding Window 

### [LC-Easy: 643. Maximum _Average_ Subarray](https://leetcode.com/problems/maximum-average-subarray-i/)

If you observe closely, you will realize that to calculate the sum of a contiguous subarray we can utilize the sum of the previous subarray. For this, consider each subarray as a Sliding Window of size ‘k’. To calculate the sum of the next subarray, we need to slide the window ahead by one element. So to slide the window forward and calculate the sum of the new position of the sliding window, we need to do two things:

- Subtract the element going out of the sliding window i.e., subtract the first element of the window.
- Add the new element getting included in the sliding window i.e., the element coming right after the end of the window.

### [LC-Medium: 209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

1. First, we will add-up elements from the beginning of the array until their sum becomes greater than or equal to ‘S’.
2. These elements will constitute our sliding window. We are asked to find the smallest such window having a sum greater than or equal to ‘S’. We will remember the length of this window as the smallest window so far.
3. After this, we will keep adding one element in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
4. In each step, we will also try to shrink the window from the beginning. We will shrink the window until the window’s sum is smaller than ‘S’ again. This is needed as we intend to find the smallest window. This shrinking will also happen in multiple steps; in each step we will do two things:
    - Check if the current window length is the smallest so far, and if so, remember its length.
    - Subtract the first element of the window from the running sum to shrink the sliding window.

### [LC-Hard: 340. Longest Substring with _At Most K Distinct Characters_](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

1. Insert characters from the beginning of the string until we have ‘K’ distinct characters in a HashMap.
2. These characters will constitute our sliding window. We are asked to find the longest such window having no more than ‘K’ distinct characters. We will remember the length of this window as the longest window so far.
3. After this, we will keep adding one character in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
4. In each step, we will try to shrink the window from the beginning if the count of distinct characters in the HashMap is larger than ‘K’. We will shrink the window until we have no more than ‘K’ distinct characters in the HashMap. This is needed as we intend to find the longest window.
5. While shrinking, we’ll decrement the frequency of the character going out of the window and remove it from the HashMap if its frequency becomes zero.
6. At the end of each step, we’ll check if the current window length is the longest so far, and if so, remember its length.

### [LC-Medium: 3. Longest Substring _Without Repeating Characters_](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

- Trick is finding the starting Index in the Window. When a repeating character is found then - "the next character after the repeating character becomes the starting index, if that character is in the window, or else starting Window doesn't change because the character found is not part of the current window".

### [LC-Medium: 424. Longest repeating Substring after _replacing k characters_](https://leetcode.com/problems/longest-repeating-character-replacement/)

- Find a window that has the maximum number of repeating characters and no other characters in it.
- At any point of time if the number of repeating characters in the window is less than the max no. of replacable characters, then we need to move the starting index of the window.
- [Explanation](https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation)

### [LC-Hard: 395. Longest Substring with _At Least K Repeating Characters_](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)