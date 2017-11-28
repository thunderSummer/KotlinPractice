package com.chapter2

import com.chapter3.joinToString

fun main(args : Array<String>){
//    println (max(2,1))
//    println("hello,world")
//    val answer= 10
//    println(answer)
//    var a=10
//    a=29
//    println(a)
//    val person = Person("2")
//    person.name="w"
//    println(person.name)
//    val square = Square(1,3)
//    println(square.isSquare)
//    print(fix(Color.BLUE,Color.Red))
//    for(i in 10 downTo 1 step 2){
//        print(i)
//    }
//    println()
   val a = eval(Sum(Sum(Num(1),Num(2)),Num(2)))
    joinToString(listOf(1,2,3))
    println(a)
}
fun max(a: Int ,b: Int): Int{
    return if (a>b) a else b
}
//class Person (var name: String)
class Square(private val width : Int ,private val height : Int){
    val isSquare: Boolean
    get(){
        return height==width
    }
}
enum class Color(){
    Red,ORANGE,YELLOW,GREEN,BLUE
}
fun fix(c1:Color,c2:Color){
    when(setOf(c1,c2)){
        setOf(Color.Red,Color.BLUE) -> Color.BLUE
    }
}
//fun <T> joinToString(
//        collection: Collection<T>,separator:String ,prefix:String ,postfix:String
//) : String{
//    val result = StringBuilder(prefix)
//    for ((index,element) in collection.withIndex()){
//        if (index>0) result.append(separator)
//        result.append(element)
//    }
//    return result.toString()
//}
interface Expr
class Num(val value:Int) : Expr
class Sum(val num1: Expr,val num2: Expr) : Expr
//fun eval(expr: Expr) : Int =
//        if (expr is Num)
//            expr.value
//        else if (expr is Sum)
//            eval(expr.num1)+ eval(expr.num2)
//        else
//            throw IllegalArgumentException("UnKnown express")
fun eval(expr: Expr) : Int =
        when(expr){
            is Num ->
                    expr.value
            is Sum ->
                    eval(expr.num1)+ eval(expr.num2)
            else ->
                    throw IllegalArgumentException("Unknown express")
        }


