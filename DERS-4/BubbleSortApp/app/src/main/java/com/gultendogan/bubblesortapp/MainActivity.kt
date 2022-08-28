package com.gultendogan.bubblesortapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sirala(view:View){
        val x1 = editTextTextPersonName.text.toString().toInt()
        val x2 = editTextTextPersonName2.text.toString().toInt()
        val x3 = editTextTextPersonName3.text.toString().toInt()
        val x4 = editTextTextPersonName4.text.toString().toInt()
        val x5 = editTextTextPersonName5.text.toString().toInt()

        var sonuc = ""

        val list = bubbleSort(intArrayOf(x1,x2,x3,x4,x5))

        for (k in list){
            sonuc = sonuc + "   ${k.toString()}"
        }

        textView.text = "Bubble: " + sonuc
    }

    fun sirala2(view: View){
        val x1 = editTextTextPersonName.text.toString().toInt()
        val x2 = editTextTextPersonName2.text.toString().toInt()
        val x3 = editTextTextPersonName3.text.toString().toInt()
        val x4 = editTextTextPersonName4.text.toString().toInt()
        val x5 = editTextTextPersonName5.text.toString().toInt()

        var sonuc = ""

        var list = intArrayOf(x1,x2,x3,x4,x5)
        selection_sort(list)

        for (k in list){
            sonuc = sonuc + "   ${k.toString()}"
        }

        textView.text = "Selection: " + sonuc
    }
}



fun bubbleSort(arr:IntArray):IntArray{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

fun selection_sort(sampleArray:IntArray){
    var n=sampleArray.size
    var temp:Int
    for(i in 0..n-1){
        var indexOfMin = i
        for(j in n-1 downTo  i){
            if(sampleArray[j]< sampleArray[indexOfMin])
                indexOfMin=j
        }
        if(i!=indexOfMin){
            temp = sampleArray[i]
            sampleArray[i]= sampleArray[indexOfMin]
            sampleArray[indexOfMin]=temp
        }
    }
}
