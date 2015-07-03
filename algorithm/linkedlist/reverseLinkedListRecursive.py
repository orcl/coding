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

    remaining = self.reverseList(head.next)
    head.next.next = head
    head.next = None
    return remaining


