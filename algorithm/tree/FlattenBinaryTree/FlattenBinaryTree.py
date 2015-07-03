#!/bin/python/
class Solution:
    # @param {TreeNode} root
    # @return {void} Do not return anything, modify root in-place instead.
    def flatten(self, root):
        if root == None:
            return
        
        left  = root.left
        right = root.right
        
        if left is not None:
            root.right = left
            root.left  = None
            rightmost = left
            while rightmost.right != None:
                rightmost = rightmost.right
            rightmost.right = right
        self.flatten(root.right)

