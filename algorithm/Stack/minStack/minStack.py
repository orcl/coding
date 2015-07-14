#!/usr/bin/python
#
#

class MinStack:
  #initialize your data structure here.
  def __init__(self):
    self.stack1 = []
    self.stack2 = []
    self.min    = sys.maxint

  #@param x, an integer
  #@return nothing
  def push(self,x):
    self.stack1.append(x)
    if x <= self.min:
      self.stack2.append(x)
      self.min = x

  #@return nothing
  def pop(self):
    tmp = self.stack1.pop()
    if tmp == self.min:
      self.stack2.pop()
      if len(self.stack2) == 0:
        self.min = sys.maxint
      else:
        self.min = self.stack2[len(self.stack2)-1]

  #@return an integer
  def top(self):
    return self.stack1[len(self.stack1)-1]

  #@return an integer
  def getMin(self):
    return self.stack2[len(self.stack2)-1]


