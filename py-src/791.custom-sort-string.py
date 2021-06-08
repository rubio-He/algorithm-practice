#
# @lc app=leetcode id=791 lang=python3
#
# [791] Custom Sort String
#

# @lc code=start
import collections
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        counter = collections.Counter(T)
        res = ''
        for c in S:
            for i in range(counter[c]):
                res += c
            counter[c] = 0
        for c, cnt in counter.items():
            for i in range(cnt):
                res += c
        return res

# @lc code=end

