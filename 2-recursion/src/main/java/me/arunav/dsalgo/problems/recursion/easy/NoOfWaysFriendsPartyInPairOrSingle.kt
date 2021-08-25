package me.arunav.dsalgo.problems.recursion.easy


/*

- If only 1 person go to a party then the no. of ways is 1
- If 2 persons (X & Y) go to a party then the no. of ways is 2 -
    - X & Y go in a pair
    - X goes alone, Y goes alone

4 people (A, B, C, D) can go to a party in pairs or single.

No. of ways they can go depends upon the choices one can make at a given point of time.
Let's assume f(N) returns the no. of ways N people can go to a party.
Based on this assumption A can make either of the 2 choices -
1. A can choose to go alone, then B, C, D can go in f(N-1) ways
2. A can choose to go in a pair,
    i. A can pair with B, then C & D can go in f(N-2) ways
    ii. A can pair with C, then B & D can go in f(N-2) ways
    iii. A can pair with D, then C & B can go in f(N-2) ways
    When A decides to go in pair it also decides for the other person whom it is pairing with.
    Since A can pair with (N-1) people,
        so the total no. of ways A can pair with any of the other person is (N-1) * f(N-2)
So total number of ways A can go to a party is f(N-1) + (N-1) * f(N-2)

*/

fun noOfWaysFriendsGoInPairOrSingle(n: Int): Int {
    if (n == 1 || n == 2) return n
    return noOfWaysFriendsGoInPairOrSingle(n - 1) + (n - 1) * noOfWaysFriendsGoInPairOrSingle(n - 2)
}

fun main() {
    val noOfPeople = 4
    println("No. of ways $noOfPeople people can party are ${noOfWaysFriendsGoInPairOrSingle(noOfPeople)}")
}