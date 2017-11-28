package com.chapter2

class Person (
    var name:String,
    val isMarried: Boolean){
    var sex:String=""
        get() ="女"
        set(value:String)  {
            println("I have been called")
        field=value
        }
}
fun main(args : Array<String>){
    val person= Person("Bob",false)
    person.name="p"
    person.sex="男"
    println(person.sex)
    println("${person.name}${person.isMarried}")
}