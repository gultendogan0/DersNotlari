package com.gultendogan.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    var sonuc = 0

    fun topla(view:View){

        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()

        sonuc = birinciSayi + ikinciSayi

        textView.text = "Sonuç : $sonuc"
    }

    fun cikar(view:View){

        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()

        sonuc = birinciSayi - ikinciSayi

        textView.text = "Sonuç : $sonuc"
    }

    fun carp(view:View){

        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()

        sonuc = birinciSayi * ikinciSayi

        textView.text = "Sonuç : $sonuc"
    }

    fun bol(view:View){
        
        val birinciSayi = editTextTextPersonName.text.toString().toInt()
        val ikinciSayi = editTextTextPersonName2.text.toString().toInt()

        sonuc = birinciSayi / ikinciSayi

        textView.text = "Sonuç : $sonuc"
    }

    fun sil(view:View){

        textView.text = "Sonuç : "
    }
}