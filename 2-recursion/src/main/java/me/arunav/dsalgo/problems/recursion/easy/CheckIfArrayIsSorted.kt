package me.arunav.dsalgo.problems.recursion.easy

fun isArraySorted(arr: IntArray, idx: Int): Boolean {
    if (idx == arr.size - 1) return true
    if (arr[idx] > arr[idx+1]) return false
    return isArraySorted(arr, idx + 1)
}

fun main() {
    val arr = intArrayOf(1, 2, 3, 7)
    println("Is the given array sorted = ${isArraySorted(arr, 0)}")
}