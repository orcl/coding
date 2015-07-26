#!/usr/bin/python
#
#

class Solution:
  #@param {integer[]} nums
  #@return {integer[]}
  def productExceptSelf(self,nums):
    result = [None]*len(nums)

    tmp = 1
    for i in xrange(0, len(nums)):
      result[i] = tmp
      tmp = tmp * nums[i]

    tmp = 1
    for i in xrange(0, len(nums)):
      result[len(nums)-1-i] = result[len(nums)-1-i] * tmp
      tmp = tmp * nums[len(nums) - 1 -i]

    return result



