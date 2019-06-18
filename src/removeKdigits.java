/**
 * Created by Hobbes on 7/24/17.
 */
import java.util.*;
public class removeKdigits {


    public static String removeKdigits(String num, int k) {


       char[] stk = new char[num.length()];
       int top = 0;
       for(int i = 0; i < num.length(); i++){
           char c = num.charAt(i);
           while(top > 0 && stk[top-1] > c && k >0 ){
               top -= 1;
               k-=1;
           }
           stk[top++] = c;
       }

       return new String(stk,0,top);





    }

    public static void main(String[] args){
        System.out.print(removeKdigits("10200", 1));
    }


}
