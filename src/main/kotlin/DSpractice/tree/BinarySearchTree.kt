package DSpractice.tree

class BinarySearchTree<T : Comparable<T>>: BinaryTree<T >() {
    fun insert(node:T){
        if (root==null){
            root= BinaryNode(node,null,null)
        }
        insert(node,root)

    }
    private fun insert(element: T,node:BinaryNode<T>?):BinaryNode<T>{
        if(node==null){
            return BinaryNode(element,null,null)
        }
        if (element>node.element){
            node.rightChild=insert(element,node.rightChild)
            node.rightChild!!.parent=node
        }else if(element<node.element){
            node.leftChild=insert(element,node.leftChild)
            node.leftChild!!.parent=node
        }
        return node
    }
    fun delete(element: T):Boolean = delete(element,root)
    private fun delete(element: T,node:BinaryNode<T>?):Boolean{
        if (node==null){
            return false
        }
        if (element>node.element){
            delete(element,node.rightChild)
        }else if (element<node.element){
            delete(element,node.leftChild)
        }else if(node.leftChild!=null&&node.rightChild!=null){
            val temp =findMin(node.rightChild!!)
            node.element=temp.element
            delete(temp.element,node.rightChild)
        }else if(node.leftChild==null&&node.rightChild==null){
            _delete(node,null)
        }else if(node.leftChild==null){
            _delete(node,node.rightChild)
        }else{
            _delete(node,node.leftChild)
        }
        return true
   }
    fun search(node: T):BinaryNode<T>?= search(node,root)

    private fun search(element: T,node: BinaryNode<T>?):BinaryNode<T>?{
        if (node==null){
            return null
        }
        return when {
            element>node.element -> search(element,node.rightChild)
            element<node.element -> search(element,node.leftChild)
            else -> node
        }
    }
    private fun _delete(node:BinaryNode<T>,nodeNext: BinaryNode<T>?){
        if(node.parent!!.rightChild==node){
            node.parent!!.rightChild=nodeNext
        }else{
            node.parent!!.leftChild=nodeNext
        }
    }
    private fun findMin(node:BinaryNode<T>):BinaryNode<T>{
        if(node.leftChild==null) return node
        return findMin(node.leftChild!!)
    }

}