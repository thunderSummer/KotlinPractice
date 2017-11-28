package com.chapter9


fun main(args :Array<String >){
    listOf<>(1,2,3)
}
open class Animal(){
    fun  feed() = println("animal is feed")

}
class Herb<out T : Animal>(   a : T, vararg  animals: T){
    val size:Int
    get() {
        a.
    }

}