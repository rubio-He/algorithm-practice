public class KMP_algorithm {
    static int kmp_matecher(String s, String p){
        int[] prefix = new int[p.length()];
        compute_prefix(prefix, p);
        int matched =0;
        for(int i = 0; i < s.length(); i++){
            while(matched > 0 && s.charAt(i) != p.charAt(matched)){
                matched = prefix[matched - 1];
            }
            if(s.charAt(i) == p.charAt(matched)){
                matched++;
            }
            if(matched == p.length()){
                return i - p.length() + 1;
            }
        }
        return -1;
    }

    static void compute_prefix(int[] pattern, String p){
        int matched = 0;
        for(int i = 1; i < p.length(); i++){
            while(matched>0 && p.charAt(i) != p.charAt(matched)){
                matched = pattern[matched - 1];
            }
            if( p.charAt(i) == p.charAt(matched)){
                matched++;
            }
            pattern[i] = matched;
        }
        System.out.println("pattern");
    }

    public static void main(String[] args){
        System.out.println(kmp_matecher("aaaa","a"));
        System.out.println(kmp_matecher("abaab","aab"));
    }
}
