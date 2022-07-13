package com.gultendogan.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        //Light Weightness
        GlobalScope.launch {
            repeat(100000){
                launch {
                    println("android")
                }
            }
        }

         */


        /*
        //runBlocking
        println("run blocking start")
        runBlocking {
            launch {
                delay(5000)
                println("run blocking")
            }
        }
        println("run blocking end")
         */


        /*
        println("global scope start")
        GlobalScope.launch {
            delay(5000)
            println("global scope")
        }
        println("global scope end")

         */

        //Context
        //Coroutine Scope
        /*
        println("coroutine scope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope")
        }
        println("coroutine scope stop")
         */

        /*
        runBlocking {
            launch(Dispatchers.Main) {
                println("Main Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.IO) {
                println("IO Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread : ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread : ${Thread.currentThread().name}")
            }
        }
         */

        /*
        runBlocking {
            delay(2000)
            println("run blocking")
            myFuction()
        }

         */

        /*
        var userName = ""
        var userAge = 0
        runBlocking {
            val downloadedName = async {
                downloadName()
            }

            val downloadedAge = async {
                downloadAge()
            }

            userName = downloadedName.await()
            userAge = downloadedAge.await()

            println("${userName} ${userAge}")
        }

         */

        /*
        runBlocking {
            val myJob = launch {
                delay(2000)
                println("job")
                val secondJob = launch {
                    println("job 2")
                }
            }

            myJob.invokeOnCompletion {
                println("my job end")
            }

            myJob.cancel()
        }
         */

        runBlocking {
            launch(Dispatchers.Default) {
                println("Context : ${coroutineContext}")
                withContext(Dispatchers.IO){
                    println("Context : ${coroutineContext}")
                }
            }
        }
    }



/*
    suspend fun myFuction(){
        coroutineScope {
            delay(4000)
            println("suspend function")
        }
    }

 */

    /*

    suspend fun downloadName() : String{
        delay(2000)
        val userName = "Ali:"
        println("username download")
        return userName
    }

    suspend fun downloadAge() : Int{
        delay(4000)
        val userAge = 60
        println("userage download")
        return userAge
    }

     */
}