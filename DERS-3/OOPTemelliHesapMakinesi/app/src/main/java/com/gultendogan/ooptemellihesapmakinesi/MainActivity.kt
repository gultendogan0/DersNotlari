package com.gultendogan.ooptemellihesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun topla(view: View){
        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()
        var x = Topla()
        textView.text = "Sonuç : ${x.topla(birinciSayi,ikinciSayi)}"

    }

    fun cikar(view:View){
        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()
        var x = Cikar()
        textView.text = "Sonuç : ${x.cikar(birinciSayi,ikinciSayi)}"
    }

    fun bol(view: View){
        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()
        var x = Bol()
        textView.text = "Sonuç : ${x.bol(birinciSayi,ikinciSayi)}"
    }

    fun carp(view:View){
        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()
        var x = Carp()
        textView.text = "Sonuç : ${x.carp(birinciSayi,ikinciSayi)}"
    }
}