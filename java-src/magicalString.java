public class magicalString {
    public static int magicalString(int n) {
        int[] freq = new int[n + 1];
        int[] nums = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 1;
        nums[1] = freq[1] = 1;
        nums[2] = freq[2] = 2;
        nums[3] = freq[3] = 2;
        int j = 3;
        int i = 4;
        int num = 1;
        while(i <= n){
            while(i <= n && freq[j]-- > 0) {
                nums[i++] = num;
            }
            num = num == 1 ? 2 : 1;
            j++;
            freq[j] = nums[j];

        }
        int res = 0;
        for(int k = 0; k <= n ; k++){
            if(nums[k] == 1) res++;
        }
        return res;
    }

    public static void main(String[] args){
        magicalString(9);
    }
}
