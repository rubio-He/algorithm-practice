/**
 * Created by Hobbes on 7/22/17.
 */
public class reversePairs {
    static int merge(int[] arr, int start, int end){
        if(end <= start + 1 ) return 0;
        int mid = (start + end) / 2;
        int res = merge(arr,start, mid) + merge(arr, mid , end);
        int j = mid, t = mid;
        int[] cache = new int[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (j < end && arr[i] > 2 * arr[j]) j++;
            while (t < end && arr[t] < arr[i]) cache[r++] = arr[t++];
            cache[r] = arr[i];
            res += j - mid;
        }
        System.arraycopy(cache, 0, arr, start, t - start);
        return res;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,3,2,3,1};
        System.out.print(merge(arr,0,5));
    }
}
