import java.util.*;
public class Fraction_toRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        if(numerator == 0) return "0";
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long de = Math.abs((long)(denominator));
        Map<Long, Integer>  map = new HashMap<>();
        long quot = num / de;
        long resd = num % de;

        res.append(quot);
        if(resd == 0) return res.toString();
        res.append('.');
        num = resd;
        map.put(num, res.length());
        while(num !=0 ){
            num *= 10;
            quot = num / de;
            resd = num % de;
            res.append(quot);
            num = resd;
            if(map.containsKey(num)){
                int index = map.get(num);
                res.insert(index, '(');
                res.append(")");
                break;
            }
            else map.put(num, res.length());
        }
        return res.toString();
    }

    public static void main(String[] args){
        System.out.println(fractionToDecimal(4,333));
    }


}
