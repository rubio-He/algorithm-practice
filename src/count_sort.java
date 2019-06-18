//计数排序～

public class count_sort {
    public int[] sort(int[] arr){
        int[] res  = new int[arr.length];
        int k  = 100;
        countingsort(arr, res, k);
        return arr;
    }

    public void countingsort(int[] arr, int[] res, int k){
        int[] count = new int[k];
        for(int n : arr){
            count[n] += 1;
        }
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i-1];
        }
        for(int j = arr.length - 1; j >= 0 ; j--){
            int a = arr[j];
            res[count[a] - 1] = a; // 反向填充
            count[a]--;
        }
    }
}