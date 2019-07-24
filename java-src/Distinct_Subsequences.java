public class Distinct_Subsequences {
    int count = 0;
    public static int numDistinct(String s, String t) {
        //dp?
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[n][m];
        for(int i = 0; i< n; i++){
            int count = 0;
            for(int j = i ;j < m; j++){
                if(s.charAt(j) == t.charAt(i)){
                    if(i == 0){
                        count++;
                    }
                    else{
                        count+= dp[i-1][j-1];
                    }
                }
                dp[i][j] = count;

            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args){
        System.out.print(numDistinct("rarabbbit","rabbit"));
    }
}
