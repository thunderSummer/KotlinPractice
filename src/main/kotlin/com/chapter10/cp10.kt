package com.chapter10

import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
class Person( val name:String,val age:Int){

     var a :String=""


}
fun a(x:Int)  =  println(3)
fun main(args : Array<String>){
    val person = Person("Alice", 13)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.members.forEach {
        if (it.name=="name") println()

    }
    println(listOf(1,2).filter { i: Int -> i==1 })
   buildString {  }
    var kFun =::a
    person.a="ss"
    println(person.a)
   // KAnnotatedElement()


   // kClass.memberProperties.forEach { println(it.name) }

    println(sum(78,90){x,y->x*y})
    var sum = {x:Int,u:Int -> x+u}
}
fun sum(x:Int,y:Int,f:(Int,Int)->Int):Int = f(x,y)
@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class JsonName(val name:String)
annotation class JsonNameJava(val name: String)
