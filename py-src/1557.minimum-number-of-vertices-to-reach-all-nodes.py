#
# @lc app=leetcode id=1557 lang=python3
#
# [1557] Minimum Number of Vertices to Reach All Nodes
#

# @lc code=start
import collections
class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        indgree = collections.Counter()
        for edge in edges:
            indgree[edge[1]]+=1
        result = []
        for i in range(n):
            if indgree[i] == 0:
                result.append(i)
        return result
            
            

        
# @lc code=end

