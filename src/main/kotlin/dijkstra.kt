package org.example

import java.util.PriorityQueue

class dijkstra {
    // implement dijkstras with and without a heap

    fun findMinUnvisited(dist: IntArray, visited: BooleanArray) : Int {
        var minIndex = -1; // ret -1 in the case that no node is reachable
        var minValue = Int.MAX_VALUE;

        for(i in dist.indices){
            if(!visited[i] && dist[i] < minValue) {
                minValue = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    fun dijkstra(G: Array<MutableList<Pair<Int, Int>>>, start: Int): IntArray {
        // give and graph G and a start node, calculate the shortest distance to all nodes from the start

        val dist = IntArray(G.size){Int.MAX_VALUE};
        dist[start] = 0;
        val visited  = BooleanArray(G.size);
        var counter = G.size;

        while (counter > 0){

            val currentNode = findMinUnvisited(dist, visited);

            if (currentNode == -1) return dist;

            visited[currentNode] = true;

            for((neighbor, edgeWeight) in G[currentNode]){
                if(!visited[neighbor] && dist[currentNode] != Int.MAX_VALUE){
                    val distToNeighbor = edgeWeight + dist[currentNode];
                    if(distToNeighbor < dist[neighbor]){
                        dist[neighbor] = distToNeighbor;
                    }
                }
            }
            counter--;
        }
        return dist;
    }

    fun dijkstraHeap(G: Array<MutableList<Pair<Int, Int>>>, start: Int): IntArray {
        val dist = IntArray(G.size){Int.MAX_VALUE}
        dist[start] = 0

        var visited = BooleanArray(G.size)

        val prioHeap = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})

        prioHeap.add(Pair(start, 0));

        while (prioHeap.size > 0){
            val currentNode = prioHeap.poll();

            if (visited[currentNode.first]) continue;

            visited[currentNode.first] = true;

            for ((neighbor, edgeWeight) in G[currentNode.first]){
                if(!visited[neighbor]){
                    val newDist = edgeWeight + dist[currentNode.first];
                    if(newDist < dist[neighbor]){
                        dist[neighbor] = newDist
                        prioHeap.add(Pair(neighbor, newDist));
                    }
                }
            }
        }
        return dist;
    }
}