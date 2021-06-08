#
# @lc app=leetcode id=1476 lang=python3
#
# [1476] Subrectangle Queries
#

# @lc code=start
class SubrectangleQueries:

    def __init__(self, rectangle: List[List[int]]):
        self.rect = rectangle
        self.updates =[]
        
    def updateSubrectangle(self, row1: int, col1: int, row2: int, col2: int, newValue: int) -> None:
        self.updates.append([row1, col1, row2, col2, newValue])

    def getValue(self, row: int, col: int) -> int:
        for v in list(reversed(self.updates)): 
            if  v[0] <= row <=v[2] and v[1] <= col <= v[3]:
                return v[4]
        return self.rect[row][col]
                


# Your SubrectangleQueries object will be instantiated and called as such:
# obj = SubrectangleQueries(rectangle)
# obj.updateSubrectangle(row1,col1,row2,col2,newValue)
# param_2 = obj.getValue(row,col)
# @lc code=end

