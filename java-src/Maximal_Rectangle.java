import java.util.Stack;

public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] h = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){

                if(matrix[i][j] == '0') h[i][j] = 0;
                else{
                    h[i][j] = i == 0 ? 1 : h[i-1][j] + 1;
                }
            }
        }
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, largestRectangleArea(h[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int len = heights.length;
        int res = 0;
        for(int i = 0; i <= len; i++){
            int h = i == len ? 0 : heights[i];
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }
            else{
                int tp = s.pop();
                res = Math.max(res, heights[tp] * ( s.isEmpty() ? i : i - 1 - s.peek()));
                i--;

            }
        }
        return res;
    }
}
