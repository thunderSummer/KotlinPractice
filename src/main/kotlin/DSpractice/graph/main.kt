package DSpractice.graph

fun main(array: Array<String>){
    val graph=AdjGraph<Int>(10)
    graph.setEdge(1,2,0,true)
    graph.setEdge(2,4,0,true)
    graph.setEdge(2,5,0,true)
    graph.setEdge(4,8,0,true)
    graph.setEdge(5,8,0,true)
    graph.setEdge(1,3,0,true)
    graph.setEdge(3,6,0,true)
    graph.setEdge(3,7,0,true)
    graph.setEdge(6,7,0,true)

    graph.travelBFS()


}