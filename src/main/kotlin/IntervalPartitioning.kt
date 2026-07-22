package org.example

import java.util.PriorityQueue

class IntervalPartitioning {

    fun intervalPartioning(I: List<Pair<Int, Int>>): Int {
        val intervals = I.sortedBy { it.first }
        val resourceHeap = PriorityQueue<Int>()

        for (interval in intervals){
            if (!resourceHeap.isEmpty() && resourceHeap.peek() <= interval.first){
                resourceHeap.poll()
            }
            resourceHeap.add(interval.second)
        }

        return resourceHeap.size
    }
}