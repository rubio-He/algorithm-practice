#
# @lc app=leetcode id=1702 lang=python3
#
# [1702] Maximum Binary String After Change
#
# 1011
# 010101010100
# @lc code=start
class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        findZero = False
        oneCnt = 0
        for c in binary:
            if c == '0': findZero = True
            if c == '1' and findZero == True: oneCnt += 1
        if findZero == False:
            return binary
        return '1' * (len(binary) - 1 - oneCnt) + '0' + oneCnt * '1'

            


# @lc code=end

