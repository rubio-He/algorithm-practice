public class lintcode389_Longest_Increasing_Continuous_Subsequence {
    /*
     * @param A: An array of Integer
     * @return: an integer
     * O(n) time and O(1) extra space.
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int max = 0;
        int cur = 1;
        if(A.length == 1 || A == null) return 1;
        for(int i = 1; i < A.length; i++){
            if(A[i-1] < A[i]){
                cur++;
                max = Math.max(max, cur);
            }
            else{
                cur = 1;
            }
        }
        cur = 1;
        for(int i = A.length - 2;  i >= 0 ; i--){
            if(A[i] > A[i+1]){
                cur++;
                max = Math.max(max, cur);
            }
            else{
                cur = 1;
            }
        }
        return max;
    }

}
