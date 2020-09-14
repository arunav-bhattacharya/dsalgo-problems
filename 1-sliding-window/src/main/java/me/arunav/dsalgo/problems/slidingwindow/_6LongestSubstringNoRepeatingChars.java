package me.arunav.dsalgo.problems.slidingwindow;

/*
 * Given a string, find the length of the longest substring which has no repeating characters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _6LongestSubstringNoRepeatingChars {

    public static void main(String[] args) {
        System.out.println(findLengthUsingMap("pwwkew"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("abccde"));
    }

    public static int findLength(String str) {

        int length = 0;
        int start = 0, end = 0;
        char[] charArray = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : charArray) {
            while (set.contains(c)) {
                set.remove(charArray[start]);
                start++;
            }
            set.add(c);
            length = Math.max(length, end - start + 1);
            end++;
        }
        return length;
    }

    public static int findLengthUsingMap(String str) {

        int length = 0;
        int start = 0, end = 0;
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            if (map.containsKey(c))
                // The next character after the repeating character becomes the starting index if that character is
                // in the window, or else starting Window doesn't change because the character found is not part of
                // the current window
                start = Math.max(start, map.get(c) + 1);

            map.put(c, end);
            length = Math.max(length, end - start + 1);
            end++;
        }
        return length;
    }
}
