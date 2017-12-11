package DSpractice.graph

import javax.print.attribute.standard.MediaSize

data class Edge <T>(var start:Int=-1,var end:Int=-1,var weight:Int=-1):Comparable<Edge<T>>{
    override operator fun compareTo(other: Edge<T>):Int = compareValuesBy(this,other,Edge<T>::weight)
}