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

        val list = InsertionSort(x1,x2,x3,x4,x5).result

        for (k in list){
            sonuc = sonuc + " ${k}"
        }

        textView.text = sonuc



    }

}