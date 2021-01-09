#
# @lc app=leetcode id=859 lang=python3
#
# [859] Buddy Strings
#

# @lc code=start
import collections

class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if len(A) != len(B):
            return False
        idx = -1
        for i in range(len(A)):
            if A[i] != B[i]:
                if idx >= 0:
                    if A[i] == B[idx] and A[idx] == B[i]:
                        idx = -2
                    else:
                        return False
                elif idx == -2:
                    return False
                else:
                    idx = i
        if idx == -2:
            return True
        if idx >= 0:
            return False
        counter = collections.Counter(A)
        for i,c in counter.items():
            if c >= 2:
                return True
        return False
            
# @lc code=end

