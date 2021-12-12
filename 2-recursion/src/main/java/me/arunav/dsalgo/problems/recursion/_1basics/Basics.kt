package me.arunav.dsalgo.problems.recursion

fun main() {
    val num = 5
    println("Factorial of $num = ${factorial(num)}")
    println("${num}th Fibonacci = ${nthFibonacci(num)}")
    println("Printing numbers in ascending order")
    printAscending(num)
    println("Printing numbers in descending order")
    printDescending(num)
    println("Printing numbers in descending and then in ascending order")
    printDescThenAsc(num)
}

fun factorial(n: Int): Int {
    if (n == 1) return 1
    return n * factorial(n - 1)
}

fun nthFibonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    return nthFibonacci(n - 1) + nthFibonacci(n - 2)
}

fun printAscending(n: Int) {
    if (n == 0) return
    printAscending(n - 1)
    println(n)
}

fun printDescending(n: Int) {
    if (n == 0) return
    println(n)
    printDescending(n - 1)
}

fun printDescThenAsc(n: Int) {
    if (n == 1) {
        println(n)
        return
    }
    println(n)
    printDescThenAsc(n - 1)
    println(n)
}