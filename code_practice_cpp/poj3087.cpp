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
#define PTI(x) printf("%d\n", x)
#define FOR(x,y,z) for(int x = (y); x < (z); x++)
#define FORR(x,y,z) for(int x = (y); x >= (z); x--) 
#define MS0(x) memset(x, 0, sizeof(x))
#define MS1(x) memset(x, 1, sizeof(x))
#define N 110
int t;
char s[2*N], s1[N],s2[N];
int n, icase = 0;
int main(){
	// freopen("input.txt", "r", stdin);
	RDI(t);
	while(t--){
		icase++;
		map<string, int> mp;
		RDI(n);
		mp.clear();
		scanf("%s %s %s", s1, s2, s);
		char str[N * 2];
		int cnt = 0;
		while(1){
			cnt++;
			MS0(str); 
			int j = 0; 
			FOR(i,0, n){
			 	str[j++] = s2[i];
			 	str[j++] = s1[i]; 
			} 
			if(!strcmp(str, s)){
				printf("%d %d\n", icase, cnt);
				break;
			}
			if(mp[str]){
				printf("%d -1\n",icase);
                break;
			}
			mp[str] = 1;

			FOR(i,0,n){
				s1[i] = str[i];
			}
			FOR(i,0,n){
				s2[i] = str[i + n];
			}

		}



	}
	return 0;
}