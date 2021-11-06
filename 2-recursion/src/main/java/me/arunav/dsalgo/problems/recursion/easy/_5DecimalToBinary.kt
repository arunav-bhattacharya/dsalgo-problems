package me.arunav.dsalgo.problems.recursion.easy

fun main() {
    val n = 50
    println(decToBin(n, StringBuilder()))
}

private fun decToBin(n: Int, result: StringBuilder): Int {
    return if (n <= 1) result.append(n).reverse().toString().toInt() else decToBin(n / 2, result.append(n % 2))
}
