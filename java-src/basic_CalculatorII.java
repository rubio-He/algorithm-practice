
import java.util.*;
public class basic_CalculatorII {
    public static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if(s.charAt(i) == '+') {
                sign = 1;
                continue;
            }
            if(s.charAt(i) == '*'){
                sign = 2;
                continue;
            }
            if(s.charAt(i) == '/') {
                sign = 3;
                continue;
            }
            if(s.charAt(i) == ' ') continue;
            int num = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i++) - '0';
            }
                if(sign == 1){
                    stk.push(num);
                }
                if(sign == -1){
                    stk.push(-num);
                }
                if(sign == 2){
                    int a = stk.pop();
                    stk.push(a * num);
                }
                if(sign == 3){
                    int a = stk.pop();
                    stk.push(a/num);
                }

        }
        int res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;

    }

    public static void main(String[] args){
        System.out.print(calculate("0-2147483647"));
    }
}
