package me.arunav.dsalgo.problems.slidingwindow;

/*
 * Given an array of characters where each character represents a fruit type, you are given two baskets and your goal
 * is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one
 * type of fruit. You can start with any tree, but once you have started you can’t skip a tree. You will pick one
 * fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 */

import java.util.HashMap;
import java.util.Map;

public class _5MaxFruitsCountOf2Types {

    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    public static int findLength(char[] arr) {
        int length = 0;
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char firstCharInWindow = arr[start];
                map.put(firstCharInWindow, map.get(firstCharInWindow) - 1);
                if (map.get(firstCharInWindow) == 0)
                    map.remove(firstCharInWindow);
                start++;
            }
            length = Math.max(length, end - start + 1);
            end++;
        }
        System.out.println(map.toString());
        return length;
    }
}
