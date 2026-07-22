package org.example

class BinarySearch {

    fun rotatedArrayBinarySearch(intArray: IntArray, target: Int): Int  {
        var pivot = intArray.size / 2
        var right = intArray.size - 1
        var left = 0

        while(left <= right){
            if(intArray[pivot] == target) return pivot

            if(intArray[left] <= intArray[pivot]){
               if(intArray[left] <= target && intArray[pivot] >= target){
                   right = pivot - 1
                   pivot = (left + right) / 2
               }
               else{
                   left = pivot + 1
                   pivot = (left + right) / 2
               }
           }
           else if (intArray[left] > intArray[pivot]){
                if(intArray[right] >= target && intArray[pivot] <= target){
                    left = pivot + 1
                    pivot = (left + right) / 2
                }
                else{
                    right = pivot - 1
                    pivot = (left + right) / 2
                }
           }
        }
        return -1
    }
}