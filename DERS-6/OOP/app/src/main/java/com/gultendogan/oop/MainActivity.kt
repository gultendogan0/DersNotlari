package com.gultendogan.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        var myUser = User()
        myUser.age = 25
        myUser.name = "James"

        println(myUser.age.toString())
        println(myUser.name)

         */

        var myUser = User("James",50)
    }
}