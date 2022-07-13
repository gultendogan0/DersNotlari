package com.gultendogan.fragmentnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



    /*
    fun firstFragment (view : View){

        val firstFragment = BlankFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,firstFragment).commit()


    }

    fun secondFragment (view : View){

        val secondFragment = BlankFragment2()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,secondFragment).commit()
    }
     */
}