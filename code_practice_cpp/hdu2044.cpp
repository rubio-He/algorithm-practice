#include <cstring> 
#include <cstdio>
#include <cstdlib>

int n, a, b;
int main(){
    long long dp[55][55];
    memset(dp, 0, sizeof(dp));
    for(int i = 0;  i < 55; i++){
        for(int j = i+1; j < 55 ; j++){
            if(j - i == 1) dp[i][j] = 1;
            else if(j - i == 2) dp[i][j] = 2;
            else{
                dp[i][j] = dp[i][j-1] + dp[i][j-2];
            }     
        }
    }
    scanf("%d", &n);
    while(n--){
        scanf("%d%d",&a, &b);
        printf("%lld\n", dp[a][b]);
    }
    return 0;
}