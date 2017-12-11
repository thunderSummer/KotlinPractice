

var sum ={ x:Int, y:Int -> x+y}
class Person(val name:String):Iterable<Person> {
    override fun iterator(): Iterator<Person> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String = "$name,,,,"
}


fun main(args:Array<String>){
    val people = mutableListOf(Person("ss"), Person("sss"))
//    people.delete {
//        it.name=="ss"
//    }
//    println(people)
//    println(people.maxBy1 {perso -> perso .name
//    })
//    for ((i , value) in people.withIndex()){
//        println(i)
//        people.remove(value)
//    }
//    people.withIndex()
//    people.also {
//
//    }
    //people.filter {  }
//    println(people.map { it.name }.javaClass)
//    var list = arrayListOf(1,2,3,4)
//    list.delete { it%2==0 }
//    println(list)
    //people.count {  }
    //people.any{}
   // people.find {  }
   // people.firstOrNull{}
   // with()
    people.apply {
        print(toString())
    }
  //  people.get
    people.apply1 {
        print(it.toString())
    }
    people.forEach {  }
    people.foreach1 {
        println("hahaha")
        if (name=="ss"){
            print(it.name)
            return@foreach1
        }
    }
    println("haha")
     people?.also {
         print("sss")
         println(it.toString())
    }
    null?.let{

    }
    println("abcd".filter { c: Char -> c in 'a'..'z' })

}
inline fun dosomething(action: (a:Int,b:Int)->Unit){
}
inline fun<T,R:Comparable<R>>Iterable<T>.maxBy1(select:(T)->R):T?{
    val iterator  = iterator()
    if (!iterator.hasNext()) return null
    var maxVal= iterator.next()
    var maxEle = select(maxVal)
    while (iterator.hasNext()){
        val tempVal= iterator.next()
        val tempEle = select(tempVal)
        if (tempEle>maxEle){
            maxEle=tempEle
            maxVal=tempVal
        }
    }
    return maxVal
}
 fun <T> Iterable<T>.joinToString1(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", transform: ((T) -> CharSequence)? = null):String{
    val sb = StringBuilder()
     sb.append(prefix)
     for ((count, element) in this.withIndex()){
         if(count + 1 >1) sb.append(separator)
         if (transform==null){
             sb.append(element)
         }else{
             sb.append(transform(element))
         }
     }
     return  sb.append(postfix).toString()
}
inline fun <T> MutableList<T>.delete(action: (T)->Boolean){
    var count=0
    while (count<size)
        if (action(get(count))) removeAt(count) else count++
}
inline fun<T> T.apply1(action: (T) -> Unit){
    action(this)
}
inline fun <T> with1(receiver:T, action: T.() -> Unit){
    receiver.action()
}
 inline fun <T> Iterable<T>.foreach1(action: T.(T) -> Unit){
    for (i in this) i.action(i)
}
