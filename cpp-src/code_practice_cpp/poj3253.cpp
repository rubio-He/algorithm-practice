#include<stdio.h>
#include<queue>
#define ll long long
using namespace std;
priority_queue<int, vector<int>, greater<int> > q;//小顶堆
int main()
{
    int n;
    ll ans=0;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        int tem;
        scanf("%d",&tem);
        q.push(tem);
    }
    while(1)
    {
        int tem1=q.top();
        q.pop();
        if(q.empty())break;
        int tem2=q.top();
        q.pop();
        ans+=(ll)tem1+tem2;
        q.push(tem1+tem2);
    }
    printf("%lld\n",ans);
}




