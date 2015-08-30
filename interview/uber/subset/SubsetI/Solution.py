#!/usr/bin/python
#
#

class Solution(object):
  def subsets(self,nums):
      '''
      :type nums: List[int]
      :rtype: List[List[int]]
      '''
      result = []
      path   = []
      position = 0
      nums.sort()
      self.subsetsHelper(result,path, nums,position)
      return result

  def subsetsHelper(self,result,path,nums,position):
    result.append(list(path))

    for i in xrange(position, len(nums)):
      path.append(nums[i])
      self.subsetsHelper(result,path,nums,i+1)
      path.pop()






