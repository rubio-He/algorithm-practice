/**
 * Created by Hobbes on 7/25/17.
 */

import java.util.*;
public class largestNumber {
    public static String larNum(int[] nums) {
        String[] res = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(res,new Comparator<String>(){
            public int compare(String a, String b){
                int alen = a.length();
                int blen = b.length();
                int total = alen + blen;
                int i = 0 ,j = 0;
                for(int k = 0; k < total; k++, i++, j++){
                    if(i == alen) i = 0;
                    if(j == blen) j = 0;
                    if(a.charAt(i) < b.charAt(j)) return 1;
                    if(a.charAt(i) > b.charAt(j)) return -1;
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str: res){
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{12,121};
        System.out.print(larNum(nums));
    }

}