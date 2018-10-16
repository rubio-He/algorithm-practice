#include <cstdio>
#include <iostream>
#include <map>
#include <cstring>
#include <algorithm>
using namespace std;
map<string,int> mp;
char st[110];
char ans[110];
int main(){
    int n;

    while(scanf("%d",&n)!=EOF){
        int mx = -1;
        int k = 0;
        while (!mp.empty()) mp.clear();
        if (n==0) break;
        for (int i = 0; i < n; ++i){
            scanf("%s",st);
            mp[st]++;
            if (mp[st]>k){
                k = mp[st];
                strcpy(ans,st);
            }
        }
        puts(ans);



    }
    return 0;
}