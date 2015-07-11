#!/usr/bin/python
#
#

class Stack:
  #initialize your data structure here.
  def __init__(self):
    self.queue1 = []
    self.queue2 = []


  #@param x, an integer
  #@return nothing
  def push(self,x):
    if not self.queue1:
      self.queue2.append(x)
    else:
      self.queue1.append(x)

  #@return nothing
  def pop(self):
    size = 0
    if not self.queue1:
      #queue1 is empty, shift queue2 to queue1, remove the last from queue2
      tmp = 0
      size = len(self.queue2)
      while tmp < size - 1:
        self.queue1.append(self.queue2.pop(0))
        tmp = tmp + 1
      self.queue2.pop(0)
    else:
      #queue2 is empty, shift queue1 to queue2, remove the last from queue1
      tmp = 0
      size = len(self.queue1)
      while tmp < size - 1:
        self.queue2.append(self.queue1.pop(0))
        tmp = tmp + 1
      self.queue1.pop(0)

  #@return an integer
  def top(self):
    result = 0
    size = 0
    if not self.queue1:
      #queue1 is empty, shift queue2 to queue1, remove the last from queue2
      tmp = 0
      size = len(self.queue2)
      while tmp < size - 1:
        self.queue1.append(self.queue2[0])
        self.queue2.pop(0)
        tmp = tmp + 1
      result = self.queue2[0]
      self.queue2.pop(0)
      self.queue1.append(result)
    else:
      #queue2 is empty, shift queue1 to queue2, remove the last from queue1
      tmp = 0
      size = len(self.queue1)
      while tmp < size -1:
        self.queue2.append(self.queue1[0])
        self.queue1.pop(0)
        tmp = tmp + 1
      result = self.queue[0]
      self.queue1.pop(0)
      self.queue2.append(result)
    return result

  #@return an boolean
  def empty(self):
    return len(self.queue1) == 0 and len(self.queue2) == 0

def main():
  print "hello"

if __name__ == "__main__":
  main()

