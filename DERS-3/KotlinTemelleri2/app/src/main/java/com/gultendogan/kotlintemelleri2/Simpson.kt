package com.gultendogan.kotlintemelleri2

/*
class Simpson {
    var age = 0
    var name = ""
    var job = ""

    constructor(ageInput:Int , nameInput:String, jobInput:String){
        this.age = ageInput
        this.name = nameInput
        this.job = jobInput
    }
}

 */

class Simpson(var name : String, var age:Int, var job:String){

    private var hairColor = ""

    fun changeHairColor(){
        this.hairColor = "Yellow"
    }
}