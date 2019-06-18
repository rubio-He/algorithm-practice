/**
 * Created by Hobbes on 6/20/17.
 */

import java.math.*;

public class additiveNumber {
    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1; i < num.length()/2; i++){
            for(int j = 1; Math.max(j, i) <= n - i - j ;j++){
                if(helper(num, i, j )) return true;
            }
        }
        return false;
    }

    static boolean helper(String num, int i, int j){
        Long first = Long.parseLong(num.substring(0, i));
        Long second = Long.parseLong(num.substring(i, j+i));
        String sum;
        for(int start = i + j; start != num.length(); start += sum.length()){
            second += first;
            first = second - first;
            sum = second.toString();
            if(!num.startsWith(sum,start)) return false;
        }
        return true;

    }

    public static void main(String[] args){

    }
}
