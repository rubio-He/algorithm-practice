#
# @lc app=leetcode id=1008 lang=python3
#
# [1008] Construct Binary Search Tree from Preorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        root = TreeNode(preorder.pop(0))
        idx = next((i for i, v in enumerate(preorder) if v > root.val), -1)
        if idx != -1:
            left =  preorder[0:idx]
            right = preorder[idx:]
        else:
            left = preorder
            right = []
        if len(left) != 0:
           root.left= self.bstFromPreorder(left)
        if  len(right)!= 0:
           root.right= self.bstFromPreorder(right)
        return root
            

        
# @lc code=end

