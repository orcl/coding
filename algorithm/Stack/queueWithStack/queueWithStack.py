class Queue:
  #initialize your data structure here.
  def __init__(self):
    self.inbox  = []
    self.outbox = []

  #@param x, an integer
  #@return nothing
  def push(self,x):
    self.inbox.append(x)

  #@return nothing
  def pop(self):
    if len(self.outbox) == 0:
      while len(self.inbox) > 0:
        self.outbox.append(self.inbox.pop())
      self.outbox.pop()

  #@return an integer
  def peek(self):
    if len(self.outbox) == 0:
      while len(self.inbox) > 0:
          self.outbox.append(self.inbox.pop())
    return self.outbox[len(self.outbox)-1]

  #@return an boolean
  def empty(self):
    return len(self.inbox) == 0 and len(self.outbox) == 0

