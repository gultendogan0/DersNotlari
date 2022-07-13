package com.gultendogan.kotlintemelleri2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val homer = Simpson()
        homer.age = 50
        homer.job = "Nuclear"
        homer.name = "Homer Simpson"

         */

        //val homer = Simpson(50,"Homer Simpson","Nuclear")

        val homer = Simpson("Homer Simpson",50,"Nuclear")



        var myString : String? = null
        println(myString)

        var myAge : Int? = null
        println(myAge!! * 10)

        if (myAge != null){
            println(myAge*10)
        }else{
            println("myAge null")
        }

        val myResult = myAge?.compareTo(2) ?: -100
        println(myResult)
    }
}