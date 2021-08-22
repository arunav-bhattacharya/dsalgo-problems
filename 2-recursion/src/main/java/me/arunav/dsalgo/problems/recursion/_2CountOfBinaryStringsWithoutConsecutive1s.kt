package me.arunav.dsalgo.problems.recursion

/*

When n = 1, answer = 2
0
1

When n = 2, answer = 3
00
01
10

When n = 3, answer = 5
000
001
010
100
101

When n = 4, answer = 8
0000
0001
0010
0100
0101
1000
1001
1010

When n = 5, answer = 13
00000
00001
00010
00100
00101
01000
01001
01010
10000
10001
10010
10100
10101

*/

fun countOfBinaryStringsWithoutConsecutive1s(n: Int): Int {
    if (n < 1) return 0
    if (n == 1 || n == 2) return n + 1
    return countOfBinaryStringsWithoutConsecutive1s(n - 1) + countOfBinaryStringsWithoutConsecutive1s(n - 2)
}

fun main() {
    val num = 5
    println("Count of Binary Strings without consecutive Ones of length $num = ${countOfBinaryStringsWithoutConsecutive1s(num)}")
}