#include <cstring>
#include <map>
#include <cstdio>
#include <iostream>
using namespace std;

int t, n, j;
char s1[105], s2[105], s12[210];

int main(){
    //freopen("input.txt", "r", stdin );
    scanf("%d", &t);
    for(int icase = 1; icase <= t; icase++){
        scanf("%d", &n);
        scanf("%s %s %s",s1,s2,s12);
        char str[210];
        memset(str,0,sizeof(str));
        map<string, int> mp;
        mp.clear();
        int cnt = 0;
        while(1){
            cnt++;
            memset(str,0,sizeof(str));
            j = 0;
            for(int i = 0; i < n; i++){
                str[j++] = s2[i]; 
                str[j++] = s1[i]; 
            }
            
            if(!strcmp(str, s12)){
                printf("%d %d\n", icase, cnt);break;
            }

            if(mp[str]){
                printf("%d -1\n", icase ); break;
            }

            mp[str] = 1;
            for(int i = 0; i < n; i++){
                s2[i] = str[i+n]; 
                s1[i] = str[i];
            }

        }
    }
    return 0;
}