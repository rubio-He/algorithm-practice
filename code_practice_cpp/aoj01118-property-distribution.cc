#include<cstring>
#include<cstdio>

int r,c, v[105][105];
char board[105][105], now;
void dfs(int i, int j) {
    if(i < 0 || i >= r || j < 0 || j >=c || v[i][j]) return;
    if(now != board[i][j])  return;
    v[i][j] = 1;
    dfs(i+1, j);
    dfs(i-1, j);
    dfs(i, j+1);
    dfs(i, j-1);
}
int main() {
   // freopen("input.txt", "r", stdin);
    while(scanf("%d%d",&r, &c)){
        if(r == 0) break;
        for(int i =0; i < r; i++)  scanf("%s", board[i]);
        int res = 0;
        for(int i =0; i < r; i++){
            for(int j = 0; j < c; j++) {
                if(!v[i][j]){ res++;
                    now = board[i][j];
                    dfs(i, j) ;
                }
            }
        }        
        printf("%d\n",res);
    } 
    return 0;
}