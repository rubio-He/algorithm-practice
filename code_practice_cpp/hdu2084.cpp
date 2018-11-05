#include<cstring>
#include<cstdio>
#include<algorithm>
using namespace std;
int c, n, tower[105][105];
int dp[105][105], res;
int main(){
	scanf("%d", &c);
	for(int i = 0; i < c; i++){
		scanf("%d", &n);
		memset(tower, 0, sizeof(tower));
		for(int j = 0; j < n; j++){
			for(int k = 0; k <= j; k++ ){
				scanf("%d", &tower[j][k]);
			}
		}
		memset(dp, 0, sizeof(dp));	
		res = -1;
		dp[0][0]=tower[0][0];
		for(int i = 1; i < n; i++){
			dp[i][0] = tower[i][0] + dp[i-1][0];
			for(int j = 1; j <= i; j++){
				dp[i][j] = tower[i][j] + max(dp[i-1][j],dp[i-1][j-1]);

			}
		}
		for(int i =0; i < n; i++){
		    res = max(res, dp[n-1][i]);	
		}
        printf("%d\n", res);

	}	
}
