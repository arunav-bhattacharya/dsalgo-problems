package me.arunav.dsalgo.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _11WordConcat {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    private static List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> map = new HashMap<>();
        List<Integer> indices = new ArrayList<>();

        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        int wordLen = words[0].length();
        int substrLen = wordLen * words.length;

        for (int i=0; i<= s.length() - substrLen; i++){
            int startingWordIdx = i;
            int concatLen = i + substrLen;
            Map<String, Integer> substringWordMap = new HashMap<>();
            while(startingWordIdx < concatLen){
                String word = s.substring(startingWordIdx, startingWordIdx + wordLen);
                if (!map.containsKey(word))
                    break;
                substringWordMap.put(word, substringWordMap.getOrDefault(word, 0) + 1);
                startingWordIdx = startingWordIdx + wordLen;
            }
            if (map.equals(substringWordMap))
                indices.add(i);
        }
        return indices;
    }
}