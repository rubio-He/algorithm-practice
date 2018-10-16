#include "oj.h"
#define mod 100005
char s[5000];
map<string,int> ma;
int flag = 1;
map<string,int>::iterator na;
char change(char a){
    switch(a)
    {
     case 'A':  
        case 'B':  
        case 'C': return '2';  
        case 'D':  
        case 'E':  
        case 'F': return '3';  
        case 'G':  
        case 'H':  
        case 'I': return '4';  
        case 'J':  
        case 'K':  
        case 'L': return '5';  
        case 'M':  
        case 'N':  
        case 'O': return '6';  
        case 'P':  
        case 'R':  
        case 'S': return '7';  
        case 'T':  
        case 'U':  
        case 'V': return '8';  
        case 'W':  
        case 'X':  
        case 'Y': return '9';  
        default : return a;
    }
}


int main(){
    freopen("input.txt","r",stdin);
    int n;
    scanf("%d",&n);
    while(n--){
        string sChange = "";
        scanf("%s", &s);
        for(int i = 0; i < strlen(s); i++){
            if((s[i] >= 'A' && s[i] <= 'Z') ||  (s[i] >= '0' && s[i] <= '9')){
                sChange += change(s[i]);
            }
        }
        ma[sChange]++;

    }

    for(na = ma.begin(); na != ma.end(); na++){
        if(na->second > 1){
            for(int i = 0; i < 7; i++){
                printf("%c", na->first[i]);
                if(i == 2) printf("-");
            }
              printf(" %d\n", na->second);
        }

      
        flag = 0;
    }
    if(flag) printf("No duplicates.\n");
    return 0;
}