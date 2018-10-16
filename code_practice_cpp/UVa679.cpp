#include<cstring>
#include<cstdio>
int main(){
    freopen("input.txt", "r", stdin);   
    int t;
    scanf("%d",&t);
    int D, I;                                                                                                                                                               
    while(t--){
        while(scanf("%d%d", &D,&I) == 2){
            int k = 1;
            for(int i = 0; i < D - 1; i ++){
                if(I%2) {k = k * 2; I =(I+1)/2;}
                else {k = k *2 + 1; I /= 2;}
            } 
            printf("%d\n",k);
        }
    }
    return 0;
}