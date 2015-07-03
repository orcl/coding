#!/usr/bin/python
#
#

class Solution:
  def invertTree(self, root):
    queue = []
    if root is not None:
      queue.append(root)

    while len(queue) is not 0:
      p = queue.pop(0)
      if p.left is not None:
        queue.append(p.left)
      if p.right is not None:
        queue.append(p.right)

      temp = p.left
      p.left = p.right
      p.right = temp

    return root


class solution:
  def invertTree(self, root):
    if root == None:
      return root

    queue = []
    queue.append(root)

    while len(queue) > 0:
      tmp = queue.pop(0)
      if tmp.left is not None:
        queue.append(tmp.left)
      if tmp.right is not None:
        queue.append(tmp.right)

      temp = tmp.left
      tmp.left = tmp.right
      tmp.right = temp

    return root



