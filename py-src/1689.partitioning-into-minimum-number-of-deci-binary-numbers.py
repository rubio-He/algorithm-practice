#
# @lc app=leetcode id=1689 lang=python3
#
# [1689] Partitioning Into Minimum Number Of Deci-Binary Numbers
#

# @lc code=start
class Solution:
    def minPartitions(self, n: str) -> int:
        c = '0'
        for i in n:
            if i > c:  c = i
        return int(c)
        
# @lc code=end

