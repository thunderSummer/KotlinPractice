package com.chapter7

import java.time.LocalDate
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


fun main(args : Array<String>){
//    var point= Point(1,2)
//    point+= Point(2,4)
//    println(point)
//    val now = LocalDate.now()
//    val vacation = now.rangeTo(now.plusDays(10))
//    val pointRange = point.rangeTo(Point(5,4))
//    for (a in pointRange){
//        print(a)
//    }
//    val a =  pointRange.iterator()
//    with(a){
//        while (hasNext())
//            print(next())
//    }
//    val (x,y)=point fun a(x:Int)  =  println(3)
//    print(x)
//    print(y)
//    println("asdf".fil { false})
//    ReentrantLock.withLock()
//    listOf(1,3).forEach{
//        if (it==1){
//            println(it)
//        }else{
//            println(it+2)
//        }
//    }
    println(test(1){
        heiehi()
    })
    var b = "adc".fil(2,3){
        x:Int,y:Int ->
        println("ss")
        println("ss")
    }
    println(b)


}
fun test(x: Int,action: () ->Int):Int{
    return action()
}
fun heiehi():Int{
    print(10)
    return 23

}





