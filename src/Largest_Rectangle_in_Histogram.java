import java.util.*;

public class Largest_Rectangle_in_Histogram {
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
