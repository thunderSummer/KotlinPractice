package com.chapter11

import com.chapter2.Person
import com.chapter4.Payroll
import java.util.ArrayList
import java.util.zip.CRC32


//fun main(args: Array<String>) {
//    val result = html {
//        head { title { +"XML encoding with Kotlin" } }
//        body {
//            h1 { +"XML encoding with Kotlin" }
//            p { +"this format can be used as an alternative markup to XML" }
//            a(href = "http://lioil.com") { +"Kotlin博客" }
//            p {
//                +"This is some"
//                b { +"mixed" }
//                +"text. For more see the"
//                a(href = "http://lioil.com") { +"Kotlin博客" }
//                +"project"
//            }
//            p { +"some text" }
//            p {
//                +"Command line arguments were:"
//                ul {for (arg in args) li { +arg }} //命令行参数args
//            }
//        }
//    }
//    println(result) //输出一个Html树形文档,输出结果在下文
//}
//
///*
//init参数本身就是一个函数,该函数类型是HTML.() -> Unit,该函数带接收者是HTML类
//html {
//    //head和body是HTML的成员函数, this可以省略(this就是HTML类对象)
//    this.head { }
//    this.body { }
//}
//*/
//fun html(init: HTML.() -> Unit): HTML {
//    val html = HTML()
//    html.init()
//    return html
//}
//
///*
//String.unaryPlus()重载操作符+,
//作用就是把一个字符串包装到TextElement实例对象,
//并添加到children标签html集合,例如:
//title { +"XML encoding with Kotlin" }
//*/
//abstract class TagWithText(name: String) : Tag(name) {
//    operator fun String.unaryPlus() {
//        children.add(TextElement(this))
//    }
//}
//
//// 以下几个类,就是生成HTML标签元素
//class HTML() : TagWithText("html") {
//    fun head(init: Head.() -> Unit) = initTag(Head(), init)
//    fun body(init: Body.() -> Unit) = initTag(Body(), init)
//}
//class Head() : TagWithText("head") {
//    fun title(init: Title.() -> Unit) = initTag(Title(), init)
//}
//class Title() : TagWithText("title")
//class Body() : BodyTag("body")
//class UL() : BodyTag("ul") {
//    fun li(init: LI.() -> Unit) = initTag(LI(), init)
//}
//class B() : BodyTag("b")
//class LI() : BodyTag("li")
//class P() : BodyTag("p")
//class H1() : BodyTag("h1")
//class A() : BodyTag("a") {
//    public var href: String
//        get() = attributes["href"]!!
//        set(value) {
//            attributes["href"] = value
//        }
//}
//
//interface Element {
//    fun render(builder: StringBuilder, indent: String)
//}
//
//class TextElement(val text: String) : Element {
//    override fun render(builder: StringBuilder, indent: String) {
//        builder.append("$indent$text\n")
//    }
//}
//
//@DslMarker
//annotation class HtmlTagMarker
//
///*
//自Kotlin 1.1起,引入了一种特殊机制,控制接收者作用域(Scope control: @DslMarker)
//不必用@HtmlTagMarker标注HTML或Head类,因为它们的超类/父类Tag已标注过!
//添加注解HtmlTagMarker之后,Kotlin编译器就知道哪些隐式接收者是同一个DSL,
//并且只允许调用最近层的接收者的成员
//html {
//    head {
//        head { } // 错误: head是外部接收者的成员
//    }
//    // ……
//}
//
//注意:仍然可以调用外部接收者的成员,但必须明确指定该接收者:
//html {
//    head {
//        this@html.head { } // 可行
//    }
//    // ……
//}
//*/
//@HtmlTagMarker
//abstract class Tag(val name: String) : Element {
//    val children = arrayListOf<Element>()
//    val attributes = hashMapOf<String, String>()
//
//    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
//        tag.init()
//        children.add(tag)
//        return tag
//    }
//
//    override fun render(builder: StringBuilder, indent: String) {
//        builder.append("$indent<$name${renderAttributes()}>\n")
//        for (c in children) {
//            c.render(builder, indent + "  ")
//        }
//        builder.append("$indent</$name>\n")
//    }
//
//    private fun renderAttributes(): String? {
//        val builder = StringBuilder()
//        for (a in attributes.keys) {
//            builder.append(" $a=\"${attributes[a]}\"")
//        }
//        return builder.toString()
//    }
//
//
//    override fun toString(): String {
//        val builder = StringBuilder()
//        render(builder, "")
//        return builder.toString()
//    }
//}
//
//abstract class BodyTag(name: String) : TagWithText(name) {
//    fun b(init: B.() -> Unit) = initTag(B(), init)
//    fun p(init: P.() -> Unit) = initTag(P(), init)
//    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
//    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
//    fun a(href: String, init: A.() -> Unit) {
//        val a = initTag(A(), init)
//        a.href = href
//    }
//}
open class TAG( val name:String){
    private val children= mutableListOf<TAG>()

    protected fun <T:TAG> doinit(child:T,init:T.() ->Unit ){
        child.init()
        children.add(child)
    }

    override fun toString(): String ="<$name>${children.joinToString { "" }}</$name>"
}
class TABLE:TAG("table"){
    fun tr(init:TR.()->Unit)=doinit(TR(),init)
}
class TR:TAG("tr"){
    fun td(init:TD.()->Unit)=doinit(TD(),init)
}
class TD:TAG("td")
fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

fun main(args : Array<String>){
    val createTable={
        table {

            this.tr {

                this.td {

                }
            }
        }
    }
    println(createTable())


}




class javaTest {

    private var name: String? = null
     get() {
        println(field)
        return field

    }
    private set(value) {
        print(field)
        field=value
    }


}