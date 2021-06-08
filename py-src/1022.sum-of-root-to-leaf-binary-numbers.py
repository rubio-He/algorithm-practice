#
# @lc app=leetcode id=1022 lang=python3
#
# [1022] Sum of Root To Leaf Binary Numbers
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        def recursive(root, node):
            if not node:
                return 0
            
            v = root * 2 + node.val
            left = recursive(v, node.left)
            right = recursive(v, node.right)
            if left == 0 and right == 0:
                return v
            else:
                return left + right
        return recursive(0, root)
        
# @lc code=end

