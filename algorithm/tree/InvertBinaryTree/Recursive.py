#!/usr/bin/python
#
#
class Solution:
  def invertTree(self, root):
    if root is not None:
      self.helper(root)
    return root

  def helper(self, p):
    temp = p.left
    p.left = p.right
    p.right = temp

    if p.left is not None:
      self.helper(p.left)

    if p.right is not None:
      self.helper(p.right)


class Solution:
  def invertTree(self, root):
    if root == None:
      return root

    temp = root.left
    root.left = root.right
    root.right = temp

    if root.left is not None:
      self.invertTree(root.left)

    if root.right is not None:
      self.invertTree(root.right)

    return root



