package me.arunav.dsalgo.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _4LongestSubstringOfKDistinctChars {

    public static void main(String[] args) {
        System.out.println(findLongestSubstringLength("araaci", 2));
        System.out.println(findLongestSubstringLength("araaci", 1));
        System.out.println(findLongestSubstringLength("cbbebi", 3));
    }

    private static int findLongestSubstringLength(String str, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, startIdx = 0, endIdx = 0;
        char[] charArray = str.toCharArray();

        // Sliding Window Pattern
        for (char c : charArray) {
            // Load the char in a map and increment the no. of times present by 1
            map.put(c, (map.getOrDefault(c, 0) + 1));

            // If the number of distinct characters (size of map) <= K, then calculate maxLength
            if (map.size() <= K) {
                maxLength = Math.max(maxLength, endIdx - startIdx + 1);
            }

            // While the  number of distinct characters (size of the map) >= K, then increment the sliding window
            // starting index and also reduce the count of the chars in that index from the map
            while (map.size() > K) {
                char startingCharInWindow = charArray[startIdx];
                int count = map.get(startingCharInWindow);
                if (count > 1)
                    map.put(startingCharInWindow, count - 1);
                else
                    map.remove(startingCharInWindow);
                startIdx++;
            }
            endIdx++;
        }
        return maxLength;
    }
}
