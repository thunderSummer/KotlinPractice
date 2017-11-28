package com.chapter6

fun main(args : Array<String>){
    val address = Address("El",1,"beijing","company")
    val jetbrains = Company("jetbrains",address)
    val xia = Person("xia",jetbrains)
//    printShippingLable(xia)
//    printShippingLable(Person("xiao",null))
println(Person("xiao", null)==xia)
    list1()
    val letters = Array(26){
        i -> ('a' + 25-i).toString()
    }
    println(letters[0])
    println(letters.joinToString(" "))
    val s:String =""
    val a= s as? Number ?: 1
    println(a::class)
    val email :String?="ss"
    email?.let { aa(email) }
}
fun aa(s:String){

}