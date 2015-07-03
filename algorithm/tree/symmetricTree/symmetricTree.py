#!/usr/bin/python
#
#

def isSymmetric(self, root):
  if root is None:
    return True
  return self.isSym(root.left, root.right)


def isSym(self, l, r):
  if l is None and r is None:
    return True
  if l is None or r is None:
    return False
  if l.val != r.val
    return False
  return self.isSym(l.left, r.right) and self.isSym(l.right, r.left)



