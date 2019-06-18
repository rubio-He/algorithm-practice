import java.util.*;
public class iptoCIDR {
    public static List<String> ipToCIDR(String ip, int range) {
        List<String> res = new LinkedList<>();
        int num = 0;
        String[] iparr = ip.split("\\.");
        for(int i = 0; i < 4; i++) num =  num * 256 +  Integer.valueOf(iparr[i]) ;

        while(range > 0) {
            int zeros = 0;
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) == 0) zeros++;
                else break;
            }

            int thisRange = 1 << zeros;
            int minRange = Math.min(thisRange, range);
            addicdr(num, minRange, res);
            range -= thisRange;
            num += thisRange;
        }
        return res;
    }

    static void addicdr(int ip, int range, List<String> res){
        if(range <= 0) return;
        int i = 0;
        while((1 << i + 1) <= range) i++;
        int prefix = 32 - i;
        int thisRange = 1 << i;
        String toAdd = iptoicdrstr(ip);
        res.add(toAdd + "/" + prefix);
        addicdr(ip + thisRange, range - thisRange, res);


    }

    static String iptoicdrstr(int ip){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 4; j++){
            if(j > 0) sb.insert(0,".");
            sb.insert(0, ip&255);
            ip >>= 8;
        }
        return sb.toString();
    }





    public static void main(String[] args){
        System.out.println(ipToCIDR("255.0.0.7", 10));


    }
}
