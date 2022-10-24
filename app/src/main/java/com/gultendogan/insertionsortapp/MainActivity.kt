package com.gultendogan.insertionsortapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sirala(view: View){
        val x1 = editTextTextPersonName.text.toString().toInt()
        val x2 = editTextTextPersonName2.text.toString().toInt()
        val x3 = editTextTextPersonName3.text.toString().toInt()
        val x4 = editTextTextPersonName4.text.toString().toInt()
        val x5 = editTextTextPersonName5.text.toString().toInt()

        var sonuc = ""

        val list = insertionsort(mutableListOf(x1,x2,x3,x4,x5))

        for (k in list){
            sonuc = sonuc + "   ${k.toString()}"
        }

        textView.text = "insertion: " + sonuc
    }
}

fun insertionsort(items:MutableList<Int>):List<Int>{
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