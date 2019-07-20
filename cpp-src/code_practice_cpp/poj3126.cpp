#include <cstdio>
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
#include <cstring>
#include <string>
#include <cmath>
#include <vector>
#include <bitset>
#include <list>
#include <sstream>
#include <set>
#include <functional>
#include <map>
using namespace std;

typedef long long ll;
#define mod 100005
#define N 10016
#define RDI(x) scanf("%d",&x)   
#define RDII(x,y) scanf("%d %d",&x,&y) 
#define PTI(x) printf("%d\n", x);
#define FOR(x,y,z) for(int x = (y); x < (z); x++)
#define FORR(x,y,z) for(int x = (y); x >= (z); x--) 
#define MS0(x) memset(x, 0, sizeof(x))
#define MS1(x) memset(x, 1, sizeof(x))


int prime[N], t, start, ed,  dp[N];

void solve(){
	int nw =0, cnt = 0;
	queue<int> q, nq;
	FOR(i,0,N) dp[i] = N;
	dp[start] = 0;
	q.push(start);
	while(!q.empty()){
		int p = q.front();q.pop();

		if(p == ed){
			PTI(dp[p]);
			return;
		}
		FOR(i,0,4){
			FOR(j,0,10){
				if(i == 0 && j == 0) continue;
				if(i == 0){
					nw = p%1000 + j * 1000;
				}
				else if(i ==1){
					nw = p/1000 * 1000 + j * 100 + p% 100;
				}
				else if(i ==2){
					nw = p/100  * 100 + j * 10 + p % 10;
				}
				else if(i ==3){
					nw = p/10  * 10+  j;
				}
				if(prime[nw]&& dp[nw] > dp[p] + 1){
					dp[nw] = dp[p] + 1;
					q.push(nw);
				} 
			}
		}
	}
}

void sieve(){
	MS1(prime);
	prime[1] = 0;
	prime[2] = 1;
	for(int i = 2; i * i < N; i++){
		if(prime[i]){
			for(int j = i*i; j < N; j+=i){
				prime[j] = 0;
			}
		}
	}
}

int main(){
	 // freopen("input.txt", "r", stdin);
	 prime[1] = 1;
	 prime[2] = 1;
	 sieve();
	RDI(t);
	while(t--){
		RDII(start, ed);
		solve();
	}
	return 0;

}