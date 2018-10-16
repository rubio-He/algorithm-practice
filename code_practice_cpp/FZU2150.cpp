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



int vi[16][16];
int dir1[4] = {0,0,1,-1};
int dir2[4] = {1,-1,0,0};
int t, n, m, tot, icase, res;
char board[16][16];
int bfs(int n1, int n2){
	queue<PII> q;
	int x1 = n1 /m; 
	int y1 = n1 %m;
	int x2 = n2/m;
	int y2 = n2%m;
	int cnt = 0;
	if(board[x1][y1] == '.' || board[x2][y2] == '.') return -1;
	MS0(vi); cnt = 0;
	q.push(MP(0, n1));
	q.push(MP(0, n2));
	vi[x1][y1] = 1; vi[x2][y2] = 1;
	while(q.size()){
		PII p = q.front(); q.pop();
		cnt++;
		int dep = p.first;
		int x = p.second/m, y = p.second%m;
		FOR(i,0,4){
			int xx = x + dir1[i], yy = y + dir2[i];
			if(xx < 0 ||
				xx >= n ||
				yy < 0  ||
				yy >= m || 
				vi[xx][yy] ||
				board[xx][yy] != '#'
				) 
			continue;
			vi[xx][yy]=1;
			q.push(MP(dep+1, xx*m + yy));
		}
		if(cnt == tot){
			return dep;
		}
	}
	return -1;
}

int main(){
	 // freopen("input.txt", "r", stdin);
	 RDI(t);
	 icase = 0;
	 while(t--){
	 	icase++;
	 	RDII(n,m);
	 	FOR(i, 0, n) scanf("%s",board[i]);
	 	tot = 0;
	 	FOR(i,0,n){
	 		FOR(j,0,m){
	 		 	if(board[i][j] =='#') tot++;
	 		}
	 	}

	 	res = -1;
	 	FOR(i,0,n*m){
	 		FOR(j,i+1,n*m){
	 			int ans = bfs(i,j);
	 			if(ans < 0) continue;
	 			else{
	 				if(res < 0 || ans < res){
	 					res = ans;
	 				}
	 			}
	 		}
	 	}

	 	printf("Case %d: %d\n", icase, res);

	 }
}