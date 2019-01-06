#include<cstdio>
#include<iostream>
using namespace std;
#define maxn 105 

int n, m;
char board[maxn][maxn];
int cnt = 0;
int dirs[8][2] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

void dfs(int i, int j){
    if(i>=0&&i<n&&j>=0&&j<m&&board[i][j]=='W'){
        board[i][j] = '.';
        for(int dir = 0; dir < 8; dir++) dfs(i+dirs[dir][0], j+dirs[dir][1]);
    } 
}

int main(){
    freopen("input.txt", "r", stdin);
    scanf("%d%d", &n,&m);
    for(int i = 0; i < n; i++){
        scanf("%s", board[i]);
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(board[i][j]=='W') {cnt++;dfs(i,j);}
        }
    }
    printf("%d",cnt);
    return 0;

    
    
}



