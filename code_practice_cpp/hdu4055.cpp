#include<cstdio>
#include<cstring>
#include<cstdlib>
typedef long long ll;
int M = 1000000007;

ll dp[1005][1005];
ll sum[1005][1005];
char s[1005];
int len;
int main(){
    freopen("input.txt", "r", stdin);
    while(~scanf("%s", s)){
        len = strlen(s);
        memset(dp, 0, sizeof(dp));
        memset(sum, 0, sizeof(sum));
        sum[0][1] = 1; 
        for(int i = 1 ; i <= len; i++){
            for(int j = 1; j <= i + 1; j++){
                if(s[i-1] == 'D'){
                    dp[i][j] = (sum[i-1][i] - sum[i-1][j-1] + M) % M;
                }
                else if(s[i-1]=='I'){
                    dp[i][j] = sum[i-1][j-1];
                }
                else{
                    dp[i][j] = sum[i-1][i];
                }
                sum[i][j] = (sum[i][j-1] + dp[i][j])%M;
            }
        }
        printf("%d\n",sum[len][len+1]);
    }
    return 0;
}
