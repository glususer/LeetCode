class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object TreeNode {
  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
}

//Runtime: 1084 ms, faster than 6.25% of Scala online submissions for Count Good Nodes in Binary Tree.
//Memory Usage: 86.8 MB, less than 6.25% of Scala online submissions for Count Good Nodes in Binary Tree.
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
def helperGoodNodes(root: TreeNode, count: Int, maxValueSeenSoFar: Int): Int = {
  if (root == null) 0
  else {
    val nodesFromLeft = if (maxValueSeenSoFar <= root.value) helperGoodNodes(root.left, count, root.value)
    else helperGoodNodes(root.left, count, maxValueSeenSoFar)

    val nodesFromRight = if (maxValueSeenSoFar <= root.value) helperGoodNodes(root.right, count, root.value)
    else helperGoodNodes(root.right, count, maxValueSeenSoFar)

    nodesFromLeft + nodesFromRight + {
      if (maxValueSeenSoFar <= root.value) 1 else 0
    }
  }
}

def goodNodes(root: TreeNode): Int = {
  helperGoodNodes(root, 0, Integer.MIN_VALUE)
}
/*val tree = TreeNode(3,
  TreeNode(1,
    TreeNode(3, null, null),
    null),
  TreeNode(4,
    TreeNode(1, null, null),
    TreeNode(5, null, null)))*/

val tree1 = TreeNode(3,
  TreeNode(3, TreeNode(4, null, null), TreeNode(2, null, null)),
  null)

goodNodes(tree1)

