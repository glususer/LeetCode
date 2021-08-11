

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object TreeNode {
  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
}

def inOrderTraversal(tree: TreeNode, acc: List[Int]): List[Int] = {
  if (tree == null) acc
  else {
    inOrderTraversal(tree.left, acc) ::: (tree.value :: acc) ::: inOrderTraversal(tree.right, acc)
  }
}

def findMax(node: TreeNode, parent: TreeNode): (TreeNode, TreeNode) ={
  node match{
    case z if(z == null) => (null,null)
    case x if (x.right == null) => (x, parent)
    case y if(y.right != null) => findMax(y.right,y)
  }
}

def findMin(node: TreeNode, parent: TreeNode): (TreeNode, TreeNode)={
  node match{
    case z if(z == null) => (null, null)
    case x if(x.left == null)  => (x, parent)
    case y if(y.left != null) => findMin(y.left,y)

  }
}

def findKey(node: TreeNode, key:Int, parent:TreeNode):(TreeNode,TreeNode)={
  node match{
    case t  if t == null => null
    case x if (x.value < key) =>findKey(x.right, key,x)
    case y if(y.value > key) => findKey(y.left, key,y)
    case z if(z.value == key) => (z, parent)
  }
}

def deleteNode(root: TreeNode, key: Int): TreeNode = {
  val (nodeToBeDeleted, parent) = findKey(root, key,null)
  val (maxInLeftSubTree, parentMax) = findMax(nodeToBeDeleted, null)
  val (minInRightSubTree, parentMin) = findMin(nodeToBeDeleted, null)

  if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
    parent.left = null
    parent.right = null
  } else if(nodeToBeDeleted.value == minInRightSubTree.value){
    nodeToBeDeleted.value = maxInLeftSubTree.value
    parentMax.right = maxInLeftSubTree.left
  }else if(nodeToBeDeleted.value == maxInLeftSubTree.value){
    nodeToBeDeleted.value = minInRightSubTree.value
    parentMin.left = maxInLeftSubTree.right
  }
   root
}

val subTreeLeft12 = TreeNode(8,
  TreeNode(4, null, TreeNode(7, null,null)),
  TreeNode(13, TreeNode(12, TreeNode(11, null,null),null),null))

val subTreeRight12 = TreeNode(25, TreeNode(20, null,null),TreeNode(27, null,null))
val subTreeLeft1 = TreeNode(15,subTreeLeft12,subTreeRight12)

val subTreeLeft21 = TreeNode(30, null,null)
val subTreeRight21 = TreeNode(50,
  TreeNode(47, TreeNode(46, null,null),null),
  TreeNode(80, null,TreeNode(90, null,null)))

val subTreeRight1 = TreeNode(45,
  null,subTreeRight21)

val tree = TreeNode(28,subTreeLeft1, subTreeRight1)
//inOrderTraversal(tree, List.empty)

/*findMin(tree,null)
findMax(tree,null)
inOrderTraversal(tree, List.empty)

findMin(subTreeLeft12,null)
findMax(subTreeLeft12,null)
inOrderTraversal(subTreeLeft12, List.empty)

findMin(subTreeRight12,null)
findMax(subTreeRight12,null)
inOrderTraversal(subTreeRight12, List.empty)

findMin(subTreeLeft21,null)
findMax(subTreeLeft21,null)
inOrderTraversal(subTreeLeft21, List.empty)

findMin(subTreeLeft1,null)
findMax(subTreeLeft1,null)
inOrderTraversal(subTreeLeft1, List.empty)

findMin(subTreeRight1,null)
findMax(subTreeRight1,null)
inOrderTraversal(subTreeRight1, List.empty)*/

inOrderTraversal(deleteNode(tree,4), List.empty)
inOrderTraversal(deleteNode(tree,7), List.empty)
inOrderTraversal(deleteNode(tree,8), List.empty)
//inOrderTraversal(deleteNode(tree,11), List.empty)
//inOrderTraversal(deleteNode(tree,12), List.empty)
inOrderTraversal(deleteNode(tree,13), List.empty)
inOrderTraversal(deleteNode(tree,15), List.empty)
inOrderTraversal(deleteNode(tree,20), List.empty)
inOrderTraversal(deleteNode(tree,25), List.empty)
inOrderTraversal(deleteNode(tree,27), List.empty)
inOrderTraversal(deleteNode(tree,28), List.empty)
inOrderTraversal(deleteNode(tree,45), List.empty)
  inOrderTraversal(deleteNode(tree,46), List.empty)
  inOrderTraversal(deleteNode(tree,50), List.empty)
  inOrderTraversal(deleteNode(tree,80), List.empty)
  inOrderTraversal(deleteNode(tree,90), List.empty)



