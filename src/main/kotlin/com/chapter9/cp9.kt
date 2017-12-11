package com.chapter9

import com.chapter3.joinToString
import kotlin.reflect.full.memberProperties


fun main(args :Array<String >){
   // listOf<>(1,2,3)

    var cl =Collection1<Int>()
    var c2 = Collection1<Number>()
//    val m1 =child<Int>()
//    val m2 = child<Number>()
//    val m3 = child<Any>()
//
//    ass(c2)
//    ass(cl)
//    ass(m1)
//    ass(m2)
//    ass(m3)
//    assss(m1)
//    mutableListOf<>()
    buildString {  }

}

open class Animal(){
    fun  feed() = println("animal is feed")

}
//fun StringBuilder.ser(obj:Any){
//    obj.javaClass.kotlin.memberProperties.joinToString {  }
//
//
//}
fun ass(c:Collection1<Number>){

}
fun assss(c:Child<Number>){

}
class Herb<out T : Animal>(   a : T, vararg  animals: T){
    //val size:Int
 //   get() {
    //    a.
 //  }

}

internal interface ACollection<E> {
    fun addAll(items: ACollection<out E>){

    }
}
open class Collection1<out E>{
    // Query Operations
    /**
     * Returns the size of the collection.
     */
    public val size: Int=0

    /**
     * Returns `true` if the collection is empty (contains no elements), `false` otherwise.
     */
    public fun isEmpty(): Boolean=false

}
class Child< E> : Collection1<E>() {

}