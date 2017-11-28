package com.chapter4

import com.chapter2.Person
import javax.swing.JScrollBar

fun main(args :Array<String>){
    val client= Client("bob",123)
    println(client)
    val client1 =Client("peter",123)
    val client2 = Client("peter",123)
    var a = A()
    println(client1==client2)
    println(client1===client2)
    Payroll.allEmployees.add(Person("bob",false))
    Payroll.allEmployees.add(Person("peter",true))
    println(Payroll.calculateSalary())
    println(A.ACom.bar())
    loadFromJson("ss",object : JsonFactory<B> {
        override fun fromJson(jsonTest: String): B {
            println("hehe")
            return B()
        }

    })
    loadFromJson("heh",object :JsonFactory<B>{
        override fun fromJson(jsonTest: String): B {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    })
    var factory = object :JsonFactory<B>{
        override fun fromJson(jsonTest: String): B {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
fun <T> loadFromJson(jsonText:String,factory: JsonFactory<T>){
    factory.fromJson(jsonText)
}