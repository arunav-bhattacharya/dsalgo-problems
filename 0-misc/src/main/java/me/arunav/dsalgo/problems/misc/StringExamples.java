package me.arunav.dsalgo.problems.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class StringExamples {

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(StringExamples::compare);

    public static void main(String[] args) {
        String str = " How are   you   doing today ";
        splitStrings(str);
        System.out.println(substr("ADOBECODEBANC", "ABC"));
    }

    private static String substr(String s, String t){
        return s.substring(1, t.length());
    }

    private static void splitStrings(String str) {

        Arrays.stream(str.split("\\s+"))
//                .filter(s -> s.length() > 0)
                .forEach(System.out::println);

        List<String> splitStrings = Arrays.stream(str.split(" "))
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int i = splitStrings.size() - 1; i >= 0; i--) {
            if (i > 0)
                sb.append(splitStrings.get(i))
                        .append(" ");
            else
                sb.append(splitStrings.get(i));
        }
        System.out.println(sb.toString());
    }

    private static int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        return entry2.getValue().compareTo(entry1.getValue());
    }
}
