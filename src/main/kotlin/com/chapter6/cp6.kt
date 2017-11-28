package com.chapter6

class Address(val stringAdress:String,val zipCode:Int,val city:String,var company:String)
class Company(val name:String,val address:Address?)
class Person(val name:String?,val company: Company?){
    override fun equals(other: Any?): Boolean {
       // val otherPerson = other as? Person ?: return false
        val he = company?:println("name")
        println(he)
        if (he is Unit){
        }
        val person = other as? Person?: return false
        person.name?:return false
        return true
       // otherPerson.name
    }
}
fun printShippingLable(person:Person){
    val address=person.company?.address?:return

    with(address){
        println(stringAdress)
    }
    return Unit

}
fun list1(){
    val list = ArrayList<Int>()
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.add(1)
    list+=1
    list.filter { it ==1 }.forEach { list.remove(1)
    }
    println(list)
}