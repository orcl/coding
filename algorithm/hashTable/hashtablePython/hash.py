#!/usr/bin/python
#
#

class Entry:
  def __init__(self,key,value):
    self.key = key
    self.value = value
  def __str__(self):
    return self.key+":"+str(self.value)

class HashTable:
  def __init__(self):
    self.capacity = 10
    self.list1 = [[]]*10
    print self.list1

  def getValue(self,key):
    slot = self.hash(key)
    bucket = self.list1[slot]
    for entry in bucket:
      if entry.key == key:
        return entry.value

  def setValue(self, key, value):
    slot = self.hash(key)
    bucket = self.list1[slot]
    key_in_bucket = False
    for entry in bucket:
      if entry.key == key:
        entry.value = value
        key_in_bucket = True
    if key_in_bucket == False:
      self.list1[slot].append(Entry(key,value))

  def hash(self,key):
    i = 0
    total = 0
    while i < len(key):
      total = total + ord(key[i])
      i = i + 1
    return total % self.capacity

def main():
  hashtable = HashTable()
  hashtable.setValue("shipeng","shipengValue.")
  hashtable.setValue("xiaoran","xiaoranValue.")
  print hashtable.getValue("shipeng")
  print hashtable.getValue("xiaoran")



if __name__ == "__main__":
  main()
