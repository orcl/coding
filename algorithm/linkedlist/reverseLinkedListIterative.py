#!/usr/bin/python
#
#

class ListNode:
  def __init__(self,x):
    self.val = x
    self.next = None

class Solution:
  def reverseList(self, head):
    if head == None or head.next == None:
      return head

    prev = None
    curr = head
    while curr is not None:
      next = curr.next
      curr.next = prev

      prev = curr
      curr = next

    return prev

