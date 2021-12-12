package me.arunav.dsalgo.problems.recursion._3print

fun binaryStringsWithoutConsecutive1s(n: Int, osf: String) {
    if (n < 1) {
        println(osf)
        return
    }
    binaryStringsWithoutConsecutive1s(n - 1, "0$osf")
    if (osf.isEmpty())
        binaryStringsWithoutConsecutive1s(n - 1, "1$osf")
    else if (osf[0] != '1')
        binaryStringsWithoutConsecutive1s(n - 1, "1$osf")
}

fun main() {
    val num = 5
    binaryStringsWithoutConsecutive1s(num, "")
}