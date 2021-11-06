package me.arunav.dsalgo.problems.misc;

public class IntegerExample {

    public static void main(String[] args) {
        System.out.println(compareIntegersWithEquals(127, 127));
        System.out.println(compareIntegersWithEquals(128, 128));
        System.out.println(compareIntegersWithEquals(-129, -129));
        System.out.println(compareIntegersWithEquals(-128, -128));

        System.out.println(compareIntegersWithOperator(127, 127));
        System.out.println(compareIntegersWithOperator(128, 128));
        System.out.println(compareIntegersWithOperator(-129, -129));
        System.out.println(compareIntegersWithOperator(-128, -128));

    }

    private static boolean compareIntegersWithEquals(Integer a, Integer b) {
        return a.equals(b);
    }

    private static boolean compareIntegersWithOperator(Integer a, Integer b) {
        return a == b;
    }
}
