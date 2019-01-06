#include<cstring>
#include<cstdio>
#include<algorithm>
using namespace std;
int main(){
    int dp[250][250]; 
    // freopen("input.txt", "r", stdin);
    int t, c;
    scanf("%d", &t);
    while(t--){
        memset(dp, 0, sizeof(dp));
        scanf("%d", &c);
        for(int i = 0; i < c;i++){
            for(int j = 0; j < i + 1; j++){
                scanf("%d", &dp[i][j]);
            }
        }
        for(int i = c - 2; i >= 0; i--){
            for(int j = 0; j < i + 1; j++){
                dp[i][j] = max(dp[i + 1][j], dp[i+1][j +1]) + dp[i][j]; 
            }
        }

        printf("%d\n",dp[0][0]);
    }
    return 0;
}
