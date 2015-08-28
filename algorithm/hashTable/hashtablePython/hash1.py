import fileinput

class Entry:
  def __init__(self, key, value):
    self.key = key
    self.value = value

class MyHashTable:
  def __init__(self, capacity):
    self.capacity = capacity
    self.list1 = [[]]*capacity

  def put(self,k,v):
    slot = self.hash(k)
    bucket = self.list1[slot]
    key_in_bucket = False
    for entry in bucket:
      if entry.key == k:
        entry.value = v
        key_in_bucket = True
    if key_in_bucket == False:
      self.list1[slot].append(Entry(k,v))

  def get(self,k):
    slot = self.hash(k)
    bucket = self.list1[slot]
    for entry in bucket:
      if entry.key == k:
        return entry.value


  def hash(self,k):
    i = 0 
    total = 0
    while i < len(k):
      total = total + ord(k[i])
      i = i + 1
    return total % self.capacity


if __name__ == "__main__":
  hashtable = MyHashTable(100)
  for line in fileinput.input():
    line = line.strip()
    k,v = line.split('=') if '=' in line else (line, None)
    if v:
      hashtable.put(k,v)
    else:
      print str(hashtable.get(k)).replace('None','null')



