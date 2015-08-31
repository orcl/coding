#!/usr/bin/python
#
#

class Solution(object):
  def fourSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype List[List[int]]
    """

    result = []
    #sort the nums array
    nums.sort()

    if len(nums) < 4:
      return result

    for i in xrange(0,len(nums)-3):
      if i == 0 or nums[i] != nums[i-1]:
        for j in xrange(i+1, len(nums)-2):
          if j == i+1 or nums[j] != nums[j-1]:
            left = j+1
            right = len(nums) - 1
            while left < right:
              sum1 = nums[i] + nums[j] + nums[left] + nums[right]
              if sum1 == target:
                tmp = []
                tmp.append(nums[i])
                tmp.append(nums[j])
                tmp.append(nums[left])
                tmp.append(nums[right])
                result.append(tmp)
                while left < right and nums[left] == nums[left + 1]:
                  left = left + 1
                while left < right and nums[right] == nums[right-1]:
                  right = right - 1
                elif sum1 < target:
                  left = left + 1
                else:
                  right = right - 1
    return result






