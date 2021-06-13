package binarytree

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object TreeNode {
  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)

  def isLeaf(tree: TreeNode): Boolean = tree.right == null && tree.left == null

  def insert(tree: TreeNode, item: Int): TreeNode = {
    if (tree == null) TreeNode(item, null, null)

    else if (isLeaf(tree)) {
      if (tree.value > item) tree.left = TreeNode(item, null, null)
      else tree.right = TreeNode(item, null, null)
      tree
    }

    else {
      if (tree.value < item) tree.right = insert(tree.right, item)
      else tree.left = insert(tree.left, item)
      tree
    }
  }
}
