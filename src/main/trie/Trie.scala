package trie
//package binarytree
//
//class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
//  var value: Int = _value
//  var left: TreeNode = _left
//  var right: TreeNode = _right
//}
//
//object TreeNode {
//  def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
//
//  def isLeaf(tree: TreeNode): Boolean = tree.right == null && tree.left == null
//
//  def insert(tree: TreeNode, item: Int): TreeNode = {
//    if (tree == null) TreeNode(item, null, null)
//
//    else if (isLeaf(tree)) {
//      if (tree.value > item) tree.left = TreeNode(item, null, null)
//      else tree.right = TreeNode(item, null, null)
//      tree
//    }
//
//    else {
//      if (tree.value < item) tree.right = insert(tree.right, item)
//      else tree.left = insert(tree.left, item)
//      tree
//    }
//  }
//}
class Trie(_value: Char = ' ', _children: List[Trie] = null) {
   var value = _value
   var children = _children
  /** Inserts a word into the trie. */
  def insert(word: String) {
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
   ???
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
   ???
  }

}

object Trie{

  def apply(_value: Char, _children: List[Trie]): Trie = new Trie(_value, _children)

  def isLeaf(node: Trie): Boolean = node.children == null

  def insert(trie: Trie, word: String): Trie={
    if(trie == null && word.nonEmpty){
      insert(Trie(word(0),null), word.drop(1))
    } else{

    }
  }

  def search(trie: Trie, word:String):Boolean={
    ???
  }

  def statrsWith(trie:Trie, word:String): Boolean={
    ???
  }

}
