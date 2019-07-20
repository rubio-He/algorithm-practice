
import java.util.*;

public class restoreIP {
    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new LinkedList<>();
        if(s.length() == 0 ) return res;
        helper(s, res , new StringBuilder(), 0, 1, 0);
        return res;
    }

    private static void helper(String s, List<String> res, StringBuilder sb , int i, int j, int num){


        if(j == s.length() && num < 3) return;
        if(num == 4 && j < s.length()) return;
        if(j == s.length() && num == 3){
            if(!isValid(s.substring(i,j))) return;
            sb.deleteCharAt(0);
            sb.append('.');
            sb.append(s.substring(i,j));
            res.add(sb.toString());
            return;
        }


        if( num == 4 && i >= s.length()){
            sb.deleteCharAt(0);
            res.add(sb.toString());
            return;
        }

        for(int x = j ; x <= s.length(); x++){
            if(!isValid(s.substring(i,x))) continue;
            else{
                StringBuilder sb2 = new StringBuilder(sb.toString());
                sb2.append('.');
                sb2.append(s.substring(i,x));
                helper(s, res , sb2, x, x + 1 , num+1);
            }

        }


    }
    private static boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }



    public static void main(String[] args){

        restoreIpAddresses("010010");
    }
}