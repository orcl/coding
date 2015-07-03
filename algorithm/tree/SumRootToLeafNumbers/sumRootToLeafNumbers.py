#!/usr/bin/python
#
#

class Solution:
  def sumNumbers(self, root):
    if root == None:
      return 0
    else:
      return self.sum(root,0)

  def sum(self, root, prev):
    if root.left == None and root.right == None:
      return 10*prev + root.val
    elif root.left is not None and root.right is not None:
      return self.sum(root.left, 10*prev + root.val) + self.sum(root.right, 10*prev + root.val)
    elif root.left is not None:
      return self.sum(root.left, 10*prev+root.val)
    else:
      return self.sum(root.right, 10*prev+root.val)


