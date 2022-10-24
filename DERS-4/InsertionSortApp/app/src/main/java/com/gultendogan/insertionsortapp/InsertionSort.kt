package com.gultendogan.insertionsortapp

class InsertionSort(var s1:Int, var s2:Int, var s3:Int, var s4:Int, var s5:Int) {

    fun algorithm(items:MutableList<Int>):List<Int>{
        if (items.isEmpty() || items.size<2){
            return items
        }
        for (count in 1..items.count() - 1){
            // println(items)
            val item = items[count]
            var i = count
            while (i>0 && item < items[i - 1]){
                items[i] = items[i - 1]
                i -= 1
            }
            items[i] = item
        }
        return items
    }

    val result = algorithm(mutableListOf(s1,s2,s3,s4,s5))

}