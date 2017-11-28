
package com.chapter3
@JvmOverloads
fun <T> joinToString(
        collection: Collection<T>,separator:String="  " ,prefix:String="{" ,postfix:String = "}"
) : String{
    val result = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if (index>0) result.append(separator)
        result.append(element)
    }
    return result.append(postfix).toString()
}
fun main(args : Array<String>){
    val list = listOf(1,2,3)
    println(joinToString(list,separator = ", "  , postfix = ")"))
    println(joinToString(list))
    println(joinToString(list,", "))
//    val kotlinLogo = """| //
//        .|//
//        .|/ \"""
//    var regex = """(.+)/(.+)\.(.+)""".toRegex()
//    var result = regex.matchEntire("sss/sss/sss/sss.jpg")
//    if(result!=null){
//        val(directory,fileName,extension)=result.destructured
//        println("$directory$fileName$extension")
//    }
    print("""ssss\dss""".substringAfterLast("d"))
    println(B(1,2,3).a)
    println({ println("s")})
}
open  class A(a:Int)
class B(val a: Int,val b:Int):A(a){
    var c :Int=0
    constructor(a:Int,b: Int,c:Int):this(a,b){
        println(c)
        this.c=c
    }
}
