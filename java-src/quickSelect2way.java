public class quickSelect2way {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, k, 0, nums.length-1);
    }
    int helper(int[] nums, int k, int l, int r){
        if(k > 0 && k <= r - l + 1){
            int pos = partition(nums, l, r);
            if(pos - l == k - 1) return nums[pos];
            if(pos - l > k - 1) return helper(nums, k, l, pos - l - 1);
            else return helper(nums, k - (pos - l + 1) , pos + 1, r);
        }
        return Integer.MIN_VALUE;
    }
    int partition(int[] arr, int l, int r){
        int x = arr[r] , i = l;
        for(int j = l; j <= r-1; j++){
            if(arr[j] <= x ){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void main(String[] args){
        quickSelect2way sol = new quickSelect2way();
        System.out.print(sol.findKthLargest(new int[]{1,2,3,4,5,6}, 3));
    }
}
