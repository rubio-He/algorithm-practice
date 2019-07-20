#include<iostream>
#include<cmath>
#include<cstdio>
#include<cstdlib>
#include<string>
#include<cstring>
#include<algorithm>
#include<vector>
#include<map>
#include<set>
#include<stack>
#include<list>
#include<queue>
#define eps 1e-6
#define INF 0x1f1f1f1f
#define PI acos(-1.0)
#define ll __int64
#define lson l,m,(rt<<1)
#define rson m+1,r,(rt<<1)|1
//#pragma comment(linker, "/STACK:1024000000,1024000000")
using namespace std;

/*
freopen("data.in","r",stdin);
freopen("data.out","w",stdout);
*/
#define Maxn 110
char sa[Maxn];
int dp[Maxn][Maxn],path[Maxn][Maxn]; //dp[i][j]表示区间i~j内需要最少的字符数能够匹配，path[i][j]表示到达该状态是哪种情况，
//-1表示第一个和最后一个，其他表示中间的分段点，然后递归输出
//递归能够改变次序
void output(int l,int r) //递归是个好东西
{
   if(l>r)
      return ;
   if(l==r) //到达了最后
   {
      if(sa[l]=='('||sa[l]==')')
         printf("()");
      else
         printf("[]");
      return ;
   }
   if(path[l][r]==-1) //首尾，先输出开始，然后递归输出中间，最后输出结尾
   {
      putchar(sa[l]);
      output(l+1,r-1);
      putchar(sa[r]);
   }
   else
   {
      output(l,path[l][r]);//直接递归输出两部分
      output(path[l][r]+1,r);
   }
}
int main()
{
   while(gets(sa+1)) //有空串，scanf("%s"),不能读空串，然后少一个回车，会出错
   {
      int n=strlen(sa+1);
      memset(dp,0,sizeof(dp));
      for(int i=1;i<=n;i++)
         dp[i][i]=1; //一个的话只需一个就可以匹配
      for(int gap=1;gap<n;gap++) //枚举区间长度
         for(int i=1;i<=n-gap;i++) //枚举区间开始位置
         {
            int j=i+gap;
            dp[i][j]=INF;
            if((sa[i]=='['&&sa[j]==']')||(sa[i]=='('&&sa[j]==')')) //首尾情况
               if(dp[i+1][j-1]<dp[i][j])
                  dp[i][j]=dp[i+1][j-1],path[i][j]=-1;
            for(int k=i;k<j;k++) //中间分隔情况
               if(dp[i][k]+dp[k+1][j]<dp[i][j])
                  dp[i][j]=dp[i][k]+dp[k+1][j],path[i][j]=k;
         }
      output(1,n);
      putchar('\n');
   }
   return 0;
}