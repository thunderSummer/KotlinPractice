package com.chapter4

interface Clickable {
    fun click()
    fun showOff()= println("I am clickable")
}
class Button:Clickable{
    override fun click()= println("I was clicked")

}
class User(val name:String){
    var address : String ="Unknown"
    set(address : String ) {
        field=address
        println("My name is $name My address is $address")
    }

}
interface Focusable{
    fun setFocus(b:Boolean)
}
fun main(args : Array<String>){
    val a = Button()
    a.click()
    a.showOff()
    var user = User("xia")
    user.address="shanhai"
    println(user.address)
}