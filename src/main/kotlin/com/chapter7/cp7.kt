package com.chapter7

import java.lang.reflect.Type


data class Point(val x:Int , val y:Int) :Comparable<Point>{

    override fun compareTo(other: Point)= when {
            x>other.x -> 1
            x==other.x -> 0
            else -> -1
        }


    operator fun plus(other:Point):Point = Point(x+other.x,y + other.y)
}
class P(val value:Int)

operator fun ClosedRange<Point>.iterator(): Iterator<Point> {
    return object :Iterator<Point>{
        var current = start
        override fun next()=current.apply {
            current+=Point(1,1)
        }
        override fun hasNext() = current<=endInclusive

    }
}
fun String.fil(x:Int,y:Int,predicate: String.(Int ,Int) -> Unit ):String{
//    val sb =StringBuilder()
//    for(index in 0 until length){
//        val element = get(index)
//        println(element)
//
//        if(element in 'a'..'g')
//            sb.append(element)
//    }
//    return sb.toString()
    var s :String=""
    s.predicate(x,y)
    return "ss"
}
//class Foo{
//   val p : Type by Delegate1()
//
//}
//class Delegate1(){
//    operator fun getValue(){
//
//    }
//    operator fun setValue(int:Int){
//
//    }
//}

