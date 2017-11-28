package com.chapter5

import com.chapter2.Person

import com.chapter4.Client

fun main(args : Array<String>){
    val people = listOf(Client("bob",123),Client("peter",124))
    println(people.asSequence().filter {println(it.name);it.postalCode!=0 }.map {it.name+it.name}.toList())

    println(people.maxB1 { client:Client -> client.name })
//    var sum = {
//        x : Int ,y :Int ->x+y
//    }
//    println(people.maxBy ({client: Client -> client.postalCode  }))
//    println(people.maxBy (){ client: Client -> client.postalCode  })
//    println(people.maxBy { client ->client.postalCode  })
//   // println(sum(12,32))
//   // { println(34) }()
//    println(people.joinToString("  " ,transform = {client -> client.name }))
//    people.forEach {
//
//    }
//    var getAge = Client::name
//    println(getAge(Client("ss",111)))
    println(Client("b",123).run1(13 ,{ a:Int,b:Int-> name+(a+b).toString() }))
    println(Client("b",1).run { name })
    StringBuilder().apply {  }

}
inline fun <T, R> with1(receiver: T, block: T.() -> R): R = receiver.block()
inline fun <T, R> T.run1(a:Int,block: T.(Int,Int) -> R): R = block(a,a)

inline fun <T, R : Comparable<R>> Iterable<T>.maxB1(selector: (T) -> R): T? {
    val iterator = iterator()
  //  println(iterator)
    if (!iterator.hasNext()) return null
    var maxElem = iterator.next()
    println(maxElem)
    var maxValue = selector(maxElem)
    while (iterator.hasNext()) {
        val e = iterator.next()
        val v = selector(e)
        println(v)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}