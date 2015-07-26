#!/usr/bin/python
#
#

class Solution:
  def productExceptSelf(self,nums):
    result = [None]*len(nums)
    left   = [None]*len(nums)
    right  = [None]*len(nums)

    left[0] =1
    right[len(nums)-1] = 1

    for i in range(1, len(nums)):
      left[i] = left[i-1] * nums[i-1]
      right[len(nums)-i-1] = right[len(nums)-i] * nums[len(nums)-i]

    for i in xrange(0,len(nums)):
      result[i] = left[i] * right[i]

    return result


