package me.arunav.dsalgo.problems.recursion._3print

/*

* * * * *
* * * *
* * *
* *
*

*/

fun printPattern1(nRows: Int, nCols: Int) {
    if (nRows == 0) return
    if (nCols == nRows) {
        // Change row
        println()
        printPattern1(nRows - 1, 0)
    } else {
        // Print in each column in a row
        print("* ")
        printPattern1(nRows, nCols + 1)
    }
}

/*

*
* *
* * *
* * * *
* * * * *

*/

fun printPattern2(total: Int, nRows: Int, nCols: Int) {
    if (nRows == total) return

    if (nRows >= nCols) {
        // Print * to a column in the current row
        print("* ")
        printPattern2(total, nRows, nCols + 1)
    } else {
        // Change the row
        println()
        printPattern2(total, nRows + 1, 0)
    }
}

fun main() {
    val rows = 5
    printPattern1(rows, 0)
    println()
    printPattern2(rows, 0, 0)
}