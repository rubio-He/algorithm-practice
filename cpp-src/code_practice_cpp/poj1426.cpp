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
#define N 1024
#define RDI(x) scanf("%d",&x)   
#define RDII(x,y) scanf("%d,%d",&x,&y) 
#define PTI(x) printf("%d", x);
#define FOR(x,y,z) for(int x = (y); x < (z); x++)
#define FORR(x,y,z) for(int x = (y); x >= (z); x--) 
#define MS0(x) memset(x, 0, sizeof(x))

int n; 
void bfs(){
	queue<ll> q;
	ll x = 1, pos;
	q.push(x);
	while(!q.empty()){
		pos = q.front();
		q.pop();
		FOR(i,0,2){
			x = pos*10 +i;
			if(x % n == 0){
				cout << x << endl;
				return;
			}
			q.push(x);
		}
	}
}


int main(){
	freopen("input.txt", "r", stdin);
	while(RDI(n) != EOF){
		if(n == 0) break;
		bfs();
	}
	return 0;

}