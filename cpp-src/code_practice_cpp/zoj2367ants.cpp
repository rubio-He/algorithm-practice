#include <cstdio>
#include <algorithm>

using namespace std;

int t, n, len, minres, maxres, pos;

int main(){
    scanf("%d", &t);
    while(t--){
        scanf("%d%d", &len, &n);
        minres = -1, maxres = -1;
        for(int i = 0; i < n; i++){
            scanf("%d", &pos);
            
            minres = max(minres, min(pos, len-pos));
            maxres = max(maxres, max(pos, len-pos));
        }
        printf("%d %d\n",minres, maxres);
    }
    return 0;
}