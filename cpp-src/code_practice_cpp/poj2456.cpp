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
#define RDI(x) scanf("%d",&x)   
#define RDII(x,y) scanf("%d %d",&x,&y) 
#define PTI(x) printf("%d\n", x);
#define FOR(x,y,z) for(int x = (y); x < (z); x++)
#define FORR(x,y,z) for(int x = (y); x >= (z); x--) 
#define MS0(x) memset(x, 0, sizeof(x))
#define MS1(x) memset(x, 1, sizeof(x))
#define PII pair<int, int>
#define MP(x,y) make_pair(x,y)
#define PB(x) push_back(x)
#define N 100005
int n, c, fence[N];

void solve(){
	int l =  0, r = 100000;
	while(l<r){
		int m = l + (r -l+1)/2;
		int cnt = 1,sum = 0;

		FOR(i, 1, n){
			if(sum + fence[i] - fence[i-1] >= m) {
				cnt++;
				sum = 0;
			}
			else sum += fence[i] - fence[i-1];
		}
		if(cnt >= c){
			l = m;
		}
		else{
			r = m - 1;
		}
	}
	PTI(l);
}

int main(){
	// freopen("input.txt", "r", stdin);
	RDII(n,c);
	FOR(i,0,n){
		RDI(fence[i]);
	}
	sort(fence,fence+n);
	solve();
	return 0;
}