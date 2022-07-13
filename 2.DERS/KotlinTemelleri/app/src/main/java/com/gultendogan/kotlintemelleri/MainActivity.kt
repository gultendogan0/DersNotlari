package com.gultendogan.kotlintemelleri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //println("hello world")
        //println(4*5)

        //var x = 5
        //var y = 4
        //println(x*y)

        //var age = 35
        //println(age / 7 *5)
        //age = 36
        //println(age)

        //val a = 5
        //a = 4

        //var age = 35
        //val result = age / 7 * 5
        //println(result)

        //var myInteger : Int
        //myInteger = 10.5

        //val a : Int = 23
        //println(a/2)

        //val pi = 3.14
        //val e = 2.7182818284
        //val eFloat = 2.7182818284f

        //var greeting = "Hello"

        //var greeting : String = "Hello"

        //var name : String
        //name = "John"
        //println(name)

        /*
        val name = "James"
        val surname = "Hetfield"

        val fullname = name + surname

        println(fullname)

        val fullname = name + " " + surname
        println(fullname)

         */

        /*
        val myString = "bill gates"
        println(myString.capitalize())
        println(myString[0])
        println(myString.length)

         */

        /*
        val isStudent : Boolean = true
        val isTeacher : Boolean = false

        println(3<5)
        println(6<3)

         */

        /*
        var myNumber = 5
        var myLongNumber = myNumber.toLong()

        var input ="10"
        var inputInteger = input.toInt()
        println(inputInteger*2)

         */


        /*
        val myArray = arrayOf("James","Kirk","Rob","Lars")
        println(myArray[0])

         */

        /*
        myArray.set(1,"Kirk Hammett")
        println(myArray[1])

         */

        /*
        val myMusician = arrayListOf<String>("James","Kirk")
        myMusician.add("Lars")
        myMusician.add(0,"Rob")

         */


        /*
        val myMixedArrayList = ArrayList<Any>()
        myMixedArrayList.add("Atil")
        myMixedArrayList.add(12.25)
        myMixedArrayList.add(true)

         */


        /*
        val mySet = setOf<Int>(1,1,2,3)
        println(mySet.size)

        mySet.forEach{println(it)}
         */


        /*
        val fruitCalorieMap = hashMapOf<String,Int>()
        fruitCalorieMap.put("Apple",100)
        fruitCalorieMap.put("Banana",150)
        println(fruitCalorieMap["Apple"])

         */


        /*
        val myNewMap = hashMapOf<String,Int>("A" to 1, "B" to 2, "C" to 3)
        println(myNewMap["C"])

         */


        /*
        val myNumberAge = 32
        if(myNumberAge < 30){
            println("<30")
        } else if(myNumberAge >= 30 && myNumberAge < 40){
            println("30-40")
        }else if(myNumberAge >= 40 && myNumberAge < 50){
            println("40-50")
        }else{
            println(">=50")
        }

         */


        /*
        val dayString : String
        val day = 3
        when(day){
            1 -> dayString = "Monday"
            2 -> dayString = "Tuesday"
            3 -> dayString = "Wednesday"
            else -> dayString = ""
        }

        println(dayString)

         */


        /*
        val myArrayofNumbers = arrayOf(12,15,18,21,24,27,30,33)

        for (number in myArrayofNumbers){
            val z = number / 3*5
            println(z)
        }

         */


        /*
        for(b in 0..9){
            println(b)
        }

         */


        /*
        var j = 0
        while (j<10){
            println(j)
            j = j + 1
        }

         */


        /*
        test()
        mySum(10,20)
        */

    }

    /*
    fun test(){

    }

    fun mySum(a:Int , b:Int){
        //println(a+b)
        textView.text = "Result : ${a+b}"
    }

     */

    /*
    fun myMultiply(x:Int , y:Int) : Int{
        return x*y
    }

     */

    fun helloKotlin(view : View){
        println("hello kotlin")
    }

}








