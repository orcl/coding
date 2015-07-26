#!/usr/bin/python
#
#

class ListNode:
  def __init__(self,x):
    self.val = x
    self.next = None

class Solution:
  #@param {ListNode} node
  #@return {void} Do not return anything, modify node in-place instead.
  def deleteNode(self, node):
    next = node.next
    node.val  = next.val
    node.next = next.next
    next.next = None
