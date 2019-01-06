//find a way
#include<cstdio>
#include<cstring>
#include<queue>
#include<algorithm>

using namespace std;

char board[205][205];
int n, m,dy[205][205], dm[205][205];
int dirs[4][2] = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
void bfs(int i,  int j,  char c ){
    int (&d)[205][205] = (c == 'Y'? dy : dm);
    int vis[205][205] = {0};
    pair<int, int> q[205 * 205];
    vis[i][j] = 1, d[i][j] = 0;
    int r = 0, l = 0;
    q[r++] = make_pair(i, j);
    while(l < r){
        i =  q[l].first,  j = q[l++].second;
        for(int dir=0 ; dir <4; dir++){
            int ii = i + dirs[dir][0], jj  = j + dirs[dir][1];
            if(ii >= 0 && ii < n && jj >= 0 && jj < m && !vis[ii][jj] && board[ii][jj] != '#'){
                q[r++] = make_pair(ii, jj);
                vis[ii][jj] = 1;
                d[ii][jj] = d[i][j] +1;
            }
        }
    }

}


int main(){
    freopen("input.txt", "r", stdin);
    while(~scanf("%d%d", &n, &m)){
        for(int i = 0; i < n; i++){
            scanf("%s", board[i]);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'Y' || board[i][j] == 'M') bfs(i, j, board[i][j]);
            }
        }
        int res = 205 * 205;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(board[i][j] == '@') res = min(res, dy[i][j]+dm[i][j]);
            }
        }
        printf("%d\n", res * 11);
    }
}