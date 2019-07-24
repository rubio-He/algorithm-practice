public class Encode_String_with_shortest_length {
    public String encode(String s) {
        if(s == null || s.length() <= 4) return s;
        int n = s.length();
        String[][] dp = new String[n][n];

        for(int l = 0; l < n; l++){
            for(int i = 0; i < n - l; i++){
                int j = i + l;
                String substr = s.substring(i,j+1);
                if(j - i < 4) {
                    dp[i][j] = substr;
                }
                else{
                    dp[i][j] = substr;
                    for(int k = i; k < j; k++){
                        if(dp[i][j].length() > dp[i][k].length() + dp[k][j].length()){
                            dp[i][j] = dp[i][k] + dp[k][j];
                        }
                    }


                    for(int k = 0; k < substr.length() / 2; k++){
                        String repeatedStr = substr.substring(0,k+1);
                        if(substr != null
                                && substr.replaceAll(repeatedStr, "").length() == 0
                                && substr.length() % repeatedStr.length() == 0){
                            String ss =  substr.length() / repeatedStr.length() +  "[" + repeatedStr + "]";
                            dp[i][j] = dp[i][j].length() < ss.length() ? dp[i][j] : ss;
                        }
                    }
                }
            }
        }



        return dp[0][n - 1];
    }
}
