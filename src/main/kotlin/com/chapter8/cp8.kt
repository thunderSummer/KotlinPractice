package com.chapter8

import java.util.concurrent.locks.Lock

fun main(args :Array<String>){
//   processTheAnswer {  }

}
fun processTheAnswer(f:(Int) -> Int){
    println(f(23))
}
inline fun <T> synchroized(lock:Lock, action:()-> T,inlineFun:()->T):T{
    lock.lock()
    try {


       return action()
    }
    finally {
        lock.unlock()
    }
}
fun <T>a(action: () -> T):T=action()
