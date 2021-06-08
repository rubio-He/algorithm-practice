#
# @lc app=leetcode id=802 lang=python3
#
# [802] Find Eventual Safe States
#

# @lc code=start
class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph) 
        queue = []
        outDegree= collections.defaultdict(int)
        inDegree = collections.defaultdict(list)
        for i, l in enumerate( graph):
            outDegree[i] = len(l) 
            for v in l: inDegree[v].append(i)
            if len(l) == 0: queue.append(i)
        for q in queue:
            for node in inDegree[q]:
                outDegree[node]-=1
                if outDegree[node] == 0: queue.append(node)
        return sorted(queue)

                

        
# @lc code=end

