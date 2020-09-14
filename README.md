# Data Structure & Algorithm Patterns & Problems

> Problems on Data Structure &amp; Algorithms

## 1. Sliding Window 

### 1.a. Longest Substring of K Distinct Chars:

1. Insert characters from the beginning of the string until we have ‘K’ distinct characters in a HashMap.
2. These characters will constitute our sliding window. We are asked to find the longest such window having no more than ‘K’ distinct characters. We will remember the length of this window as the longest window so far.
3. After this, we will keep adding one character in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
4. In each step, we will try to shrink the window from the beginning if the count of distinct characters in the HashMap is larger than ‘K’. We will shrink the window until we have no more than ‘K’ distinct characters in the HashMap. This is needed as we intend to find the longest window.
5. While shrinking, we’ll decrement the frequency of the character going out of the window and remove it from the HashMap if its frequency becomes zero.
6. At the end of each step, we’ll check if the current window length is the longest so far, and if so, remember its length.

### 1.b. Longest substring which has no repeating characters

- Trick is finding the starting Index in the Window. When a repeating character is found then - "the next character after the repeating character becomes the starting index if that character is in the window, or else starting Window doesn't change because the character found is not part of the current window"

- [x] [LC-Easy-643](https://leetcode.com/problems/maximum-average-subarray-i/)
- [x] [LC-Hard-340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)
- [x] [LC-Medium-3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [ ] [LC-Hard-395](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)