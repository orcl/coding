#!/usr/bin/python
#
#
'''
  Problem: 3 Sum
      given an array S of n integers, are there elements a,b,c in S such that a+b+c = 0? Find all uniq triplets in the array
      which gives the sum of zero.

      Note: elements in a triplet(a,b,c) must be in non-descending order (a <= b <= c)
      the solutions set must not contain duplicate triplets.

  Solution:
      1. sort the arrays (for non-descending solutions.)
      2. outer loop loops through the nums array, check only (i == 0 or nums[i] != nums[i-1]), this is to ensure that we don't get duplicates.
      3. use while loop(inner) to check every possibility, start = i+1, end = len(num)-1
          if nums[start] + nums[end] == negate:
            simply add the solution to the result.
'''

class Solution(object):
  def threeSum(self, nums):
    '''
    :type nums List[int]
    :rtype: List[List[int]]
    '''
    result = []
    if len(nums) < 3:
      return result

    #sort array
    nums.sort()

    for i in xrange(0,len(nums)-2):
      #avoid duplicate solutions
      if i == 0 or nums[i] != nums[i-1]:  #here is to get rid of  duplicates.
        negate = -nums[i]

        start = i + 1
        end = len(nums) - 1

        while start < end:
          if nums[start] + nums[end] == negate:
            tmp = []
            tmp.append(nums[i])
            tmp.append(nums[start])
            tmp.append(nums[end])

            result.append(tmp)
            start = start + 1
            end = end - 1
            #avoid duplicate solutions
            while start < end and nums[end] == nums[end+1]:
              end = end -1
            while start < end and nums[start] == nums[start-1]:
              start = start + 1
          elif nums[start] + nums[end] < negate:
            start = start + 1
          else:
            end = end - 1
    return result







