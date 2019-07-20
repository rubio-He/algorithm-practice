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

int dir1[4] = {1,-1,0,0};
int dir2[4] = {0,0,-1,1};
PII father[6][6];
int board[6][6], dis[6][6], vis[6][6];

void print_res(PII u){
	vector<PII> nodes;
	while(1){
		nodes.push_back(u);
		if(u.first== 0 && u.second == 0) break;
		u = father[u.first][u.second];
	}
	for(int i = nodes.size() - 1; i >= 0; i--){
		printf("(%d, %d)\n",nodes[i].first, nodes[i].second);
	}
	return;
}

void bfs(){
	queue<PII> q;
	q.push(MP(0,0));
	while(q.size()){
		PII p=q.front(); q.pop();
		if(p.first==4  && p.second == 4){
			print_res(MP(4,4));
			return;
		}
		FOR(i,0,5){
			int x = p.first + dir1[i], y = p.second+ dir2[i];
			if(x < 0||
				x > 4||
				y < 0 ||
				y > 4 ||
				vis[x][y] || 
				board[x][y] == 1)
				continue;
			else{
				vis[x][y] = 1;
				dis[x][y] = dis[p.first][p.second] + 1;
				father[x][y] = p;
				q.push(MP(x,y));
			}
		}
	}

}


int main(){
	freopen("input.txt","r",stdin );
	MS0(dis);
	MS0(father);
	MS0(vis);
	FOR(i,0,5){
		FOR(j,0,5){
			RDI(board[i][j]);
		}
	}
	bfs();
}