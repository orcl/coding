#!/usr/bin/python
#
#

class Solution:
  #@param{TreeNode} root
  #@param{TreeNode} p
  #@param{TreeNode} q
  #@return {TreeNode} 

  def lowestCommonAncestor(self, root, p, q):
    if root is None:
      return None

    if root == p or root == q:
      return root

    left  = self.lowestCommonAncestor(root.left, p, q)
    right = self.lowestCommonAncestor(root.right, p, q)
    if left is not None and right is not None:
      return root
    if left is not None:
      return left
    else:
      return right


