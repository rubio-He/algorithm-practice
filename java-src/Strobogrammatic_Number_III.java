public class Strobogrammatic_Number_III {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;
    public int strobogrammaticInRange(String low, String high) {
        for(int i = low.length(); i <= high.length(); i++){
            char[] c = new char[i];
            helper(0,i-1,c,low,high);
        }
        return count;
    }

    void helper(int left, int right, char[] c, String low, String high){
        if(left > right){
            String s = new String(c);
            if((c.length == low.length() && low.compareTo(s) > 0) ||
                    (c.length == high.length() && high.compareTo(s) < 0) )return;
            else
                count++;
            return;
        }
        for(char[] p : pairs){
            c[left] = p[0];
            c[right] = p[1];

            if(left == right && p[0] != p[1]) continue;
            if(c.length != 1 && c[0] == '0') continue;
            helper(left +1, right -1, c, low, high);
        }
    }
}
