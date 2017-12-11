package DSpractice.graph

import java.util.*


open class Graph<T> (var verticesNum:Int=0){
    private var visited=true
    private var unVisited=false
    var edgeNum:Int=0
    var curVerticesNum:Int=0
    var mark:BooleanArray = BooleanArray(verticesNum)

    init {
        (0 until verticesNum).forEach {
            mark[it]=unVisited
        }
    }
    open fun firstEdge(oneVertex:Int):Edge<T>? = null
    open fun deleteEdge(start:Int,end:Int){

    }
    open fun setEdge(start: Int,end: Int,weight:Int,isDouble: Boolean){

    }
    open fun nextEdge(edge: Edge<T>):Edge<T>?=null
    private fun iDNS(v:Int){
        mark[v]=visited
        visit(v)
        var e = firstEdge(v)
        while (isEdge(e!!)){
            if(mark[endVertex(e)]==unVisited){
                iDNS(endVertex(e))
            }
            e=nextEdge(e)
        }

    }
    fun travelDNS(){
        (0 until verticesNum).forEach {
            mark[it]=unVisited
        }
        (0 until verticesNum).forEach {
            if (mark[it]==unVisited){
                iDNS(it)
            }
        }
    }
    private fun iBFS(v: Int){
        val queue = LinkedList<Int>()
        mark[v]=visited
        visit(v)
        queue.offer(v)
        while (!queue.isEmpty()){
            val u = queue.poll()
            var e = firstEdge(u)
            while (isEdge(e!!)){
                if(mark[endVertex(e)]==unVisited){
                    visit(endVertex(e))
                    mark[endVertex(e)]=visited
                    queue.offer(endVertex(e))
                }
                e=nextEdge(e)
            }
        }
    }
    fun travelBFS(){
        (0 until verticesNum).forEach {
            mark[it]=unVisited
        }
        (0 until verticesNum).forEach {
            if (mark[it]==unVisited){
                iBFS(it)
            }
        }
    }
    private fun visit(v:Int){
        val node = v+1
        println("current node is $node")
    }
    private fun startVertex(edge: Edge<T>):Int=edge.start
    private fun endVertex(edge: Edge<T>):Int = edge.end
    private fun weight(edge: Edge<T>):Int =edge.weight
    private fun isEdge(edge: Edge<T>):Boolean = edge.end!=-1
}