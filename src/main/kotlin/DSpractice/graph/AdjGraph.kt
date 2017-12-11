package DSpractice.graph

class AdjGraph<T>(verticesNum: Int) : Graph<T>(verticesNum) {
    lateinit var matrix:Array<IntArray>

    override fun deleteEdge(start: Int, end: Int) {
        if (matrix[start-1][end-1]!=0){
            edgeNum--
        }
        matrix[start-1][end-1]=0
        matrix.forEach {  }
    }

    override fun setEdge(start: Int, end: Int, weight: Int,isDouble: Boolean) {
       if(matrix[start-1][end-1]==0){
           edgeNum++
       }
        matrix[start-1][end-1]=weight
        if (isDouble){
            if(matrix[end-1][start-1]==0){
                edgeNum++
            }
            matrix[end-1][start-1]=weight
        }
    }

    override fun nextEdge(edge: Edge<T>): Edge<T>? {
         val tempEdge=Edge<T>()
        tempEdge.start=edge.start
        for(i in edge.end+1 until verticesNum) {
            if (matrix[edge.start][i]!=-1){
                tempEdge.end=i
                tempEdge.weight=matrix[edge.start][i]
                break
            }
        }
        return tempEdge
    }

    override fun firstEdge(oneVertex: Int): Edge<T>? {
        val tempEdge=Edge<T>()
        tempEdge.start=oneVertex
        for( i in 0 until  verticesNum){
            if (matrix[oneVertex][i]!=-1){
                tempEdge.end=i
                tempEdge.weight=matrix[oneVertex][i]
                break
            }
        }
        return tempEdge
    }
    init {

        matrix= Array(verticesNum){IntArray(verticesNum)}
        for(i in 0 until verticesNum){
            for(j in 0 until verticesNum) {
                matrix[i][j] = -1
            }

        }
    }

}