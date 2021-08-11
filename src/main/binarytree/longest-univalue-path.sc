import binarytree.TreeNode

/*
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object TreeNode {
  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
}
*/

//https://leetcode.com/problems/longest-univalue-path/
def helperLongestUnivaluePath(node: TreeNode, parentVal: Int, maxlength:Int):Int={
  if(node == null) 0
  else{
    val leftTree = if(parentVal == node.value) helperLongestUnivaluePath(node.left, parentVal, maxlength+1) else helperLongestUnivaluePath(node.left, node.value, maxlength)
    val rightTree = if(parentVal == node.value) helperLongestUnivaluePath(node.right, parentVal, maxlength+1) else helperLongestUnivaluePath(node.right, node.value, maxlength)
    math.max(leftTree, rightTree)+ {if(parentVal == node.value) 1 else 0}
  }
}

def longestUnivaluePath(root: TreeNode): Int = {
  helperLongestUnivaluePath(root, root.value,0)-1
}

val tree = TreeNode(5,
  TreeNode(4,TreeNode(1,null,null),TreeNode(1,null,null)),
  TreeNode(5,TreeNode(5,null,null),null))

val tree2 = TreeNode(1,
  TreeNode(4,
    TreeNode(4,null,null),
    TreeNode(4,null,null)),
  TreeNode(5,
    null,
    TreeNode(5,null,null)))

val tree3 = TreeNode(1,TreeNode(2,null,null),null)

longestUnivaluePath(tree2)
