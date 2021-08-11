class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object TreeNode {
  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
}

def helper(root: TreeNode, acc:Int, dir: String):Int={
  root match{
    case null => acc
    case leaf if(leaf.left == null && leaf.right == null) => if(dir=="LEFT")
      acc+leaf.value
      else acc
    case t => helper(t.left, acc,"LEFT")+ helper(t.right, acc,"RIGHT")
  }
}

//Runtime: 452 ms, faster than 85.71% of Scala online submissions for Sum of Left Leaves.
//Memory Usage: 53.1 MB, less than 85.71% of Scala online submissions for Sum of Left Leaves.
def sumOfLeftLeaves(root: TreeNode): Int = {
  helper(root,0,"")
}

val tree2 = TreeNode(10,
  TreeNode(5,
    TreeNode(3,null,null),
    TreeNode(7,null,null)),
  TreeNode(20,
    TreeNode(15,null,null),
    TreeNode(25,null,null)))

sumOfLeftLeaves(tree2)

