package com.chapter4

import com.chapter2.Person

data class Client(val name:String ,val postalCode : Int){
//    override fun toString(): String =  "Client(name = $name,postalCode = $postalCode)"
//    override fun equals(other: Any?): Boolean=if (other==null||other !is Client) false else  name==other.name&& postalCode==other.postalCode
}
class DelegatingCollection<T>(
        innerList:MutableCollection<T> = ArrayList()):MutableCollection<T> by innerList{
    var objectAdd =0
    override fun add(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
object Payroll{
    var count:Int=0
    val allEmployees = arrayListOf<Person>()
    val all = ArrayList<Person>()
    fun calculateSalary():Int{
        for (person in allEmployees){
            count++
        }
        return count
    }
}
class A{
    companion object ACom{
        fun bar(){
            println("companion object call")
        }
    }
}
interface JsonFactory<T>{
    fun fromJson(jsonTest:String): T
}
class B{
    companion object :JsonFactory<B>{
        override fun fromJson(jsonTest: String): B {
            println("反序列化,产生B对象")
            return B()
        }

    }
}