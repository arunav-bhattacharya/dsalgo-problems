package me.arunav.dsalgo.problems.recursion.print

fun subsets(arr: IntArray, curr: String, idx: Int) {
    if (idx == arr.size) {
        println("[$curr]")
        return
    }
    subsets(arr, curr, idx + 1)
    val modified =
        if (curr.isEmpty()) "${arr[idx]}"
        else "$curr,${arr[idx]}"
    subsets(arr, modified, idx + 1)
}

fun main() {
    val arr = intArrayOf(1, 2, 3)
    subsets(arr, "", 0)
}