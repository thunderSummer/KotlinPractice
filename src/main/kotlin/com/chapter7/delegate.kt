package com.chapter7

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport


class Email
fun loadEmails(person:Person):List<Email>{
    println("load emails from ${person.name}")
    return listOf(Email(), Email())
}
class Person(val name:String){
//    private var _emails:List<Email>?= null
//    val email:List<Email>
//    get(){
//        if (_emails==null){
//            _emails= loadEmails(this)
//        }
//        return _emails!!
//    }
    val email by lazy { println()
    loadEmails(this) }
}
fun main(args:Array<String>){
    val p = Person("Alice")
    p.email
    val testP = testPerson("steam",1,1)
    testP.addPropertyChangeListener(PropertyChangeListener { evt: PropertyChangeEvent -> println("${evt.propertyName} s") })
    testP.age=10
    println(testP.age)

}
open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)
    fun addPropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.apply { addPropertyChangeListener(listener ) }
    }
    fun removePropertyChangeListener(listener: PropertyChangeListener){
        with(changeSupport){
            removePropertyChangeListener(listener)
        }
    }
}
class ObservableProperty(val propertyName:String, private var propertyValue:Int,val changeSupport:PropertyChangeSupport){
    fun getValue():Int=propertyValue
    fun setValue(newValue:Int){
        val oldValue = newValue
        propertyValue=oldValue
        println(propertyName+"sass")
        changeSupport.firePropertyChange(propertyName,oldValue,newValue)
    }
}
class testPerson(val name:String,age:Int,salay:Int) : PropertyChangeAware(){
    private val _age =ObservableProperty("age",age,changeSupport)
    var age:Int
        get() = _age.getValue()
        set(value) = _age.setValue(value)
}