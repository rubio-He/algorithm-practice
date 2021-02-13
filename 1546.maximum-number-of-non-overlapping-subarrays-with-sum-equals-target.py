#
# @lc app=leetcode id=1546 lang=python3
#
# [1546] Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
#

# @lc code=start


class Solution:
    def maxNonOverlapping(self, nums: List[int], target: int) -> int:
        hashmap = {0: 0}
        prefixsum = 0
        res = 0
        for idx, val in enumerate(nums):
            prefixsum += val
            if prefixsum - target in hashmap:
                res+=1
                hashmap.clear()
            hashmap[prefixsum] = idx 
        return res

            


        
# @lc code=end

