package me.arunav.dsalgo.problems.recursion._4medium;

public class _3PermutationsOfAString {

    public static void main(String[] args) {
        String s = "ABCD";
        permutations(s, "");
    }

    private static void permutations(String s, String result) {
        if(s.isEmpty()){
            System.out.println(result);
            return;
        }

        for(int i=0; i < s.length(); i++){
            String newStr = s.substring(0, i) + s.substring(i+1);
            permutations(newStr, result + s.charAt(i));
        }
    }
}
