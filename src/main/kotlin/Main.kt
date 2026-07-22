package org.example

fun main() {
    val d = dijkstra()
    val ip = IntervalPartitioning()
    val bs = BinarySearch()
    val mi = MockInterview()

    val G: Array<MutableList<Pair<Int, Int>>> = Array(5) { mutableListOf() }
    G[0].add(Pair(1, 4))
    G[0].add(Pair(2, 1))
    G[2].add(Pair(1, 2))
    G[1].add(Pair(3, 1))
    G[2].add(Pair(3, 5))
    G[3].add(Pair(4, 3))

    val I: List<Pair<Int, Int>> = listOf(
        Pair(1, 4),  // A
        Pair(2, 6),  // B
        Pair(5, 8),  // C
        Pair(7, 9),  // D
        Pair(3, 5)   // E
    )

    val arr =  intArrayOf(4,5,6,7,0,1,2)

    println(d.dijkstra(G, 0).contentToString())
    println(d.dijkstraHeap(G, 0).contentToString())

    println(ip.intervalPartioning(I).toString())
    println(bs.rotatedArrayBinarySearch(arr, target = 0).toString())

    println(mi.dijkstraClassic(G, 0).contentToString())
    println(mi.dijkstraHeap(G, 0).contentToString())

}