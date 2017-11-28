package DSpractice.tree

fun main(args : Array<String>){
    val tree = BinaryTree<Int>()
    val root = BinaryNode(1)
    tree.insert(root)
    tree.insert(BinaryNode(2))
    tree.insert(BinaryNode(3))
    tree.insert(BinaryNode(4))
    tree.insert(BinaryNode(5))
    tree.insert(BinaryNode(6))
    tree.insert(BinaryNode(7))
    tree.insert(BinaryNode(8))
    tree.insert(null)
    tree.insert(BinaryNode(11))
    tree.insert(BinaryNode(12))
    tree.insert(null)
    tree.insert(null)
    tree.insert(null)
    tree.insert(null)
    tree.insert(BinaryNode(9))
    tree.insert(BinaryNode(10))
    tree.orderTree(root,BinaryTree.BinaryType.PREVIOUS)

    tree.orderTree(root,BinaryTree.BinaryType.POST)
    println(tree.getNodeNum(1,root))
    println(tree.getWidth(root))
    println(tree.getMax(root))
    tree.orderTree(root,BinaryTree.BinaryType.LEVEL)
    tree.deleteLeaves(root)
    tree.orderTree(root,BinaryTree.BinaryType.LEVEL)
    println(tree.isComplete(root))
//    val pre = listOf(1,2,4,5,6,7,8,3,9,10,11,12)
//    val mid = listOf(4,2,6,7,5,8,1,3,11,10,12,9)
//    tree.createTree1(pre,mid)
//    tree.orderTree(tree.root,BinaryTree.BinaryType.PREVIOUS)


}
