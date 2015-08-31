#!/usr/bin/python
#
#
from sets import Set
class Solution(object):
  def isHappy(self,n):
    """
    :type n: int
    :rtype: bool
    """
    if n <= 0:
      return false
    hashset = Set([])
    while n not in hashset:
      hashset.add(n)
      n = self.getSum(self.getDigits(n))
      if n == 1:
        return True
    return False

  def getSum(self,list):
    sum1 = 0
    for num in list:
      sum1 = sum1 + num*num
    return sum1

  def getDigits(self,n):
    digit_list = []
    while n > 0:
      res = n%10
      n   = n/10
      digit_list.append(res)
    return digit_list






