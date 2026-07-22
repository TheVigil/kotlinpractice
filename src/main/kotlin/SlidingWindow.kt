package org.example

class SlidingWindow {

    fun findLongestUniqueSubstringLength(s: String): Int {
        val charMap = hashMapOf<Char, Int>()
        var windowMax = 0
        var currentWindow = 0;

        var a = 0;
        var b = 0;
        while(b != s.length){
            if(charMap.containsKey(s[b]) && charMap[s[b]]!! >= a){
                a = charMap[s[b]]!! + 1
            }
            charMap[s[b]] = b
            currentWindow = b - a + 1
            if(currentWindow > windowMax){
                windowMax = currentWindow
            }
            b++
        }
        return windowMax
    }
}