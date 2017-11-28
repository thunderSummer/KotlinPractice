package DSpractice.tree

class BinaryNode<T>(var element: T,var leftChild: BinaryNode<T>?=null, var rightChild : BinaryNode<T>?=null,var parent:BinaryNode<T> ?= null) {
    fun reset(){
        leftChild=null
        rightChild=null

    }
    fun getNum():Int{
        var num=0
        if (leftChild!=null){
            num++
        }
        if (rightChild!=null){
            num++
        }
        return num
    }
}
