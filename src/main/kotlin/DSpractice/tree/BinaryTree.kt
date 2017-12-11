package DSpractice.tree


import java.util.*
import kotlin.collections.ArrayList

open class BinaryTree<T>{
    var emptyNum:Int=0
    var root:BinaryNode<T>?=null
    var deepth=0
    var widths:IntArray = kotlin.IntArray(10)
    enum class BinaryType{
        PREVIOUS,MIDDLE,POST,LEVEL
    }
    fun orderTree(node : BinaryNode<T>?,type:BinaryType)=
            when(type){
                BinaryType.PREVIOUS -> previousOrder(node)
                BinaryType.LEVEL ->levelOrder(node)
                BinaryType.MIDDLE -> middleOrder(node)
                BinaryType.POST ->postOrder(node)
            }
    private fun previousOrder(node : BinaryNode<T>?){
        if (node!=null){
            visitNode(node)
            previousOrder(node.leftChild)
            previousOrder(node.rightChild)
        }

    }
    private fun middleOrder(node : BinaryNode<T>?){
        if(node!=null){
            middleOrder(node.leftChild)
            visitNode(node)
            middleOrder(node.rightChild)
        }
    }
    private fun postOrder(node : BinaryNode<T>?){
        if(node!=null){
            postOrder(node.leftChild)
            postOrder(node.rightChild)
            visitNode(node)
        }

    }
    private fun levelOrder(root : BinaryNode<T>?){
       val queue : Queue<BinaryNode<T>>  = LinkedList<BinaryNode<T>>() as Queue<BinaryNode<T>>
        var node : BinaryNode<T>
        queue.offer(root)
        while (!queue.isEmpty()){
            node = queue.poll()
            visitNode(node)
            if(node.leftChild!=null){
                queue.offer(node.leftChild)
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild)
            }
        }
        println()
    }

    private fun insert(node:BinaryNode<T>?){
        var emptyCurrent =0
        if(node==null){
            emptyNum++
            return
        }
        if(root==null){
            root=node
            return
        }
        val queue :Queue<BinaryNode<T>> = LinkedList<BinaryNode<T>>()
        var temp :BinaryNode<T>
        queue.offer(root)
        while (!queue.isEmpty()){
            temp=queue.poll()
            if(temp.leftChild==null){
                if (emptyNum==emptyCurrent){
                    temp.leftChild=node
                    node.parent=temp
                    return
                }else{
                    emptyCurrent++
                }
            }else{
                queue.offer(temp.leftChild)
            }
            if(temp.rightChild==null){
                if (emptyNum==emptyCurrent){
                    temp.rightChild=node
                    node.parent=temp
                    return
                }else{
                    emptyCurrent++
                }
            }else{
                queue.offer(temp.rightChild)
            }
        }

    }
    private fun visitNode(node: BinaryNode<T>) = print("${node.element} ")
    fun getNodeNum(num:Int,root :BinaryNode<T>?): Int=if (root==null) 0 else if (root.getNum()==num) 1+getNodeNum(num, root.leftChild)+getNodeNum(num,root.rightChild) else getNodeNum(num, root.leftChild)+getNodeNum(num,root.rightChild)
    fun getHeight(root: BinaryNode<T>?):Int=if(root==null) 0 else getHeight(root.rightChild)+getHeight(root.leftChild)
    private fun _getWidth(root: BinaryNode<T>?){
        if (root==null){
            return
        }
        if(deepth==0){
            widths[0]=1
        }
        if(root.leftChild!=null){
            widths[deepth+1]+=1
            deepth+=1
            _getWidth(root.leftChild)
        }
        if(root.rightChild!=null){
            widths[deepth+1]+=1
            deepth+=1
            _getWidth(root.rightChild)
        }
        deepth-=1
    }
    fun getWidth(root: BinaryNode<T>?): Int{
        widths = kotlin.IntArray(100)
        deepth=0
        _getWidth(root)
        var max = widths[0]
        for (i in 1..99){
            max= maxOf(max,widths[i])
        }
        return max
    }
    fun getMax(root: BinaryNode<Int>):Int{
        var max :Int=root.element
        if(root.leftChild==null&&root.rightChild==null){
            return root.element
        }
        val rightChild = root.rightChild
        if (rightChild!=null){
            max = maxOf(getMax(rightChild),max)
        }
        val leftChild = root.leftChild
        if(leftChild!=null){
            max= maxOf(max,getMax(leftChild))
        }
        return max
    }
    fun swap(root: BinaryNode<T>?){
        if(root==null)
            return
        swap(root.leftChild)
        swap(root.rightChild)
        val temp=root.leftChild
        root.leftChild=root.rightChild
        root.rightChild=temp
    }
    fun deleteLeaves(root: BinaryNode<T>?){
        if(root==null){
            return
        }
        if(root.leftChild==null&&root.rightChild==null){
            val parent = root.parent
            if(parent!=null){
                if(parent.rightChild==root){
                    parent.rightChild=null
                }else{
                    parent.leftChild=null
                }
            }
            root.parent=null
            return
        }
        deleteLeaves(root.leftChild)
        deleteLeaves(root.rightChild)
    }
    fun isComplete(root : BinaryNode<T>):Boolean{
            val queue : Queue<BinaryNode<T>> = LinkedList<BinaryNode<T>>()
            queue.offer(root)
        var temp =queue.poll()
        while (temp!=null){
            queue.offer(temp.leftChild)
            queue.offer(temp.rightChild)
            temp=queue.poll()

        }
        while (!queue.isEmpty()){
            if(queue.poll()!=null){
                return false
            }
        }
        return true
    }
    fun createTree1(pre:List<T>,mid:List<T>){
        root=_createTree1(pre,mid)
    }
    private fun _createTree1(pre:List<T>,mid:List<T>):BinaryNode<T>?{
        if (pre.isEmpty()){
            return null
        }
        val node : BinaryNode<T> = BinaryNode(pre[0])

        for (i in 0..mid.size){
            if (pre[0]==mid[i]){
                node.leftChild=_createTree1(pre.subList(1,i+1),mid.subList(0,i))
                node.rightChild=_createTree1(pre.subList(i+1,pre.size), mid.subList(i+1, mid.size))
                break
            }
        }
        return node
    }


}

