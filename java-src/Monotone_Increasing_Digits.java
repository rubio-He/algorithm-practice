import java.util.*;
public class Monotone_Increasing_Digits {
    public int monotoneIncreasingDigits(int N) {
        List<Integer> n = helper(N);
        int len = n.size();
        if(len == 1) return N;
        boolean flag = true;
        int res = 0;
        int i = 0;
        for(; i < len - 1; i++){
            if(n.get(i + 1) - n.get(i) < 0){
                res *= (int)Math.pow(10, len - i);
                res += Math.pow(10,len-i-1)*n.get(i)-1;
                return monotoneIncreasingDigits(res);
            }
            else{
                res = res * 10 + n.get(i);
            }
        }
        if(i == len - 1) res = res*10 + n.get(i);
        return res;
    }

    List<Integer> helper(int n){
        List<Integer> res = new ArrayList<>();
        while(n!=0){
            res.add(0,n%10);
            n/=10;
        }
        return res;
    }

    public static void main(String[] args){
        Monotone_Increasing_Digits sol = new Monotone_Increasing_Digits();
        System.out.print(sol.monotoneIncreasingDigits(332));
    }
}
