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
#define N 50007
int l,n,m, rk[N];

bool judge(int mid){
	int cnt = 0;
	int j = 0;
	int pre = rk[0];
	FOR(i, 1,n + 1){
		if(rk[i] - rk[j] < mid) cnt++;
		else j = i;
	}
	return cnt <= m ? 1 : 0;
}

int main(){
	freopen("input.txt", "r", stdin);
	RDI(l);
	RDII(n,m);
	FOR(i,0,n) RDI(rk[N]);
	rk[++n] = l; 
	sort(rk, rk+n + 1);
	int l = 0, r = N;
	while(l < r){
		int mid = l + (r - l+ 1)/2;
		if(judge(mid)){
			l = mid;
		}
		else{
			r = mid - 1;
		}
	}
	PTI(l);
	return 0;

}