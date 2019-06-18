import java.util.*;

public class basic_Calculator {
        public static int calculate(String s) {
            Stack<String> stk = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isDigit(c) || c == '(' || c == '+' || c == '-'){
                    stk.push(Character.toString(c));
                }
                else if(c == ')'){
                    StringBuilder sb = new StringBuilder();
                    while(!stk.peek().equals("(")){
                        sb.insert(0,stk.pop());
                    }
                    stk.pop();
                    int res = calc(sb.toString());
                    stk.push(Integer.toString(res));
                }
            }
            if(stk == null) return 0;
            StringBuilder sb = new StringBuilder();
            while(!stk.isEmpty()){
                sb.insert(0,stk.pop());
            }
            return calc(sb.toString());

        }


        public static int calc(String str){
            int ptr = 0;
            int sum = 0;
            int num = 0;
            Character symb = '+';
            for(; ptr < str.length(); ptr++){
                num = 0;
                while(ptr < str.length() && Character.isDigit(str.charAt(ptr))){
                    num = str.charAt(ptr) - '0' + num*10;
                    ptr++;
                }
                if(symb == '+') sum += num;
                else sum -= num;
                if(ptr < str.length()) symb = str.charAt(ptr);
            }
            return sum;
        }


        public static void main(String[] args){
            System.out.print(calc("5-6"));
        }
}
