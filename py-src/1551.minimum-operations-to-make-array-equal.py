#
# @lc app=leetcode id=1551 lang=python3
#
# [1551] Minimum Operations to Make Array Equal
#
# 0 2 4 6 8 10 135
# @lc code=start
class Solution:
    def minOperations(self, n: int) -> int:
        if n % 2 == 1:
            return ((n//2 * 2) * (n//2 + 1)) // 2 
        else:
            return (((n//2-1) * 2) * (n//2)) // 2 + (n//2)



 # @lc code=end

