package me.arunav.dsalgo.problems.recursion._2easy

// Time Complexity O(b)
fun power(a: Int, b: Int): Int {
    if (b == 0) return 1
    if (b == 1) return a
    return a * power(a, b - 1)
}

// Time Complexity O(log b)
fun optimizedPower(a: Int, b: Int): Int {
    if (b == 0) return 1
    if (b == 1) return a
    val temp = optimizedPower(a, b / 2)
    return if (b % 2 == 1) a * temp * temp else temp * temp
}

fun main() {
    val a = 2
    val b = 19
    println("Power of $a^$b is ${power(a, b)}")
    println("Power of $a^$b is ${optimizedPower(a, b)}")
}