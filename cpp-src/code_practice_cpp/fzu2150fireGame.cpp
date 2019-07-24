#include<cstring>
#include<cstdio>
#include<queue>
#include<algorithm>
#include<iostream>
using namespace std;
int inf = 0x3f3f3f3f;
int n, m, t;
char board[16][16];
int vi[16][16], cnt ,tot, dep ;
queue< pair<int, int> > q, nq;
int dir1[4] = {0, 0, 1, -1}, dir2[4] = {1, -1, 0, 0};
int bfs(){
	int res = inf;
	for(int i = 0; i < n * m; i++){
		for(int j = i; j < n * m; j++){
			if(board[i/n][i%n] == '#' && board[j/n][j%n] == '#'){
                cnt = 0, dep = 0;
                memset(vi, 0, sizeof(vi));
				while(q.size()) q.pop();
				while(nq.size()) nq.pop();
				q.push(make_pair(i/n, i%n));
				if(i != j)q.push(make_pair(j/n, j%n));
				while(1){
					while(q.size()){
						pair<int, int> tmp = q.front(); q.pop();
						int x = tmp.first, y = tmp.second;
						if(x<0||x>=n||y<0||y>=m||vi[x][y]||board[x][y]!='#') continue;
						vi[x][y] = 1;
						cnt++;
                        
						for(int dir = 0; dir < 4; dir++){
							int xx = x + dir1[dir], yy = y + dir2[dir];
                            // if(xx<0||xx>=n||yy<0||yy>=m||vi[xx][yy]||board[xx][yy]!='#') continue;
							nq.push(make_pair(xx,yy));
						}
					}
                    if(!nq.size()) break; 
					dep++;
					q = nq;
					while(nq.size()) nq.pop();
				}
                if(cnt == tot) res = min(dep, res);
                cnt = 0;
			}
		}
	}
	return res;
}


int main(){
    freopen("input.txt", "r", stdin);
	scanf("%d", &t);
	for(int i = 0;i < t; i++){
		scanf("%d%d",&n,&m);
		for(int j = 0; j < n; j++){
			scanf("%s", board[j]);
		}
		tot = 0;
		for(int j = 0; j < n * m; j++){
			if(board[j/n][j%m] == '#') tot++;
		}
		int res = bfs();
		if(res == inf) printf("Case %d: %d\n", i+1, -1);
		else printf("Case %d: %d\n", i+1, res-1);
	}

	return 0;
}
