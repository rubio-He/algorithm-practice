#include<cstdio>
#include<cstring>

int r, c, x,y, v[24][24];
char board[24][24];


int dfs(int i, int j) {
    if(i  < 0 || i >= r ||j < 0 || j >= c || v[i][j] || board[i][j] == '#') {
        return 0;
    }
    int res =  1;
    v[i][j] = 1;
    res += dfs(i +1, j);
    res += dfs(i , j +1 );
    res += dfs(i , j -1);
    res += dfs(i -1, j);
     return res;
}

void solve() {
    memset(v, 0, sizeof(v));
    int res = dfs(x,y);
    printf("%d\n", res);
}

int main() {
    while(scanf("%d%d", &c, &r)){
        if(r == 0) break;
        for(int i = 0; i < r; i++) {
            scanf("%s", board[i]);
        }
    
        for(x = 0; x < r; x++) {
            for(y = 0; y < c ; y++)
            {
                if(board[x][y] == '@') {solve(); }
            }
        }
    }
    return 0; 
}
