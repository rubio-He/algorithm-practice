import java.util.*;
public  class numberAtom {
    public static String countOfAtoms(String formula) {
        Map<String, Integer> m = new HashMap<>();
        helper(formula, 1, m);
        StringBuilder sb = new StringBuilder();
        LinkedList<String> l = new LinkedList<>();
        for(String s : m.keySet()){
            l.add(s);
        }
        Collections.sort(l);
        for(String s: l) {
            sb.append(s);
            sb.append(m.get(s));
        }
        return sb.toString();
    }

    static void helper(String s , int t, Map<String, Integer> freq){
        int n = s.length();
        int left = 0;
        int right = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') {
                left++;
                if(left == right + 1) index = i;
            }
            else if(s.charAt(i) == ')') {
                right++;
                if (left == right && left != 0) {
                    int sum = 0;
                    int k = i + 1;
                    while (k < n && s.charAt(k) <= '9' && s.charAt(k) >= '0') {
                        sum = sum * 10 + (int) (s.charAt(k++) - '0');
                    }
                    // sum
                    int tt = sum == 0 ? 1 : sum;
                    helper(s.substring(index + 1, i), t * tt, freq);
                }
            }
        }
        int p = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') {
                p++;
                continue;
            }
            else if(s.charAt(i) == ')'){
                p--;
                continue;
            }
            else if(p == 0){
                if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    int k = i + 1;
                    while(k<n &&s.charAt(k) >= 'a' && s.charAt(k) <= 'z'){
                        k++;
                    }
                    String ele = s.substring(i,k);
                    int sum = 0;
                    int kk = k ;
                    while(kk<n &&s.charAt(kk) <= '9' && s.charAt(kk) >= '0'){
                        sum = sum * 10 + (int)(s.charAt(kk++) - '0');
                    }
                    int tt = sum == 0 ? 1 : sum;
                    freq.put(ele,freq.getOrDefault(ele,0) + tt * t);
                }
                else continue;
            }
        }

    }

    public static void main(String[] args){
        countOfAtoms("K4(ON(SO3)2)2");
    }
}
