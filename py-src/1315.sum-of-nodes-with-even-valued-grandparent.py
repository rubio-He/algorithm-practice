#
# @lc app=leetcode id=1315 lang=python3
#
# [1315] Sum of Nodes with Even-Valued Grandparent
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        def sum(root, lvl, nextlvl):
            if root == None:
                return 0
            even = root.val % 2 == 0
            v = sum(root.left, nextlvl, even) + sum(root.right, nextlvl, even)
            if lvl:
                return v + root.val
            return v 
        return sum(root, False, False)
# @lc code=end

