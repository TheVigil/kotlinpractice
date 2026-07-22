package org.example

import java.util.PriorityQueue

class MockInterview {

    fun dijkstraClassic(G: Array<MutableList<Pair<Int, Int>>>, start: Int): IntArray {
        val distArr = IntArray(G.size){Int.MAX_VALUE}
        val visited = BooleanArray(G.size)
        distArr[start] = 0

        var counter = G.size
        while(counter > 0){
            val currentNode = findMinNode(distArr, visited)
            if(currentNode == -1) return distArr
            visited[currentNode] = true
            for ((neighbor, weight) in G[currentNode]){
                if(!visited[neighbor]){
                    val newDist = distArr[currentNode] + weight
                    if(distArr[neighbor] > newDist){
                        distArr[neighbor] = newDist
                    }
                }

            }
            counter--
        }
        return distArr
    }

    private fun findMinNode(distArr: IntArray, visited: BooleanArray): Int {
        var minDist = Int.MAX_VALUE
        var minIdx = -1 // return -1 when no nodes are legally reachable

        for(i in distArr.indices){
            if (visited[i]) continue

            if(distArr[i] < minDist){
                minDist = distArr[i]
                minIdx = i
            }
        }
        return minIdx
    }

    fun dijkstraHeap(G: Array<MutableList<Pair<Int, Int>>>, start: Int): IntArray{
        val distArr = IntArray(G.size){ Int.MAX_VALUE}
        val visited = BooleanArray(G.size)
        distArr[start] = 0

        val heap = PriorityQueue<Pair<Int, Int>>(compareBy{it -> it.second})
        heap.add(Pair(start, 0))

        while (heap.size > 0){
            val current = heap.poll()
            if(visited[current.first]) continue
            visited[current.first] = true
            for ((neighbor, weight) in G[current.first]){
                if(!visited[neighbor]){
                    val newDist = distArr[current.first] + weight
                    if(distArr[neighbor] > newDist){
                        distArr[neighbor] = newDist
                        heap.add(Pair(neighbor, newDist))
                    }
                }
            }
        }
        return distArr
    }

    fun intervalPartitioning(I: Array<Pair<Int, Int>>): Int {
        I.sortBy { it -> it.first }

        val resourceHeap = PriorityQueue<Int>()

        for (i in I){
            if(resourceHeap.isNotEmpty() && resourceHeap.peek() <= i.first){
                resourceHeap.poll()
                resourceHeap.add(i.second)
            }
            else
            {
                resourceHeap.add(i.second)
            }
        }
        return resourceHeap.size
    }
}