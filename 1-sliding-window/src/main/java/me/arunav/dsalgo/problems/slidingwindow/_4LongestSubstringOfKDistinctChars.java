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

        for (char c : charArray) {
            map.put(c, (map.getOrDefault(c, 0) + 1));
            if (map.size() <= K) {
                maxLength = Math.max(maxLength, endIdx - startIdx + 1);
            }
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
